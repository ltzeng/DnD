package dnd.utils;

import java.sql.SQLException;
import java.util.Map;

import dnd.dao.BattleTrackerDAO;
import dnd.domain.character.PlayerCharacter;
import dnd.encounter.Encounter;

public class EncounterUtils {

	private BattleTrackerDAO btDAO = new BattleTrackerDAO();
	public Map<Integer, PlayerCharacter> getEncounterPlayers(int adventureID, Map<Integer, PlayerCharacter> pcMap) {
		
		try {
			pcMap=btDAO.getEncounterDetailsForPlayers(adventureID, pcMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pcMap;
	}
	
	public Encounter getEncounter(int adventureID) {
		Encounter encounter = null;
		try {
			encounter=btDAO.getEncounter(adventureID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return encounter;
	}

	public boolean checkEncounterUpdated(int adventureID) {
		boolean updated = false;
		try {
			updated=btDAO.checkEncounterUpdated(adventureID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updated;
		
	}
}
