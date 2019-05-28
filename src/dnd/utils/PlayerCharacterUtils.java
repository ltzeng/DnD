package dnd.utils;

import java.io.IOException;

import javax.servlet.ServletContext;

import dnd.domain.character.PlayerCharacter;

public class PlayerCharacterUtils {
	PlayerCharacterParser pcu = new PlayerCharacterParser();
	
	public PlayerCharacter getCharacter(String characterFileName, ServletContext servlet) {
		PlayerCharacter pc = pcu.getCharacter(characterFileName, servlet);
		return pc;
	}

	public void modifyAbilityScores(PlayerCharacter pc){
		
		String newScores="abilityScores:" + pc.getAbilityScores().getEditableValues();
		
		FileReaderUtil frs = new FileReaderUtil();
		String fileName = "characters\\" + pc.getCharacterFileName();
		try {
			frs.removeAndAddLine("abilityScores", newScores, fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
