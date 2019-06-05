package dnd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SampleDAO {

	public static void main(String[] args) {

		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dnd", "postgres", "1234ABcd")) {
			 
            // When this class first attempts to establish a connection, it automatically loads any JDBC 4.0 drivers found within 
            // the class path. Note that your application must manually load any JDBC drivers prior to version 4.0.
//          Class.forName("org.postgresql.Driver"); 
 
			String sql = "SELECT * "
					+ "FROM Player_Character pc "
					+ "INNER JOIN Ability_Scores as ascore on pc.character_id=ascore.character_id";
            System.out.println("Connected to PostgreSQL database!");
            PreparedStatement statement = connection.prepareStatement(sql);
            System.out.println("Reading car records...");
            System.out.printf("%-30.30s  %-30.30s%n", "character_id", "chMaracter_name");
//            ResultSet resultSet = statement.executeQuery("SELECT * FRO Player_Character");
            ResultSet resultSet = statement.executeQuery();;
            while (resultSet.next()) {
                System.out.printf("%-30.30s  %-30.30s%n", resultSet.getString("character_id"), resultSet.getString("character_name"));
            }
 
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
	}

}
