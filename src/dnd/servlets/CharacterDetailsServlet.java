package dnd.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dnd.domain.character.PlayerCharacter;
import dnd.utils.EquipmentUtils;
import dnd.utils.PlayerCharacterUtils;

@WebServlet("/CharacterDetails")
public class CharacterDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PlayerCharacterUtils pcu = new PlayerCharacterUtils();
	private EquipmentUtils eu = new EquipmentUtils();
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
		
		int characterID = Integer.parseInt(request.getParameter("characterID"));
		
        try {
            pc = pcu.getCharacter(characterID);
            eu.getCharacterEquipmentList(request.getSession(), getServletContext(), pc);
        } catch (Exception e) {
            getServletContext().log("An exception occurred in CharacterSheet", e);
            throw new ServletException("An exception occurred in CharacterSheet " + e.getMessage());
        }
        
		request.setAttribute("pc", pc);
		RequestDispatcher view = request.getRequestDispatcher("main/characterDetails.jsp");
		view.forward(request, response);
		
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
