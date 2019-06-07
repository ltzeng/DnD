package dnd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import dnd.domain.character.PlayerCharacter;
import dnd.encounter.ActorEncounterDetails;
import dnd.encounter.Encounter;

public class BattleTrackerDAO {

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
	
	public Encounter getEncounter(int adventureID) throws SQLException {
		String sql = "SELECT * FROM Encounter e " + 
				"WHERE adventure_id = ? AND active = true;";
		
		PreparedStatement statement = getConnection().prepareStatement(sql);
		statement.setInt(1, adventureID);

		ResultSet rs = statement.executeQuery();
		Encounter e = null;
		while (rs.next()) {
			e=new Encounter();
			e.setTurn(rs.getInt("turn"));
			e.setOverallTurn(rs.getInt("overall_turn"));
			e.setEncounterID(rs.getInt("encounter_id"));
			e.setDescription(rs.getString("description"));
			e.setUpdated(rs.getBoolean("updated"));
		}
		
		return e;
	}
	
	public Map<Integer, PlayerCharacter> getEncounterDetailsForPlayers(int adventureID, Map<Integer, PlayerCharacter> pcMap) throws SQLException {
		String sql = "SELECT * FROM Encounter e " + 
				"INNER JOIN Encounter_Character ec on e.encounter_id=ec.encounter_id " + 
				"WHERE adventure_id = ? AND active = true;";
		
		PreparedStatement statement = getConnection().prepareStatement(sql);
		statement.setInt(1, adventureID);

		ResultSet rs = statement.executeQuery();
		
		while (rs.next()) {
			int characterID = rs.getInt("character_id");
			pcMap.get(characterID).setEncounterDetails(createPlayerEncounterDetails(rs));
		}
		
		return pcMap;
	}

	private ActorEncounterDetails createPlayerEncounterDetails(ResultSet rs) throws SQLException {
		ActorEncounterDetails ped = new ActorEncounterDetails();
		ped.setEncounterID(rs.getInt("encounter_id"));
		ped.setStatus(rs.getString("status"));
		ped.setInitiative(rs.getInt("initiative"));
		ped.setDeathFailure(rs.getInt("death_failure"));
		ped.setDeathSuccess(rs.getInt("death_success"));
		return ped;
		
	}

	public boolean checkEncounterUpdated(int adventureID) throws SQLException {
		Encounter encounter = getEncounter(adventureID);
		if(encounter==null) {
			return false;
		}
		return encounter.getUpdated();
	}

    public int updateEncounterStatus(boolean updateStatus, int encounterID) throws SQLException {

        String sql = "UPDATE Encounter " +
                "SET updated = ? " + 
                "WHERE encounter_id = ? ";
        
        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setBoolean(1, updateStatus);
        statement.setInt(2, encounterID);
        
        int success = statement.executeUpdate();
        return success;
    }
}
