package dnd.domain.character.classes;

import java.util.ArrayList;
import java.util.List;

import dnd.domain.character.PlayerCharacter;
import dnd.domain.character.skills.SpellSlots;

public class Wizard extends PlayerCharacter{

	public Wizard(int level) {
		setLevel(level);
		List<String> proficiencies = new ArrayList<String>();
		proficiencies.add("Daggers");
		proficiencies.add("Darts");
		proficiencies.add("Slings");
		proficiencies.add("Quarterstaffs");
		proficiencies.add("Light Crossbows");
		setProficiencies(proficiencies);
		setHitDice("d6");
		setMaxSpellSlot();
	}
	
	private void setMaxSpellSlot() {
	    int currentLevel = this.getLevel();
	    SpellSlots ss = new SpellSlots();
	    setSpellSlots(ss);
	    switch (currentLevel) {
	    case 1:
	        getSpellSlots().setSpellSlotMax1(2);
	        break;
	    case 2:
	        getSpellSlots().setSpellSlotMax1(3);
	        break;
	    case 3:
            getSpellSlots().setSpellSlotMax1(4);
            getSpellSlots().setSpellSlotMax2(2);
            break;
        case 4:
            getSpellSlots().setSpellSlotMax1(4);
            getSpellSlots().setSpellSlotMax2(3);
            break;
        case 5:
            getSpellSlots().setSpellSlotMax1(4);
            getSpellSlots().setSpellSlotMax2(3);
            getSpellSlots().setSpellSlotMax3(2);
            break;
        case 6:
            getSpellSlots().setSpellSlotMax1(4);
            getSpellSlots().setSpellSlotMax2(3);
            getSpellSlots().setSpellSlotMax3(3);
            break;
        case 7:
            getSpellSlots().setSpellSlotMax1(4);
            getSpellSlots().setSpellSlotMax2(3);
            getSpellSlots().setSpellSlotMax3(3);
            getSpellSlots().setSpellSlotMax4(1);
            break;
        case 8:
            getSpellSlots().setSpellSlotMax1(4);
            getSpellSlots().setSpellSlotMax2(3);
            getSpellSlots().setSpellSlotMax3(3);
            getSpellSlots().setSpellSlotMax4(2);
            break;
        case 9:
            getSpellSlots().setSpellSlotMax1(4);
            getSpellSlots().setSpellSlotMax2(3);
            getSpellSlots().setSpellSlotMax3(3);
            getSpellSlots().setSpellSlotMax4(2);
            getSpellSlots().setSpellSlotMax5(1);
            break;
        case 10:
            getSpellSlots().setSpellSlotMax1(4);
            getSpellSlots().setSpellSlotMax2(3);
            getSpellSlots().setSpellSlotMax3(3);
            getSpellSlots().setSpellSlotMax4(3);
            getSpellSlots().setSpellSlotMax5(2);
            break;
        case 11:
            getSpellSlots().setSpellSlotMax1(4);
            getSpellSlots().setSpellSlotMax2(3);
            getSpellSlots().setSpellSlotMax3(3);
            getSpellSlots().setSpellSlotMax4(3);
            getSpellSlots().setSpellSlotMax5(2);
            getSpellSlots().setSpellSlotMax6(1);
            break;
        case 12:
            getSpellSlots().setSpellSlotMax1(4);
            getSpellSlots().setSpellSlotMax2(3);
            getSpellSlots().setSpellSlotMax3(3);
            getSpellSlots().setSpellSlotMax4(3);
            getSpellSlots().setSpellSlotMax5(2);
            getSpellSlots().setSpellSlotMax6(1);
            break;
        case 13:
            getSpellSlots().setSpellSlotMax1(4);
            getSpellSlots().setSpellSlotMax2(3);
            getSpellSlots().setSpellSlotMax3(3);
            getSpellSlots().setSpellSlotMax4(3);
            getSpellSlots().setSpellSlotMax5(2);
            getSpellSlots().setSpellSlotMax6(1);
            getSpellSlots().setSpellSlotMax7(1);
            break;
        case 14:
            getSpellSlots().setSpellSlotMax1(4);
            getSpellSlots().setSpellSlotMax2(3);
            getSpellSlots().setSpellSlotMax3(3);
            getSpellSlots().setSpellSlotMax4(3);
            getSpellSlots().setSpellSlotMax5(2);
            getSpellSlots().setSpellSlotMax6(1);
            getSpellSlots().setSpellSlotMax7(1);
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
            break;
	    }
	}
}
