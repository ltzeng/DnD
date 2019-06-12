package dnd.monster;

import java.util.List;

public class Monster {

	private int monsterID;
	private String name;
	private String description;
	private String armorClass;
	private String hitPoints;
	private int speed;
	private String savingThrows;
	private String skills;
	private String damageImmunities;
	private String senses;
	private String languages;
	private String challenge;
	
	private List<MonsterSkill> monsterSkills;
	private List<MonsterAction> monsterActions;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getArmorClass() {
		return armorClass;
	}
	public void setArmorClass(String armorClass) {
		this.armorClass = armorClass;
	}
	public String getHitPoints() {
		return hitPoints;
	}
	public void setHitPoints(String hitPoints) {
		this.hitPoints = hitPoints;
	}
	public String getSavingThrows() {
		return savingThrows;
	}
	public void setSavingThrows(String savingThrows) {
		this.savingThrows = savingThrows;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getDamageImmunities() {
		return damageImmunities;
	}
	public void setDamageImmunities(String damageImmunities) {
		this.damageImmunities = damageImmunities;
	}
	public String getSenses() {
		return senses;
	}
	public void setSenses(String senses) {
		this.senses = senses;
	}
	public String getLanguages() {
		return languages;
	}
	public void setLanguages(String languages) {
		this.languages = languages;
	}
	public String getChallenge() {
		return challenge;
	}
	public void setChallenge(String challenge) {
		this.challenge = challenge;
	}
	public List<MonsterSkill> getMonsterSkills() {
		return monsterSkills;
	}
	public void setMonsterSkills(List<MonsterSkill> monsterSkills) {
		this.monsterSkills = monsterSkills;
	}
	public List<MonsterAction> getMonsterActions() {
		return monsterActions;
	}
	public void setMonsterActions(List<MonsterAction> monsterActions) {
		this.monsterActions = monsterActions;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getMonsterID() {
		return monsterID;
	}
	public void setMonsterID(int monsterID) {
		this.monsterID = monsterID;
	}
	
	
}
