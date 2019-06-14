package dnd.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dnd.adventure.Adventure;
import dnd.dao.AdventureDAO;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/Home")
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public HomeServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        AdventureDAO aDAO = new AdventureDAO();
        List<Adventure> adventures = null;
        try {
            adventures = aDAO.getAdventures();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("adventures", adventures);
        
        RequestDispatcher view = request.getRequestDispatcher("main/homepage.jsp");
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
