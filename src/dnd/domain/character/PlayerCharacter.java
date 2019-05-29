package dnd.domain.character;

import java.util.List;

import dnd.domain.character.AbilityScores;

public abstract class PlayerCharacter {

	private String characterFileName;
	private String characterName;
	private String background;
	private String alignment;
	private Integer exp;
	private Integer level;
	private Integer maxHp;
	private Integer hp;
	private AbilityScores abilityScores;
	private String adjective;
	private String gender;
	private String characterClass;
	
	private List<CharacterSkill> Skills;
	
	
	public String getCharacterFileName() {
		return characterFileName;
	}
	public void setCharacterFileName(String characterFileName) {
		this.characterFileName = characterFileName;
	}
	public String getCharacterName() {
		return characterName;
	}
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}
	public String getBackground() {
		return background;
	}
	public void setBackground(String background) {
		this.background = background;
	}
	public String getAlignment() {
		return alignment;
	}
	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}
	public Integer getExp() {
		return exp;
	}
	public void setExp(Integer exp) {
		this.exp = exp;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getMaxHp() {
		return maxHp;
	}
	public void setMaxHp(Integer maxHp) {
		this.maxHp = maxHp;
	}
	public Integer getHp() {
		return hp;
	}
	public void setHp(Integer hp) {
		this.hp = hp;
	}
	public AbilityScores getAbilityScores() {
		return abilityScores;
	}
	public void setAbilityScores(AbilityScores abilityScores) {
		this.abilityScores = abilityScores;
	}
	public String getAdjective() {
		return adjective;
	}
	public void setAdjective(String adjective) {
		this.adjective = adjective;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCharacterClass() {
		return characterClass;
	}
	public void setCharacterClass(String characterClass) {
		this.characterClass = characterClass;
	}
	public List<CharacterSkill> getSkills() {
		return Skills;
	}
	public void setSkills(List<CharacterSkill> skills) {
		Skills = skills;
	}
	
	
	
}
