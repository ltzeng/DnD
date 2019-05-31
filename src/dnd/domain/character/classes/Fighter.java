package dnd.domain.character.classes;

import java.util.ArrayList;
import java.util.List;

import dnd.domain.character.PlayerCharacter;

public class Fighter extends PlayerCharacter{

	public Fighter() {
		List<String> proficiencies = new ArrayList<String>();
		proficiencies.add("All Armor");
		proficiencies.add("Shields");
		proficiencies.add("Simple Weapons");
		proficiencies.add("Martial Weapons");
		setProficiencies(proficiencies);
		setHitDice("d10");
		List<String> savingThrows= new ArrayList<String>();
		savingThrows.add("Strength");
		savingThrows.add("Constitution");
		setSavingThrows(savingThrows);
	}
}
