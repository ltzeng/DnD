package dnd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dnd.adventure.Adventure;
import dnd.encounter.Encounter;

public class AdventureDAO {

    private Connection connection;

    private Connection getConnection() {

        try {
            Class.forName("org.postgresql.Driver"); 
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dnd", "postgres", "1234ABcd");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Adventure> getAdventures() throws SQLException {
        String sql = "SELECT * " + 
                "FROM Adventure  " ;

        List<Adventure> adventures = new ArrayList<Adventure>();
        PreparedStatement statement = getConnection().prepareStatement(sql);

        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            Adventure adv = new Adventure();
            adv.setAdventureID(rs.getInt("adventure_id"));
            adv.setDescription(rs.getString("adventure_desc"));
            adventures.add(adv);
        }

        closeConnection();
        
        return adventures;
    }

}
