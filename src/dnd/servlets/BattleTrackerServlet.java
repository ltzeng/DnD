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
		List<PlayerCharacter> pcList = pcu.getCharacterForAdventure(Integer.parseInt(request.getParameter("adventureID")));
		
		request.setAttribute("pcList", pcList);
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