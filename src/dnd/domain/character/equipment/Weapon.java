package dnd.domain.character.equipment;

import java.util.List;
import dnd.domain.character.PlayerCharacter;

public class Weapon {

    private int weaponID;
    private String name;
    private Double weight;
    //everything is in copper
    private Integer cost;
    private String damage;
    private String properties;
    private String type;

    public int calculateAttackBonus(PlayerCharacter pc) {
        int bonus = 0;
        List<String> proficiencies = pc.getProficiencies();
        if(proficiencies.contains("type")) {
            bonus += pc.getProficiencyBonus();
        }
        return bonus;
    }

    public String getReadableCost() {
        StringBuilder sb = new StringBuilder();
        int holder = cost;
        String prepend = "";
        if(holder > 100) {
            sb.append(prepend + "GP: " + holder/100);
            holder = holder % 100;
            prepend = " ";
        }
        if(holder > 10) {
            sb.append(prepend + "SP: " + holder/10);
            holder = holder % 10;
            prepend = " ";
        }
        if(holder > 0) {
            sb.append(prepend + "CP: " + holder);
        }
        return sb.toString();
    }

    public String getDamage() {
        return damage;
    }
    public void setDamage(String damage) {
        this.damage = damage;
    }
    public String getProperties() {
        return properties;
    }
    public void setProperties(String properties) {
        this.properties = properties;
    }
    public int getWeaponID() {
        return weaponID;
    }
    public void setWeaponID(int weaponID) {
        this.weaponID = weaponID;
    }
    public Integer getCost() {
        return cost;
    }
    public void setCost(Integer cost) {
        this.cost = cost;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getWeight() {
        return weight;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }


}
