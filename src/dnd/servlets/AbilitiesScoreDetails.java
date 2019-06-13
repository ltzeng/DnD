package dnd.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dnd.domain.character.PlayerCharacter;
import dnd.utils.PlayerCharacterUtils;

/**
 * Servlet implementation class AbilitiesScoreDetails
 */
@WebServlet("/AbilitiesScoreDetails")
public class AbilitiesScoreDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PlayerCharacterUtils pcu = new PlayerCharacterUtils();
	private PlayerCharacter pc;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AbilitiesScoreDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int characterID = Integer.parseInt(request.getParameter("characterID"));
		
        try {
            pc = pcu.getCharacter(characterID);
        } catch (Exception e) {
            getServletContext().log("An exception occurred in AbilitiesScoresDetails", e);
            throw new ServletException("An exception occurred in AbilitiesScoresDetails " + e.getMessage());
        }
        request.setAttribute("pc", pc);
		RequestDispatcher view = request.getRequestDispatcher("main/player/abilitiesDetails.jsp");
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
