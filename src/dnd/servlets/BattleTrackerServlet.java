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

@WebServlet("/BattleTrackerPlayer")
public class BattleTrackerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PlayerCharacterUtils pcu = new PlayerCharacterUtils();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BattleTrackerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int adventureID = Integer.parseInt(request.getParameter("adventureID"));
		List<PlayerCharacter> pcList = pcu.getCharacterForAdventure(adventureID);
		Map<Integer, PlayerCharacter> pcMap = new HashMap<Integer,PlayerCharacter>();
		for(PlayerCharacter pc : pcList) {
			pcMap.put(pc.getCharacterID(), pc);
		}
		EncounterUtils eu = new EncounterUtils();
		pcMap=eu.getEncounterPlayers(adventureID, pcMap);
		Encounter encounter = eu.getEncounter(adventureID);
		
		request.setAttribute("pcList", pcList);
		request.setAttribute("encounter", encounter);
		RequestDispatcher view = request.getRequestDispatcher("main/battle/playerBattleTracker.jsp");
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
