package dnd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dnd.domain.character.PlayerCharacter;
import dnd.domain.character.classes.Cleric;
import dnd.domain.character.classes.Fighter;
import dnd.domain.character.classes.Rogue;
import dnd.domain.character.classes.Wizard;

public class PlayerCharacterDAO {

    private Connection connection;
    
    private Connection getConnection() {
        
        if(connection!=null) {
            try {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dnd", "postgres", "1234ABcd");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
    
    public List<PlayerCharacter> getPlayerCharacter(int adventureID) {
        List<PlayerCharacter> characterList = new ArrayList<PlayerCharacter>();
        try {
            
            String sql = "SELECT * FROM PlayerCharacter pc "
                    + "INNER JOIN AbilityScores as on pc.character_id=as.character_id"
                    + "WHERE adventure_id = ?";
            
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, adventureID);
            System.out.printf("%-30.30s  %-30.30s%n", "character_id", "character_name");
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                String characterClass = resultSet.getString("character_class");
                PlayerCharacter pc = getPlayerCharacterClass(characterClass);
                pc.setCharacterID(resultSet.getInt("character_id"));
                pc.setCharacterName(resultSet.getString("character_name"));
                pc.setBackground(resultSet.getString("background"));
                pc.setExp(resultSet.getInt("exp"));
                pc.setLevel(resultSet.getInt("level"));
                pc.setMaxHp(resultSet.getInt("maxHP"));
                pc.setHp(resultSet.getInt("hp"));
                
            }
 
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
        
        return characterList;
    }
    
    private PlayerCharacter getPlayerCharacterClass(String characterClass) {
        PlayerCharacter pc = null;
        switch(characterClass) {
            case "Fighter":
                pc=new Fighter();
                break;
            case "Wizard":
                pc=new Wizard();
                break;
            case "Rogue":
                pc=new Rogue();
                break;
            case "Cleric":
                pc=new Cleric();
                break;
        }
        return pc;
    }
}

