package dnd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dnd.domain.character.AbilityScores;
import dnd.domain.character.PlayerCharacter;
import dnd.domain.character.classes.Cleric;
import dnd.domain.character.classes.Fighter;
import dnd.domain.character.classes.Rogue;
import dnd.domain.character.classes.Wizard;
import dnd.domain.character.equipment.Armor;
import dnd.domain.character.equipment.Currency;
import dnd.domain.character.equipment.Weapon;

public class PlayerCharacterDAO {

	private Connection connection;

	private Connection getConnection() {

		if(connection==null) {
			try {
				Class.forName("org.postgresql.Driver"); 
				connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dnd", "postgres", "1234ABcd");
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
	
	public PlayerCharacter getPCEquipment(PlayerCharacter pc) {
		try {

			List<Armor> armorList = getPlayerArmorList(pc);
			pc.setArmors(armorList);
			
			List<Weapon> weaponList = getPlayerWeaponList(pc);
			pc.setWeapons(weaponList);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pc;
		
	}
	
	private List<Weapon> getPlayerWeaponList(PlayerCharacter pc) throws SQLException {
		String sql = "SELECT * "
				+ "FROM Character_Weapon cw "
				+ "INNER JOIN Weapons_List al on cw.weapon_id=al.weapon_id "
				+ "WHERE character_id = ?";
		
		PreparedStatement statement = getConnection().prepareStatement(sql);
		statement.setInt(1, pc.getCharacterID());

		ResultSet rs = statement.executeQuery();
		List<Weapon> weaponList = new ArrayList<Weapon>();
		while (rs.next()) {
			weaponList.add(makeWeapon(rs));
		}
		return weaponList;
	}

	private Weapon makeWeapon(ResultSet rs) throws SQLException {
		Weapon weapon = new Weapon();
		weapon.setWeaponID(rs.getInt("weapon_id"));
		weapon.setName(rs.getString("weapon_name"));
		weapon.setDamage(rs.getString("damage"));
		weapon.setWeight(rs.getDouble("weight"));
		weapon.setCost(rs.getInt("cost"));
		weapon.setProperties(rs.getString("properties"));
		weapon.setType(rs.getString("type"));
		
		return weapon;
	}

	public List<Armor> getPlayerArmorList(PlayerCharacter pc) throws SQLException{
		
		String sql = "SELECT * "
				+ "FROM Character_Armor ca "
				+ "INNER JOIN Armor_List al on ca.armor_id=al.armor_id "
				+ "WHERE character_id = ?";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		statement.setInt(1, pc.getCharacterID());

		ResultSet rs = statement.executeQuery();
		List<Armor> armorList = new ArrayList<Armor>();
		while (rs.next()) {
			armorList.add(makeArmor(rs));
		}
		return armorList;
	}

	private Armor makeArmor(ResultSet rs) throws SQLException {
		Armor armor = new Armor();
		armor.setArmorID(rs.getInt("armor_id"));
		armor.setName(rs.getString("armor_name"));
		armor.setArmorClass(rs.getString("armor_class"));
		armor.setCost(rs.getInt("cost"));
		armor.setStrength(rs.getString("strength"));
		armor.setWeight(rs.getInt("weight"));
		armor.setStealth(rs.getString("stealth"));
		armor.setType(rs.getString("type"));
		return armor;
	}

	public PlayerCharacter getPlayerCharacterByID(int characterID) {

		PlayerCharacter pc = null;
		try {

			String sql = "SELECT * "
					+ "FROM Player_Character pc "
					+ "INNER JOIN Ability_Scores ascore ON pc.character_id=ascore.character_id "
					+ "INNER JOIN Currency c on c.character_id=pc.character_id "
					+ "WHERE pc.character_id = ?";
			
			PreparedStatement statement = getConnection().prepareStatement(sql);
			statement.setInt(1, characterID);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				pc = setupPlayer(rs);
				pc = addCurrency(rs, pc);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pc;
	}
	public List<PlayerCharacter> getPlayerCharactersByAdventureID(int adventureID) {
		List<PlayerCharacter> characterList = new ArrayList<PlayerCharacter>();
		try {

			String sql = "SELECT * "
					+ "FROM Player_Character pc "
					+ "INNER JOIN Ability_Scores ascore ON pc.character_id=ascore.character_id "
					+ "LEFT OUTER JOIN Character_Spell_Slots css ON pc.character_id=css.character_id "
					+ "WHERE pc.adventure_id = ?";

			PreparedStatement statement = getConnection().prepareStatement(sql);
			statement.setInt(1, adventureID);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				PlayerCharacter pc = setupPlayer(rs);
				characterList.add(pc);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return characterList;
	}

	private PlayerCharacter addCurrency(ResultSet rs, PlayerCharacter pc) throws SQLException {
		Currency currency = new Currency();
		pc.setCurrency(currency);
		pc.getCurrency().setCopperPieces(rs.getInt("copper_pieces"));
		pc.getCurrency().setSilverPieces(rs.getInt("silver_pieces"));
		pc.getCurrency().setGoldPieces(rs.getInt("gold_pieces"));
		pc.getCurrency().setElectrumPieces(rs.getInt("electrum_pieces"));
		pc.getCurrency().setPlatinumPieces(rs.getInt("platinum_pieces"));
		return pc;
	}

	private PlayerCharacter setupPlayer(ResultSet rs) throws SQLException {
		String characterClass = rs.getString("character_class");
		PlayerCharacter pc = getPlayerCharacterClass(characterClass, rs.getInt("level"));
		pc.setCharacterID(rs.getInt("character_id"));
		pc.setAdventureID(rs.getInt("adventure_id"));
		pc.setCharacterName(rs.getString("character_name"));
		pc.setBackground(rs.getString("background"));
		pc.setAlignment(rs.getString("alignment"));
		pc.setExp(rs.getInt("exp"));
		pc.setLevel(rs.getInt("level"));
		pc.setMaxHp(rs.getInt("maxHP"));
		pc.setHp(rs.getInt("hp"));
		pc.setGender(rs.getString("gender"));
		pc.setCharacterClass(characterClass);
		pc.setRace(rs.getString("race"));
		pc.setSpeed(rs.getInt("speed"));
		pc.setInitiative(rs.getInt("initiative"));
		pc.setArmorClass(rs.getInt("armorClass"));
		pc.setTempHP(rs.getInt("tempHP"));

		int[] abilityScores = {rs.getInt("str"),rs.getInt("dex"),rs.getInt("con"),rs.getInt("intel"),rs.getInt("wis"),rs.getInt("cha")};
		pc.setAbilityScores(new AbilityScores(abilityScores));
		
		if(pc.getSpellSlots()!=null) {
			pc.getSpellSlots().setSpellSlot1(rs.getInt("spell_slot_1"));
			pc.getSpellSlots().setSpellSlot2(rs.getInt("spell_slot_2"));
			pc.getSpellSlots().setSpellSlot3(rs.getInt("spell_slot_3"));
			pc.getSpellSlots().setSpellSlot4(rs.getInt("spell_slot_4"));
			pc.getSpellSlots().setSpellSlot5(rs.getInt("spell_slot_5"));
			pc.getSpellSlots().setSpellSlot6(rs.getInt("spell_slot_6"));
			pc.getSpellSlots().setSpellSlot7(rs.getInt("spell_slot_7"));
			pc.getSpellSlots().setSpellSlot8(rs.getInt("spell_slot_8"));
			pc.getSpellSlots().setSpellSlot9(rs.getInt("spell_slot_9"));
		}
		
		return pc;
	}



	private PlayerCharacter getPlayerCharacterClass(String characterClass, int level) {
		PlayerCharacter pc = null;
		switch(characterClass) {
		case "Fighter":
			pc=new Fighter();
			break;
		case "Wizard":
			pc=new Wizard(level);
			break;
		case "Rogue":
			pc=new Rogue();
			break;
		case "Cleric":
			pc=new Cleric(level);
			break;
		}
		return pc;
	}

	public void updatePlayerHP(int playerID, int hp) throws SQLException {

		String sql = "UPDATE Player_Character " +
				"SET hp = ? " + 
				"WHERE character_id = ? ";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		statement.setInt(1, hp);
		statement.setInt(2, playerID);

		statement.executeUpdate();

//		closeConnection();
	}
}

