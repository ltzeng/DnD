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

/**
 * Servlet implementation class CharacterSheet
 */
@WebServlet("/CharacterSheet")
public class CharacterSheetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PlayerCharacterUtils pcu;
	private PlayerCharacter pc;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CharacterSheetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
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
		System.out.println("##########################");
		System.out.println("##########################");
		System.out.println("##########################");
//		ServletContext context = this.getServletContext();
//		System.out.println(getServletContext().getResourceAsStream("WEB-INF/characters/JinYang"));
//		Properties prop=new Properties();
//		try {
//			prop.load(getServletContext().getResourceAsStream("WEB-INF/characters/JinYang"));
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		for(Object key : prop.keySet()) {
//			System.out.println(key);
//		}
		
		
		pcu = new PlayerCharacterUtils();
        try {
        	pc = pcu.getCharacter("JinYang", getServletContext());
        } catch (Exception e) {
            getServletContext().log("An exception occurred in CharacterSheet", e);
            throw new ServletException("An exception occurred in CharacterSheet "
                    + e.getMessage());
        }
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
