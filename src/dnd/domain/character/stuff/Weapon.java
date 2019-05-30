package dnd.domain.character.stuff;

public class Weapon {

    private int weaponID;
    private String name;
    private Integer weight;
    private Integer cost;
    private String damage;
    private String properties;
    
    
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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    
}
