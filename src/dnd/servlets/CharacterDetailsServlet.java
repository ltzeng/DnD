package dnd.servlets;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dnd.domain.character.PlayerCharacter;
import dnd.utils.PlayerCharacterUtils;

@WebServlet("/CharacterDetails")
public class CharacterDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PlayerCharacterUtils pcu;
	private PlayerCharacter pc;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CharacterDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("charName");
		
		pcu = new PlayerCharacterUtils();
        try {
        	pc = pcu.getCharacter(name, getServletContext());
        } catch (Exception e) {
            getServletContext().log("An exception occurred in CharacterSheet", e);
            throw new ServletException("An exception occurred in CharacterSheet " + e.getMessage());
        }
        
		request.setAttribute("characterName", pc.getCharacterName());
		request.setAttribute("level", pc.getLevel());
		response.getWriter().append(pc.getCharacterName());
		response.getWriter().append("\n");
		response.getWriter().append(pc.getAbilityScores().toString());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	@Override
    public void init() throws ServletException {
		
    }

    public void destroy() {
        super.destroy();
        try {
//            dao.save(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
