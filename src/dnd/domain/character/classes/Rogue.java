package dnd.domain.character.classes;

import java.util.ArrayList;
import java.util.List;

import dnd.domain.character.PlayerCharacter;

public class Rogue extends PlayerCharacter{

	public Rogue() {
		List<String> proficiencies = new ArrayList<String>();
		proficiencies.add("Light Armor");
		proficiencies.add("Simple Weapons");
		proficiencies.add("Hand Crossbows");
		proficiencies.add("Longswords");
		proficiencies.add("Rapiers");
		proficiencies.add("Shortswords");
		setProficiencies(proficiencies);
		setHitDice("d8");
	}
}
