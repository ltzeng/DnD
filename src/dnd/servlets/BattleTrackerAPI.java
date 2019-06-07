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

/**
 * Servlet implementation class BattleTrackerAPI
 */
@WebServlet("/BattleTrackerAPI")
public class BattleTrackerAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EncounterUtils eu = new EncounterUtils();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BattleTrackerAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int adventureID = Integer.parseInt(request.getParameter("adventureID"));
		String action = request.getParameter("action");
		PrintWriter out = response.getWriter();
		switch (action) {
		    case "ackEncounterUpdate":
		        updateEncounterStatus(request, out);
		        break;
		    case "updateCheck":
		        refreshPageCall(adventureID, out);
		        break;
		}
		
//		response.setContentType("application/json");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void refreshPageCall(int adventureID, PrintWriter out) {
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
