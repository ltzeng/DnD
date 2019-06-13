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

/**
 * Servlet implementation class CharacterDetailsEditServlet
 */
@WebServlet("/CharacterDetailsEdit")
public class CharacterDetailsEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PlayerCharacterUtils pcu = new PlayerCharacterUtils();
	private EquipmentUtils eu = new EquipmentUtils();
       
    public CharacterDetailsEditServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int characterID = Integer.parseInt(request.getParameter("characterID"));
		String action = request.getParameter("action");
		PlayerCharacter pc = pcu.getCharacter(characterID);
		pc = eu.getCharacterEquipmentList(pc);
		
		if("update".equals(action)) {
			String exp = request.getParameter("exp");
			String level = request.getParameter("level");
			String maxHP = request.getParameter("maxHP");
			String hp = request.getParameter("hp");
			String tempHP = request.getParameter("tempHP");
			String armorClass = request.getParameter("armorClass");
			String copper = request.getParameter("copper");
			String silver = request.getParameter("silver");
			String gold = request.getParameter("gold");
			String electrum = request.getParameter("electrum");
			String platinum = request.getParameter("platinum");
			pcu.updatePlayerCharacterDetails(characterID, exp, level, maxHP, hp, tempHP, armorClass);
			pcu.updatePlayerCurrency(characterID, copper, silver, gold, electrum, platinum);
			
			RequestDispatcher view = request.getRequestDispatcher("CharacterDetails?characterID=" +characterID);
			view.forward(request, response);
		}else {
			request.setAttribute("pc", pc);
			RequestDispatcher view = request.getRequestDispatcher("main/player/characterDetailsEdit.jsp");
			view.forward(request, response);
		}

		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
