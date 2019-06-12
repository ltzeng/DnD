package dnd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.monitor.Monitor;

import dnd.domain.character.PlayerCharacter;
import dnd.encounter.EncounterMonster;
import dnd.monster.Monster;
import dnd.monster.MonsterAction;
import dnd.monster.MonsterSkill;

public class MonsterDAO {

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
	
	public List<Monster> getAllMonsters() {

		List<Monster> monList = new ArrayList<Monster>();
		try {

			String sql = "SELECT * FROM Monster m ";
			
			PreparedStatement statement = getConnection().prepareStatement(sql);

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Monster mon = new Monster();
				mon.setName(rs.getString("name"));
				mon.setMonsterID(rs.getInt("monster_id"));
				mon.setArmorClass(rs.getString("armor_class"));
				mon.setDescription(rs.getString("description"));
				mon.setHitPoints(rs.getString("hit_points"));
				mon.setSpeed(Integer.parseInt(rs.getString("speed")));
				mon.setSavingThrows(rs.getString("saving_throws"));
				mon.setSkills(rs.getString("skills"));
				mon.setLanguages(rs.getString("languages"));
				mon.setChallenge(rs.getString("challenge"));
				
				monList.add(mon);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return monList;
	}
	
	public EncounterMonster getMonsterSkills(EncounterMonster mon) throws SQLException {

		String sql = "SELECT * FROM Monster m " + 
				"INNER JOIN Monster_Skill ms on m.monster_id=ms.monster_id " +
				"WHERE m.monster_id = ? ";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		statement.setInt(1, mon.getMonsterID());
		ResultSet rs = statement.executeQuery();

		List<MonsterSkill> skillsList = new ArrayList<MonsterSkill>();
		while (rs.next()) {
			MonsterSkill ms = new MonsterSkill();
			ms.setSkillName(rs.getString("skill_name"));
			ms.setSkillDescription(rs.getString("skill_desc"));
			skillsList.add(ms);
		}
		mon.setMonsterSkills(skillsList);
		
		return mon;
	}

	public EncounterMonster getMonsterAbilities(EncounterMonster mon) throws SQLException {

		String sql = "SELECT * FROM Monster m " + 
				"LEFT OUTER JOIN Monster_Action ma on m.monster_id=ma.monster_id " +
				"WHERE m.monster_id = ? ";

		PreparedStatement statement = getConnection().prepareStatement(sql);
		statement.setInt(1, mon.getMonsterID());

		ResultSet rs = statement.executeQuery();

		List<MonsterAction> actionsList = new ArrayList<MonsterAction>();
		while (rs.next()) {
			MonsterAction ma = new MonsterAction();
			ma.setActionName(rs.getString("action_name"));
			ma.setActionDescription(rs.getString("action_desc"));
			actionsList.add(ma);
		}
		mon.setMonsterActions(actionsList);
		
		return mon;
	}
}
