package dnd.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import dnd.domain.character.stuff.Armor;
import dnd.domain.character.stuff.Weapon;

public class EquipmentParser {

    FileReaderUtil frs = new FileReaderUtil();
    
    public Map<Integer, Weapon> getWeaponsList(ServletContext context){
        
        String fileName = UtilConstants.FILE_PATH_PREFIX + "WeaponsList";
        List<String> weaponsString = null;
        Map<Integer, Weapon> weaponsList = null;
        try {
            weaponsString=frs.servletReadFile(fileName, context);
            weaponsList=parseWeapons(weaponsString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weaponsList;
    }
    
    private Map<Integer, Weapon> parseWeapons(List<String> weaponsString) {
        Map<Integer, Weapon> weaponsMap = new HashMap<Integer, Weapon>();
        for(String weap : weaponsString) {
            String[] nodes = weap.split("~");
            Weapon weapon = new Weapon();
            weapon.setWeaponID(Integer.parseInt(nodes[0]));
            weapon.setName(nodes[1]);
//          weapon.setCost(cost); implement this later
            weapon.setDamage(nodes[3]);
            weapon.setWeight(Integer.parseInt(nodes[4]));
            weapon.setProperties(nodes[5]);
            
            weaponsMap.put(weapon.getWeaponID(), weapon);
        }
        
        return weaponsMap;
    }
    
    public Map<Integer, Armor> getArmorsList(ServletContext context){
        
        String fileName = UtilConstants.FILE_PATH_PREFIX + "ArmorsList";
        List<String> armorString = null;
        Map<Integer, Armor> weaponsList = null;
        try {
            armorString=frs.servletReadFile(fileName, context);
            weaponsList=parseArmor(armorString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weaponsList;
    }
    
    private Map<Integer,Armor> parseArmor(List<String> armorString){
        Map<Integer, Armor> armorMap = new HashMap<Integer, Armor>();
        for(String weap : armorString) {
            String[] nodes = weap.split("~");
            
            Armor armor = new Armor();
            armor.setArmorID(Integer.parseInt(nodes[0]));
            armor.setName(nodes[1]);
//            armor.setCost(Integer.par);
            armor.setArmorClass(nodes[3]);
            armor.setStealth(nodes[4]);
            armor.setWeight(Integer.parseInt(nodes[5]));
            armor.setWeight(Integer.parseInt(nodes[6]));
            armor.setType(nodes[7]);
            
            armorMap.put(armor.getArmorID(), armor);
        }
        
        return armorMap;
    }
}
