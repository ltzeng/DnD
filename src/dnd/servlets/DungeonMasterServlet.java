package dnd.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dnd.domain.character.PlayerCharacter;
import dnd.encounter.Encounter;
import dnd.encounter.EncounterMonster;
import dnd.utils.EncounterUtils;
import dnd.utils.PlayerCharacterUtils;

@WebServlet("/DungeonMaster")
public class DungeonMasterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private PlayerCharacterUtils pcu = new PlayerCharacterUtils();
    private EncounterUtils eu = new EncounterUtils();
    public DungeonMasterServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int adventureID = Integer.parseInt(request.getParameter("adventureID"));

        List<PlayerCharacter> pcList = pcu.getCharacterForAdventure(adventureID);
        Encounter encounter = eu.getEncounter(adventureID);
        if(encounter!=null) {
            Map<Integer, PlayerCharacter> pcMap = new HashMap<Integer,PlayerCharacter>();
            for(PlayerCharacter pc : pcList) {
                pcMap.put(pc.getCharacterID(), pc);
            }
            pcMap=eu.getEncounterPlayers(adventureID, pcMap);
            request.setAttribute("encounter", encounter);

            List<EncounterMonster> monsterList = eu.getEncounterEnemies(encounter.getEncounterID());
            monsterList = eu.getMonsterSkills(monsterList);
            request.setAttribute("monsterList", monsterList);

            List<Integer> initiativesList = getInitiatives(monsterList, pcList);
            request.setAttribute("initiativesList",initiativesList);
        }

        request.setAttribute("encounter", encounter);
        request.setAttribute("pcList", pcList);
        request.setAttribute("adventureID", adventureID);


        RequestDispatcher view = request.getRequestDispatcher("main/dm/dmMain.jsp");
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private List<Integer> getInitiatives(List<EncounterMonster> monsterList, List<PlayerCharacter> pcList){
        List<Integer> initiativesList = new ArrayList<Integer>();

        for(EncounterMonster em : monsterList) {
            initiativesList.add(em.getInitiative().getInitiative());
        }
        for(PlayerCharacter pc : pcList) {
            initiativesList.add(pc.getEncounterDetails().getInitiative().getInitiative());
        }
        Collections.sort(initiativesList, Collections.reverseOrder());

        return initiativesList;
    }



}
