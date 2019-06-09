package dnd.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import dnd.domain.character.AbilityScores;
import dnd.domain.character.PlayerCharacter;
import dnd.domain.character.classes.Cleric;
import dnd.domain.character.classes.Fighter;
import dnd.domain.character.classes.Rogue;
import dnd.domain.character.classes.Wizard;

public class PlayerCharacterDAOTest {

	private Connection connection;
	
	@Before
	public void getConnection() {

		if(connection==null) {
			try {
				connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dnd", "postgres", "1234ABcd");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		assertNotNull(connection);
	}
	
	@Test
	public void getCharacter() {
		PlayerCharacter pc = null;
		try {

			String sql = "SELECT * "
					+ "FROM Player_Character pc "
					+ "INNER JOIN Ability_Scores ascore ON pc.character_id=ascore.character_id "
					+ "WHERE pc.character_id = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, 1);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				pc = setupPlayer(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		assertTrue(pc.getCharacterName().equals("Joy-llusion"));
	}
	
	
	private PlayerCharacter setupPlayer(ResultSet rs) throws SQLException {
		String characterClass = rs.getString("character_class");
		PlayerCharacter pc = getPlayerCharacterClass(characterClass);
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

		int[] abilityScores = {rs.getInt("str"),rs.getInt("dex"),rs.getInt("con"),rs.getInt("intel"),rs.getInt("wis"),rs.getInt("cha")};
		pc.setAbilityScores(new AbilityScores(abilityScores));

		return pc;
	}
	
	private PlayerCharacter getPlayerCharacterClass(String characterClass) {
		PlayerCharacter pc = null;
		switch(characterClass) {
		case "Fighter":
			pc=new Fighter();
			break;
		case "Wizard":
			pc=new Wizard(1);
			break;
		case "Rogue":
			pc=new Rogue();
			break;
		case "Cleric":
			pc=new Cleric(1);
			break;
		}
		return pc;
	}
	
}
