package dnd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dnd.domain.character.PlayerCharacter;

public class MonsterDAO {

//	private Connection connection;
//
//	private Connection getConnection() {
//
//		if(connection==null) {
//			try {
//				Class.forName("org.postgresql.Driver"); 
//				connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dnd", "postgres", "1234ABcd");
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}
//		}
//		return connection;
//	}
//	
//	public PlayerCharacter getMonsterByID(int monsterID) {
//
//		PlayerCharacter pc = null;
//		try {
//
//			String sql = "SELECT * "
//					+ "FROM Player_Character pc "
//					+ "INNER JOIN Ability_Scores ascore ON pc.character_id=ascore.character_id "
//					+ "WHERE pc.character_id = ?";
//			
//			PreparedStatement statement = getConnection().prepareStatement(sql);
//			statement.setInt(1, characterID);
//
//			ResultSet rs = statement.executeQuery();
//
//			while (rs.next()) {
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return pc;
//	}
}
