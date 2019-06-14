package dnd.domain.character;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import dnd.domain.character.AbilityScores;
import dnd.domain.character.equipment.Armor;
import dnd.domain.character.equipment.Currency;
import dnd.domain.character.equipment.Weapon;
import dnd.domain.character.skills.SpellSlots;
import dnd.encounter.ActorEncounterDetails;

public abstract class PlayerCharacter {

    private Integer characterID;
    private String characterName;
    private Integer adventureID;
    private String background;
    private String alignment;
    private Integer exp;
    private Integer level;
    private Integer maxHp;
    private Integer hp;
    private Integer tempHP;
    private AbilityScores abilityScores;
    private String adjective;
    private String gender;
    private String characterClass;
    private String race;
    private Integer speed;
    private Integer initiative;
    private Integer armorClass;
    private List<Weapon> weapons = new ArrayList<Weapon>();
    private List<Armor> armors = new ArrayList<Armor>();
    private List<CharacterSkill> Skills;
    private Currency currency;
    private Integer proficiencyBonus;
    private String customAvatarName;
    private SpellSlots spellSlots;
    private List<Note> notes;
    private ActorEncounterDetails encounterDetails;

    //not set here, set in character class
    private List<String> proficiencies;
    private String hitDice;
    private List<String> savingThrows;

    public String getAvatarPicture() {
        if(StringUtils.isEmpty(customAvatarName)){
            return race + "-" + gender + "-" + characterClass;
        }
        return customAvatarName;
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
    public List<Weapon> getWeapons() {
        return weapons;
    }
    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }
    public List<Armor> getArmors() {
        return armors;
    }
    public void setArmors(List<Armor> armors) {
        this.armors = armors;
    }
    public String getRace() {
        return race;
    }
    public void setRace(String race) {
        this.race = race;
    }
    public List<String> getProficiencies() {
        return proficiencies;
    }
    public void setProficiencies(List<String> proficiencies) {
        this.proficiencies = proficiencies;
    }
    public String getHitDice() {
        return hitDice;
    }
    public void setHitDice(String hitDice) {
        this.hitDice = hitDice;
    }
    public List<String> getSavingThrows() {
        return savingThrows;
    }
    public void setSavingThrows(List<String> savingThrows) {
        this.savingThrows = savingThrows;
    }
    public Integer getAdventureID() {
        return adventureID;
    }
    public void setAdventureID(Integer adventureID) {
        this.adventureID = adventureID;
    }
    public Integer getSpeed() {
        return speed;
    }
    public void setSpeed(Integer speed) {
        this.speed = speed;
    }
    public Integer getInitiative() {
        return initiative;
    }
    public void setInitiative(Integer initiative) {
        this.initiative = initiative;
    }
    public Integer getArmorClass() {
        return armorClass;
    }
    public void setArmorClass(Integer armorClass) {
        this.armorClass = armorClass;
    }
    public Integer getCharacterID() {
        return characterID;
    }
    public void setCharacterID(Integer characterID) {
        this.characterID = characterID;
    }
    public String getCustomAvatarName() {
        return customAvatarName;
    }
    public void setCustomAvatarName(String customAvatarName) {
        this.customAvatarName = customAvatarName;
    }
    public Integer getTempHP() {
        return tempHP;
    }
    public void setTempHP(Integer tempHP) {
        this.tempHP = tempHP;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Integer getProficiencyBonus() {
        return proficiencyBonus;
    }

    public void setProficiencyBonus(Integer proficiencyBonus) {
        this.proficiencyBonus = proficiencyBonus;
    }

    public SpellSlots getSpellSlots() {
        return spellSlots;
    }

    public void setSpellSlots(SpellSlots spellSlots) {
        this.spellSlots = spellSlots;
    }

    public ActorEncounterDetails getEncounterDetails() {
        return encounterDetails;
    }

    public void setEncounterDetails(ActorEncounterDetails encounterDetails) {
        this.encounterDetails = encounterDetails;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

}
