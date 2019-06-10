package dnd.utils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import dnd.dao.BattleTrackerDAO;
import dnd.dao.MonsterDAO;
import dnd.domain.character.PlayerCharacter;
import dnd.encounter.Encounter;
import dnd.encounter.EncounterMonster;
import dnd.monster.Monster;

public class EncounterUtils {

	private BattleTrackerDAO btDAO = new BattleTrackerDAO();
	private MonsterDAO monDAO = new MonsterDAO();
	
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

	public List<EncounterMonster> getEncounterEnemies(int encounterID) {
		
		List<EncounterMonster> monsterList = null;
		try {
			monsterList = btDAO.getEncounterEnemies(encounterID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return monsterList;
	}

    public int updateEncounterStatus(boolean updateStatus, int encounterID) {
        int success = -1;
        try {
            success = btDAO.updateEncounterStatus(updateStatus, encounterID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }
    
    public List<Monster> getAllEnemies(){
    	
    	List<Monster> monList = monDAO.getAllMonsters();
    	
		return monList;
    }
}
