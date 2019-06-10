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
import dnd.monster.Monster;

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

			String sql = "SELECT * FROM Monster";
			
			PreparedStatement statement = getConnection().prepareStatement(sql);

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Monster mon = new Monster();
				mon.setName(rs.getString("name"));
				mon.setMonster_id(rs.getInt("monster_id"));
				monList.add(mon);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return monList;
	}
}