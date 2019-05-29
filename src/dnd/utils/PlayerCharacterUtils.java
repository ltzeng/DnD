package dnd.utils;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import dnd.domain.character.PlayerCharacter;

public class PlayerCharacterUtils {
	PlayerCharacterParser pcu = new PlayerCharacterParser();
	FileReaderUtil frs = new FileReaderUtil();
	
	public PlayerCharacter getCharacter(String characterFileName, ServletContext servlet) {
		PlayerCharacter pc = pcu.getCharacter(characterFileName, servlet);
		return pc;
	}

	public void modifyAbilityScores(PlayerCharacter pc){
		
		String newScores="abilityScores:" + pc.getAbilityScores().getEditableValues();
		
		
		String fileName = UtilConstants.FILE_PATH_PREFIX + pc.getCharacterFileName();
		try {
			frs.removeAndAddLine("abilityScores", newScores, fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<String> getCharacterNames(ServletContext context){
		
		FileReaderUtil frs = new FileReaderUtil();
		String fileName = UtilConstants.FILE_PATH_PREFIX + "AllCharacters";
		List<String> characterNames = null;
		try {
			characterNames=frs.servletReadFile(fileName, context);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return characterNames;
	}
}
