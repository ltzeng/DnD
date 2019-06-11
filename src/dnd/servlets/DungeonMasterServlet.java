package dnd.servlets;

import java.io.IOException;
import java.util.List;

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
		
		request.setAttribute("encounter", encounter);
		request.setAttribute("pcList", pcList);
		request.setAttribute("adventureID", adventureID);
		
		
		RequestDispatcher view = request.getRequestDispatcher("main/dm/dmMain.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
