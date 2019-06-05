package dnd.domain.character.equipment;

import java.util.List;

public class Equipment {

	private List<Weapon> weapons;
	private List<Armor> armor;
	private List<Item> items;
	private Currency money;
	
	private Double currentWeight = new Double(0);
	
	public double getCurrentWeight() {
		for(Weapon w : weapons) {
			currentWeight+=w.getWeight();
		}
		for(Item i : items) {
			currentWeight+=i.getWeight();
		}
		
		return currentWeight;
	}
	
	public List<Weapon> getWeapons() {
		return weapons;
	}
	public void setWeapons(List<Weapon> weapons) {
		this.weapons = weapons;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}

    public List<Armor> getArmor() {
        return armor;
    }

    public void setArmor(List<Armor> armor) {
        this.armor = armor;
    }

    public Currency getMoney() {
        return money;
    }

    public void setMoney(Currency money) {
        this.money = money;
    }

	
}
