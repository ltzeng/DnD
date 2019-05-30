package dnd.domain.character.stuff;

public class Armor {

    private Integer armorID;
    private String name;
    private Integer weight;
    private Integer cost;
    private String armorClass;
    private String strength;
    private String stealth;
    private String type;
    
    
    public String getArmorClass() {
        return armorClass;
    }
    public void setArmorClass(String armorClass) {
        this.armorClass = armorClass;
    }
    public String getStrength() {
        return strength;
    }
    public void setStrength(String strength) {
        this.strength = strength;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getWeight() {
        return weight;
    }
    public void setWeight(Integer weight) {
        this.weight = weight;
    }
    public Integer getCost() {
        return cost;
    }
    public void setCost(Integer cost) {
        this.cost = cost;
    }
    public Integer getArmorID() {
        return armorID;
    }
    public void setArmorID(Integer armorID) {
        this.armorID = armorID;
    }
    public String getStealth() {
        return stealth;
    }
    public void setStealth(String stealth) {
        this.stealth = stealth;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    
    
    
}
