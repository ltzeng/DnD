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
        List<PlayerCharacter> charactersList = pcu.getCharacterForAdventure(Integer.parseInt(request.getParameter("adventureID")));
        request.setAttribute("charactersList", charactersList);

        RequestDispatcher view = request.getRequestDispatcher("main/player/mainCharacters2.jsp");
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
