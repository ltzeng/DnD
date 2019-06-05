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
	
	private void setMaxSpellSlot() {
        int currentLevel = this.getLevel();
        switch (currentLevel) {
        case 1:
            getSpellSlots().setSpellSlotMax1(2);
            getSpellSlots().setCantripsKnown(3);
            break;
        case 2:
            getSpellSlots().setSpellSlotMax1(3);
            getSpellSlots().setCantripsKnown(3);
            break;
        case 3:
            getSpellSlots().setSpellSlotMax1(4);
            getSpellSlots().setSpellSlotMax2(2);
            getSpellSlots().setCantripsKnown(3);
            break;
        case 4:
            getSpellSlots().setSpellSlotMax1(4);
            getSpellSlots().setSpellSlotMax2(3);
            getSpellSlots().setCantripsKnown(4);
            break;
        case 5:
            getSpellSlots().setSpellSlotMax1(4);
            getSpellSlots().setSpellSlotMax2(3);
            getSpellSlots().setSpellSlotMax3(2);
            getSpellSlots().setCantripsKnown(4);
            break;
        case 6:
            getSpellSlots().setSpellSlotMax1(4);
            getSpellSlots().setSpellSlotMax2(3);
            getSpellSlots().setSpellSlotMax3(3);
            getSpellSlots().setCantripsKnown(4);
            break;
        case 7:
            getSpellSlots().setSpellSlotMax1(4);
            getSpellSlots().setSpellSlotMax2(3);
            getSpellSlots().setSpellSlotMax3(3);
            getSpellSlots().setSpellSlotMax4(1);
            getSpellSlots().setCantripsKnown(4);
            break;
        case 8:
            getSpellSlots().setSpellSlotMax1(4);
            getSpellSlots().setSpellSlotMax2(3);
            getSpellSlots().setSpellSlotMax3(3);
            getSpellSlots().setSpellSlotMax4(2);
            getSpellSlots().setCantripsKnown(4);
            break;
        case 9:
            getSpellSlots().setSpellSlotMax1(4);
            getSpellSlots().setSpellSlotMax2(3);
            getSpellSlots().setSpellSlotMax3(3);
            getSpellSlots().setSpellSlotMax4(3);
            getSpellSlots().setSpellSlotMax5(1);
            getSpellSlots().setCantripsKnown(4);
            break;
        case 10:
            getSpellSlots().setSpellSlotMax1(4);
            getSpellSlots().setSpellSlotMax2(3);
            getSpellSlots().setSpellSlotMax3(3);
            getSpellSlots().setSpellSlotMax4(3);
            getSpellSlots().setSpellSlotMax5(2);
            getSpellSlots().setCantripsKnown(5);
            break;
        case 11:
            getSpellSlots().setSpellSlotMax1(4);
            getSpellSlots().setSpellSlotMax2(3);
            getSpellSlots().setSpellSlotMax3(3);
            getSpellSlots().setSpellSlotMax4(3);
            getSpellSlots().setSpellSlotMax5(2);
            getSpellSlots().setSpellSlotMax6(1);
            getSpellSlots().setCantripsKnown(5);
            break;
        case 12:
            getSpellSlots().setSpellSlotMax1(4);
            getSpellSlots().setSpellSlotMax2(3);
            getSpellSlots().setSpellSlotMax3(3);
            getSpellSlots().setSpellSlotMax4(3);
            getSpellSlots().setSpellSlotMax5(2);
            getSpellSlots().setSpellSlotMax6(1);
            getSpellSlots().setCantripsKnown(5);
            break;
        case 13:
            getSpellSlots().setSpellSlotMax1(4);
            getSpellSlots().setSpellSlotMax2(3);
            getSpellSlots().setSpellSlotMax3(3);
            getSpellSlots().setSpellSlotMax4(3);
            getSpellSlots().setSpellSlotMax5(2);
            getSpellSlots().setSpellSlotMax6(1);
            getSpellSlots().setSpellSlotMax7(1);
            getSpellSlots().setCantripsKnown(5);
            break;
        case 14:
            getSpellSlots().setSpellSlotMax1(4);
            getSpellSlots().setSpellSlotMax2(3);
            getSpellSlots().setSpellSlotMax3(3);
            getSpellSlots().setSpellSlotMax4(3);
            getSpellSlots().setSpellSlotMax5(2);
            getSpellSlots().setSpellSlotMax6(1);
            getSpellSlots().setSpellSlotMax7(1);
            getSpellSlots().setCantripsKnown(5);
            break;
        case 15:
            getSpellSlots().setSpellSlotMax1(4);
            getSpellSlots().setSpellSlotMax2(3);
            getSpellSlots().setSpellSlotMax3(3);
            getSpellSlots().setSpellSlotMax4(3);
            getSpellSlots().setSpellSlotMax5(2);
            getSpellSlots().setSpellSlotMax6(1);
            getSpellSlots().setSpellSlotMax7(1);
            getSpellSlots().setSpellSlotMax8(1);
            getSpellSlots().setCantripsKnown(5);
            break;
        case 16:
            getSpellSlots().setSpellSlotMax1(4);
            getSpellSlots().setSpellSlotMax2(3);
            getSpellSlots().setSpellSlotMax3(3);
            getSpellSlots().setSpellSlotMax4(3);
            getSpellSlots().setSpellSlotMax5(2);
            getSpellSlots().setSpellSlotMax6(1);
            getSpellSlots().setSpellSlotMax7(1);
            getSpellSlots().setSpellSlotMax8(1);
            getSpellSlots().setCantripsKnown(5);
            break;
        case 17:
            getSpellSlots().setSpellSlotMax1(4);
            getSpellSlots().setSpellSlotMax2(3);
            getSpellSlots().setSpellSlotMax3(3);
            getSpellSlots().setSpellSlotMax4(3);
            getSpellSlots().setSpellSlotMax5(2);
            getSpellSlots().setSpellSlotMax6(1);
            getSpellSlots().setSpellSlotMax7(1);
            getSpellSlots().setSpellSlotMax8(1);
            getSpellSlots().setSpellSlotMax9(1);
            getSpellSlots().setCantripsKnown(5);
            break;
        case 18:
            getSpellSlots().setSpellSlotMax1(4);
            getSpellSlots().setSpellSlotMax2(3);
            getSpellSlots().setSpellSlotMax3(3);
            getSpellSlots().setSpellSlotMax4(3);
            getSpellSlots().setSpellSlotMax5(3);
            getSpellSlots().setSpellSlotMax6(1);
            getSpellSlots().setSpellSlotMax7(1);
            getSpellSlots().setSpellSlotMax8(1);
            getSpellSlots().setSpellSlotMax9(1);
            getSpellSlots().setCantripsKnown(5);
            break;
        case 19:
            getSpellSlots().setSpellSlotMax1(4);
            getSpellSlots().setSpellSlotMax2(3);
            getSpellSlots().setSpellSlotMax3(3);
            getSpellSlots().setSpellSlotMax4(3);
            getSpellSlots().setSpellSlotMax5(3);
            getSpellSlots().setSpellSlotMax6(2);
            getSpellSlots().setSpellSlotMax7(1);
            getSpellSlots().setSpellSlotMax8(1);
            getSpellSlots().setSpellSlotMax9(1);
            getSpellSlots().setCantripsKnown(5);
            break;
        case 20:
            getSpellSlots().setSpellSlotMax1(4);
            getSpellSlots().setSpellSlotMax2(3);
            getSpellSlots().setSpellSlotMax3(3);
            getSpellSlots().setSpellSlotMax4(3);
            getSpellSlots().setSpellSlotMax5(3);
            getSpellSlots().setSpellSlotMax6(2);
            getSpellSlots().setSpellSlotMax7(2);
            getSpellSlots().setSpellSlotMax8(1);
            getSpellSlots().setSpellSlotMax9(1);
            getSpellSlots().setCantripsKnown(5);
            break;
        }
}
