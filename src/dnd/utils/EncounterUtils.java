package dnd.utils;

import java.sql.SQLException;
import java.util.ArrayList;
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

	public void addPlayerToEncounter(int encounterID, int playerID, int playerInitiative) {

		try {
			btDAO.addPlayerToEncounter(encounterID, playerID, playerInitiative);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addMonsterToEncounter(int encounterID, int monsterID, int monsterInitiative, int hp, String typeColor) {
		
		try {
			btDAO.addMonsterToEncounter(encounterID, monsterID, monsterInitiative, hp, typeColor);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int createEncounter(int adventureID, String description) {
		Integer encounterID = null;
		try {
			encounterID = btDAO.createEncounter(adventureID, description);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return encounterID;
	}

	public void endEncounter(int encounterID) {
		try {
			btDAO.endEncounter(encounterID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

    public void setToNextTurn(int encounterID, int turn, int overallTurn) {

        try {
            btDAO.increaseTurn(encounterID, turn, overallTurn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public List<EncounterMonster> getMonsterSkills(List<EncounterMonster> monsterList) {

		List<EncounterMonster> updatedMonsterList = new ArrayList<EncounterMonster>();
		for(EncounterMonster mon : monsterList) {
			try {
				mon = monDAO.getMonsterSkills(mon);
				mon = monDAO.getMonsterAbilities(mon);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			updatedMonsterList.add(mon);
		}
		return updatedMonsterList;
	}

	public void setEncounterTotalTurns(int encounterID, int totalFighters) {

		try {
			btDAO.setEncounterTotalTurns(encounterID, totalFighters);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateMonsterHP(int monsterID, int hpUpdate) {

		try {
			btDAO.updateMonsterHP(monsterID, hpUpdate);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
