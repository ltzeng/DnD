package dnd.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dnd.utils.PlayerCharacterUtils;

/**
 * Servlet implementation class CharacterDetailsEditServlet
 */
@WebServlet("/CharacterDetailsEdit")
public class CharacterDetailsEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PlayerCharacterUtils pcu = new PlayerCharacterUtils();
       
    public CharacterDetailsEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int characterID = Integer.parseInt(request.getParameter("characterID"));
		String exp = request.getParameter("exp");
		String level = request.getParameter("level");
		String maxHP = request.getParameter("maxHP");
		String hp = request.getParameter("hp");
		String tempHP = request.getParameter("tempHP");
		String armorClass = request.getParameter("armorClass");
		pcu.updatePlayerCharacterDetails(characterID, exp, level, maxHP, hp, tempHP, armorClass);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
