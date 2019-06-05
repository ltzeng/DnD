package dnd.utils;

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
	
}
