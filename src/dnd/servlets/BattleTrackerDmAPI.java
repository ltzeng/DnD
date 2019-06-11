package dnd.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import dnd.encounter.Encounter;
import dnd.utils.EncounterUtils;

/**
 * Servlet implementation class BattleTrackerAPI
 */
@WebServlet("/BattleTrackerDmAPI")
public class BattleTrackerDmAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EncounterUtils eu = new EncounterUtils();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BattleTrackerDmAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    //Pass in a form and do everything in one submit rather than actions
	    int adventureID = Integer.parseInt(request.getParameter("adventureID"));
		String action = request.getParameter("action");
		PrintWriter out = response.getWriter();
		switch (action) {
		    case "startEncounter":
		        
		        break;
		    case "endEncounter":
		        endEncounter(request, out);
		        break;
		    case "updateHealth":
		        
		        break;
		    case "updateStatus":
        		    	updateEncounterStatus(request, out);
        		    	break;
		    case "nextTurn":
		        nextTurn(request, out);
		        break;
		}
		
	}

	private void nextTurn(HttpServletRequest request, PrintWriter out) {
	    int encounterID = Integer.parseInt(request.getParameter("encounterID"));
	    int adventureID = Integer.parseInt(request.getParameter("adventureID"));
	    Encounter encounter = eu.getEncounter(adventureID);
	    int turn = encounter.getTurn();
	    int overallTurn = encounter.getOverallTurn();
	    if(turn+1>encounter.getTotalTurns()) {
	        turn = 1;
	        overallTurn = overallTurn + 1;
	    }else {
	        turn = turn + 1;
	    }
	    
	    eu.setToNextTurn(encounterID, turn, overallTurn);
    }

    private void endEncounter(HttpServletRequest request, PrintWriter out) {
        
		int encounterID = Integer.parseInt(request.getParameter("encounterID"));
		eu.endEncounter(encounterID);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	private void updateEncounterStatus(HttpServletRequest request, PrintWriter out) {
	    String updateStatus = request.getParameter("updateStatus");
	    int encounterID = Integer.parseInt(request.getParameter("encounterID"));
        int success = eu.updateEncounterStatus(Boolean.valueOf(updateStatus), encounterID);
        out.print(success);
        out.flush();
	}

}
