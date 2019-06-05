package dnd.utils;

import dnd.dao.PlayerCharacterDAO;
import dnd.domain.character.PlayerCharacter;

public class EquipmentUtils {

	PlayerCharacterDAO pcDao = new PlayerCharacterDAO();
    public PlayerCharacter getCharacterEquipmentList(PlayerCharacter pc) {
        pc = pcDao.getPCEquipment(pc);
        
        return pc;
    }
    
}
