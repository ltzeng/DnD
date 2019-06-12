package dnd.utils;

import java.sql.SQLException;
import java.util.List;

import dnd.dao.PlayerCharacterDAO;
import dnd.domain.character.PlayerCharacter;

public class PlayerCharacterUtils {

	PlayerCharacterDAO pcDao = new PlayerCharacterDAO();
	
	public PlayerCharacter getCharacter(int characterID) {
		PlayerCharacter pc = pcDao.getPlayerCharacterByID(characterID);
		return pc;
	}
	
	public List<PlayerCharacter> getCharacterForAdventure(int adventureID) {
		List<PlayerCharacter> pcList = pcDao.getPlayerCharactersByAdventureID(adventureID);
		return pcList;
	}

	public void modifyAbilityScores(PlayerCharacter pc){
		
	}
	
	public void updatePlayerHP(int playerID, int hp) {
		try {
			pcDao.updatePlayerHP(playerID, hp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
