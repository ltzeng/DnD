package dnd.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dnd.utils.EncounterUtils;
import dnd.utils.PlayerCharacterUtils;

/**
 * Servlet implementation class BattleTrackerAPI
 */
@WebServlet("/BattleTrackerAPI")
public class BattleTrackerAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EncounterUtils eu = new EncounterUtils();
	private PlayerCharacterUtils pcu = new PlayerCharacterUtils();
	
	
    public BattleTrackerAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		PrintWriter out = response.getWriter();
		switch (action) {
		    case "ackEncounterUpdate":
		        updateEncounterStatus(request, out);
		        break;
		    case "updateCheck":
		        refreshPageCall(request, out);
		        break;
		    case "updatePlayerHP":
		    	updatePlayerHP(request,out);
		    	break;
		    case "updateMonsterHP":
		    	updateMonsterHP(request,out);
		    	break;
		}
		
//		response.setContentType("application/json");
		
	}

	private void updatePlayerHP(HttpServletRequest request, PrintWriter out) {
		int playerID = Integer.parseInt(request.getParameter("characterID"));
		int hpUpdate = Integer.parseInt(request.getParameter("hp"));
		int encounterID = Integer.parseInt(request.getParameter("encounterID"));
		pcu.updatePlayerHP(playerID, hpUpdate);
		eu.updateEncounterStatus(true, encounterID);
	}
	
	private void updateMonsterHP(HttpServletRequest request, PrintWriter out) {
		int monsterID = Integer.parseInt(request.getParameter("monsterID"));
		int hpUpdate = Integer.parseInt(request.getParameter("hp"));
		int encounterID = Integer.parseInt(request.getParameter("encounterID"));
		eu.updateMonsterHP(monsterID, hpUpdate);
		eu.updateEncounterStatus(true, encounterID);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void refreshPageCall(HttpServletRequest request, PrintWriter out) {
		int adventureID = Integer.parseInt(request.getParameter("adventureID"));
		boolean updated = eu.checkEncounterUpdated(adventureID);
		JSONObject jsonObj = new JSONObject();
		jsonObj.append("updated", updated);
		out.print(updated);
		out.flush();
	}
	
	private void updateEncounterStatus(HttpServletRequest request, PrintWriter out) {
	    String updateStatus = request.getParameter("updateStatus");
        String encounterID = request.getParameter("encounterID");
        int success = eu.updateEncounterStatus(Boolean.valueOf(updateStatus), Integer.parseInt(encounterID));
        out.print(success);
        out.flush();
	}

}
