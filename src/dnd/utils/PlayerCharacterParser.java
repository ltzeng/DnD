package dnd.utils;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import dnd.domain.character.AbilityScores;
import dnd.domain.character.PlayerCharacter;

public class PlayerCharacterParser {

	public PlayerCharacter getCharacter(String name, ServletContext servlet) {
		
		PlayerCharacter character = null;
		List<String> charDetails = getCharacterDetails(name, servlet);
		character = translateCharDetails(charDetails);
		character.setCharacterFileName(name);
		
		return character;
	}
	
	protected PlayerCharacter translateCharDetails(List<String> charDetails) {
		
		PlayerCharacter playerCharacter = new PlayerCharacter();
		System.out.println(charDetails);
		if(charDetails!=null) {
			for(String line : charDetails) {
				addPlayerAttribute(line, playerCharacter);
			}
		}
		return playerCharacter;
	}

	private void addPlayerAttribute(String line, PlayerCharacter playerCharacter) {

		String[] nodes = line.split(":");
		switch(nodes[0]) {
		case "characterName":
			playerCharacter.setCharacterName(nodes[1]);
			break;
		case "background":
			playerCharacter.setBackground(nodes[1]);
			break;
		case "alignment":
			playerCharacter.setAlignment(nodes[1]);
			break;
		case "exp":
			playerCharacter.setExp(Integer.parseInt(nodes[1]));
			break;
		case "level":
			playerCharacter.setLevel(Integer.parseInt(nodes[1]));
			break;
		case "maxHp":
			playerCharacter.setMaxHp(Integer.parseInt(nodes[1]));
			break;
		case "hp":
			playerCharacter.setHp(Integer.parseInt(nodes[1]));
			break;
		case "gender":
			playerCharacter.setGender(nodes[1]);
			break;
		case "adjective":
			playerCharacter.setAdjective(nodes[1]);
			break;
		case "class":
			playerCharacter.setCharacterClass(nodes[1]);
			break;
		case "abilityScores":
			String[] characterScores = nodes[1].split(",");
			int[] asArr = new int[characterScores.length];
			for(int x=0; x<characterScores.length; x++) {
				asArr[x]=Integer.parseInt(characterScores[x]);
			}
			AbilityScores as = new AbilityScores(asArr);
			playerCharacter.setAbilityScores(as);
			break;
		}
	}

	protected List<String> getCharacterDetails(String name, ServletContext servlet){
		FileReaderUtil fru = new FileReaderUtil();
		List<String> characterDetails = null;
		try {
			 characterDetails = fru.servletReadFile(UtilConstants.FILE_PATH_PREFIX+name, servlet);
		} catch (IOException e) {
			System.out.println("cannot find character");
			return null;
		}
		return characterDetails;
	}
}
