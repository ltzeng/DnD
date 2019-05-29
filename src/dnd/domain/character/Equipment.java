package dnd.domain.character;

import java.util.List;

public class Equipment {

	private List<Gear> weapons;
	private Integer copperPieces;
	private Integer silverPieces;
	private Integer goldPieces;
	private Integer electrumPieces;
	private Integer platinumPieces;
	private List<Item> items;
	
	private Double currentWeight = new Double(0);
	
	public double getCurrentWeight() {
		currentWeight=(double) ((copperPieces+silverPieces+goldPieces+electrumPieces+platinumPieces)/3);
		for(Gear w : weapons) {
			currentWeight+=w.getWeight();
		}
		for(Item i : items) {
			currentWeight+=i.getWeight();
		}
		
		return currentWeight/16.0;
	}
	
	public List<Gear> getWeapons() {
		return weapons;
	}
	public void setWeapons(List<Gear> weapons) {
		this.weapons = weapons;
	}
	public Integer getCopperPieces() {
		return copperPieces;
	}
	public void setCopperPieces(Integer copperPieces) {
		this.copperPieces = copperPieces;
	}
	public Integer getSilverPieces() {
		return silverPieces;
	}
	public void setSilverPieces(Integer silverPieces) {
		this.silverPieces = silverPieces;
	}
	public Integer getGoldPieces() {
		return goldPieces;
	}
	public void setGoldPieces(Integer goldPieces) {
		this.goldPieces = goldPieces;
	}
	public Integer getElectrumPieces() {
		return electrumPieces;
	}
	public void setElectrumPieces(Integer electrumPieces) {
		this.electrumPieces = electrumPieces;
	}
	public Integer getPlatinumPieces() {
		return platinumPieces;
	}
	public void setPlatinumPieces(Integer platinumPieces) {
		this.platinumPieces = platinumPieces;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}

	
}
