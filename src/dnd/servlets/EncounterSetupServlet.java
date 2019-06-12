package dnd.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dnd.domain.character.PlayerCharacter;
import dnd.monster.Monster;
import dnd.utils.EncounterUtils;
import dnd.utils.PlayerCharacterUtils;

/**
 * Servlet implementation class EncounterSetupServlet
 */
@WebServlet("/EncounterSetup")
public class EncounterSetupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EncounterUtils eu = new EncounterUtils();
	private PlayerCharacterUtils pcu = new PlayerCharacterUtils();
	
	public EncounterSetupServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		request.setAttribute("adventureID", request.getParameter("adventureID"));
		if(action!=null && action.equals("create")) {
			createEncounter(request);
			response.sendRedirect("DungeonMaster?adventureID="+request.getParameter("adventureID"));
		}else {
			loadForm(request);
			RequestDispatcher view = request.getRequestDispatcher("main/battle/encounterSetup.jsp");
			view.forward(request, response);
		}
		
		
	}

	private void createEncounter(HttpServletRequest request) {
		int adventureID = Integer.parseInt(request.getParameter("adventureID"));
		String description = request.getParameter("description");
		int encounterID = eu.createEncounter(adventureID, description);
		
		Map<String,String[]> map = request.getParameterMap();
		int totalFighters = 0;
		for(String key : map.keySet()) {
			if(key.startsWith("initiative_player")) {
				int playerInitiative = Integer.parseInt(request.getParameter(key));
				String[] nodes = key.split("-");
				int playerID = Integer.parseInt(nodes[1]);
				eu.addPlayerToEncounter(encounterID, playerID, playerInitiative);
				totalFighters++;
			}else if(key.startsWith("initiative_monster")) {
				int monsterInitiative = Integer.parseInt(request.getParameter(key));
				String[] nodes = key.split("-");
				int monsterID = Integer.parseInt(nodes[1]);
				int monsterCount = Integer.parseInt(nodes[2]);
				int hp = Integer.parseInt(request.getParameter("monster_hp_"+monsterCount));
				String color = request.getParameter("monster_color_"+monsterCount);
				eu.addMonsterToEncounter(encounterID, monsterID, monsterInitiative, hp, color);
				totalFighters++;
			}
		}
		eu.setEncounterTotalTurns(encounterID, totalFighters);
	}

	private void loadForm(HttpServletRequest request) {
		List<Monster> monList = eu.getAllEnemies();
		request.setAttribute("monList", monList);
		List<PlayerCharacter> pcList = pcu.getCharacterForAdventure(Integer.parseInt(request.getParameter("adventureID")));
		request.setAttribute("pcList", pcList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
