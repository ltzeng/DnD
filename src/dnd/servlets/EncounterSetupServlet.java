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
		if(action!=null && action.equals("create")) {
			createEncounter();
		}else {
			loadForm(request);
			RequestDispatcher view = request.getRequestDispatcher("main/battle/encounterSetup.jsp");
			view.forward(request, response);
		}
		
		
	}

	private void createEncounter() {
		
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
