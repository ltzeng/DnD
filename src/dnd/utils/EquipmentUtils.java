package dnd.utils;

import java.sql.SQLException;

import dnd.dao.PlayerCharacterDAO;
import dnd.domain.character.PlayerCharacter;

public class EquipmentUtils {

	PlayerCharacterDAO pcDao = new PlayerCharacterDAO();
    public PlayerCharacter getCharacterEquipmentList(PlayerCharacter pc) {
        try {
			pc = pcDao.getPCEquipment(pc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        return pc;
    }
    
}
