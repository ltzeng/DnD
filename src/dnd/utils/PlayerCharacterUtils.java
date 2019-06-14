package dnd.utils;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import dnd.dao.PlayerCharacterDAO;
import dnd.domain.character.Note;
import dnd.domain.character.PlayerCharacter;

public class PlayerCharacterUtils {

    PlayerCharacterDAO pcDao = new PlayerCharacterDAO();

    public PlayerCharacter getCharacter(int characterID) {
        PlayerCharacter pc = null;
        try {
            pc = pcDao.getPlayerCharacterByID(characterID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pc;
    }

    public List<PlayerCharacter> getCharacterForAdventure(int adventureID) {
        List<PlayerCharacter> pcList = null;
        try {
            pcList = pcDao.getPlayerCharactersByAdventureID(adventureID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pcList;
    }

    public void modifyAbilityScores(PlayerCharacter pc){

    }

    public void updatePlayerHP(int playerID, int hp) {
        try {
            pcDao.updatePlayerHP(playerID, hp);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void updatePlayerCharacterDetails(int playerID, String exp, String level, String maxHP, String hp, String tempHP, String armorClass) {
        try {
            pcDao.updatePlayerDetails(playerID, exp, level, maxHP, hp, tempHP, armorClass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePlayerCurrency(int characterID, String copper, String silver, String gold, String electrum, String platinum) {
        try {
            pcDao.updatePlayerCurrency(characterID,copper,silver,gold,electrum,platinum);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Note> getPlayerNotes(int characterID) {
        List<Note> notes = null;
        try {
            notes = pcDao.getPlayerNotes(characterID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notes;
    }

    public void updateNote(int noteID, String note) {

        try {
            pcDao.updatePlayerNote(noteID, note);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addNote(String note, String title, int characterID) {

        try {
            pcDao.addNote(note,title, characterID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
