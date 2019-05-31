package dnd.domain.character.classes;

import java.util.ArrayList;
import java.util.List;

import dnd.domain.character.PlayerCharacter;

public class Cleric extends PlayerCharacter{

	public Cleric() {
		List<String> proficiencies = new ArrayList<String>();
		proficiencies.add("Light Armor");
		proficiencies.add("Medium Armor");
		proficiencies.add("Shields");
		proficiencies.add("Simple Weapons");
		proficiencies.add("Martial Weapons");
		setProficiencies(proficiencies);
		setHitDice("d8");
	}
}
