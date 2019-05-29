package dnd.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dnd.domain.character.PlayerCharacter;
import dnd.utils.PlayerCharacterUtils;

/**
 * Servlet implementation class CharacterSelectServlet
 */
@WebServlet(name = "CharacterSelect", urlPatterns = { "/CharacterSelect" })
public class CharacterSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CharacterSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PlayerCharacterUtils pcu = new PlayerCharacterUtils();
		List<String> characterNames = pcu.getCharacterNames(getServletContext());
		List<PlayerCharacter> charactersList = new ArrayList<PlayerCharacter>();
		for(String name : characterNames) {
			PlayerCharacter pc = pcu.getCharacter(name, getServletContext());
			if(pc.getCharacterName()!=null) {
				charactersList.add(pc);
			}
		}
		request.setAttribute("charactersList", charactersList);
		
		RequestDispatcher view = request.getRequestDispatcher("main/mainCharacters.jsp");
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
