package dnd.domain.character.classes;

import java.util.ArrayList;
import java.util.List;

import dnd.domain.character.PlayerCharacter;

public class Wizard extends PlayerCharacter{

	public Wizard() {
		List<String> proficiencies = new ArrayList<String>();
		proficiencies.add("Daggers");
		proficiencies.add("Darts");
		proficiencies.add("Slings");
		proficiencies.add("Quarterstaffs");
		proficiencies.add("Light Crossbows");
		setProficiencies(proficiencies);
		setHitDice("d6");
	}
}
