package dnd.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import dnd.domain.character.Note;
import dnd.utils.PlayerCharacterUtils;

@WebServlet("/CharacterNotes")
public class CharacterNotesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PlayerCharacterUtils pcu = new PlayerCharacterUtils();

    public CharacterNotesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String characterID = request.getParameter("characterID");
        String action = request.getParameter("action");
        
        if("update".equals(action)) {
            String noteID = request.getParameter("noteID");
            String note = request.getParameter("note");
            if(!StringUtils.isEmpty(noteID)) {
                pcu.updateNote(Integer.parseInt(noteID), note);
            }else {
                String title = request.getParameter("title");
                pcu.addNote(note,title, Integer.parseInt(characterID));
            }
        }
        
        
        List<Note> notes = pcu.getPlayerNotes(Integer.parseInt(characterID));
        
        request.setAttribute("notes", notes);
        request.setAttribute("characterID", characterID);
        RequestDispatcher view = request.getRequestDispatcher("main/player/editNotes.jsp");
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
