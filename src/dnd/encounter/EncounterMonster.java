package dnd.encounter;

import dnd.monster.Monster;

public class EncounterMonster extends Monster{

    private int encounterMonsterID;
	private int encounterID; 
	private Initiative initiative;
	private String status;
	private int hp;
	private int maxHP;
	private String typeColor;
	
	
	public int getEncounterID() {
		return encounterID;
	}
	public void setEncounterID(int encounterID) {
		this.encounterID = encounterID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMaxHP() {
		return maxHP;
	}
	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}
	public String getTypeColor() {
		return typeColor;
	}
	public void setTypeColor(String typeColor) {
		this.typeColor = typeColor;
	}
	public Initiative getInitiative() {
		return initiative;
	}
	public void setInitiative(Initiative initiative) {
		this.initiative = initiative;
	}
    public int getEncounterMonsterID() {
        return encounterMonsterID;
    }
    public void setEncounterMonsterID(int encounterMonsterID) {
        this.encounterMonsterID = encounterMonsterID;
    }
	
	
}
