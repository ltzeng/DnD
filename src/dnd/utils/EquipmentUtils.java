package dnd.utils;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import dnd.domain.character.PlayerCharacter;
import dnd.domain.character.equipment.Armor;
import dnd.domain.character.equipment.Weapon;

public class EquipmentUtils {

    public void getCharacterEquipmentList(HttpSession httpSession, ServletContext servletContext, PlayerCharacter pc) {
        
        Map<Integer,Weapon> weaponsMap=null;//(Map<Integer, Weapon>) httpSession.getAttribute("weaponList");
        Map<Integer,Armor> armorsMap=null;//(Map<Integer, Armor>) httpSession.getAttribute("armorList");
        if(weaponsMap==null) {
            EquipmentParser ep = new EquipmentParser();
            weaponsMap=ep.getWeaponsList(servletContext);
//            httpSession.setAttribute("weaponList", weaponsMap);
        }
        if(armorsMap==null) {
            EquipmentParser ep = new EquipmentParser();
            armorsMap=ep.getArmorsList(servletContext);
//            httpSession.setAttribute("armorList", weaponsMap);
        }
        
        List<String> equipmentString = readEquipmentList(servletContext, pc);
        
        for(String str : equipmentString) {
             if(str.startsWith("weapon:")) {
                 String[] equipmentNode = str.split(":");
                 pc.getWeapons().add(weaponsMap.get(Integer.parseInt(equipmentNode[1])));
             }else if(str.startsWith("armor:")) {
                 String[] equipmentNode = str.split(":");
                 pc.getArmors().add(armorsMap.get(Integer.parseInt(equipmentNode[1])));
             }
             
        }
    }
    
    public List<String> readEquipmentList(ServletContext context, PlayerCharacter pc) {
        FileReaderUtil fru = new FileReaderUtil();
        List<String> equipmentString = null;
        try {
             equipmentString = fru.servletReadFile(UtilConstants.CHARACTER_EQUIPMENT_FILE_PATH_PREFIX+pc.getCharacterFileName(), context);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return equipmentString;
    }
}
