package dnd.servlets;

import java.io.IOException;
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
import dnd.utils.EncounterUtils;
import dnd.utils.PlayerCharacterUtils;

@WebServlet("/BattleTrackerDM")
public class BattleTrackerDMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PlayerCharacterUtils pcu = new PlayerCharacterUtils();
    EncounterUtils eu = new EncounterUtils();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BattleTrackerDMServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int adventureID = Integer.parseInt(request.getParameter("adventureID"));
//		
//		List<PlayerCharacter> pcList = pcu.getCharacterForAdventure(adventureID);
//		
//		Encounter encounter = eu.getEncounter(adventureID);
//		boolean encounterLive = false;
//		if(encounter!=null) {
//			Map<Integer, PlayerCharacter> pcMap = new HashMap<Integer,PlayerCharacter>();
//			for(PlayerCharacter pc : pcList) {
//				pcMap.put(pc.getCharacterID(), pc);
//			}
//			pcMap=eu.getEncounterPlayers(adventureID, pcMap);
//			request.setAttribute("encounter", encounter);
//			encounterLive = true;
//			
//			eu.getEncounterEnemies();
//		}
//		
//		request.setAttribute("encounterLive",encounterLive);
//		request.setAttribute("pcList", pcList);
		RequestDispatcher view = request.getRequestDispatcher("main/battle/dmBattleTracker.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
