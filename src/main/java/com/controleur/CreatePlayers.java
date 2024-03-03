package com.controleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metie.CharacterPrototypeRegistry;
import com.model.Character;
import com.model.Knight;
import com.model.Wizard;

/**
 * Servlet implementation class CreatePlayers
 */
@WebServlet("/CreatePlayers")
public class CreatePlayers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePlayers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String characterName = request.getParameter("player") ;
		
		Integer i;
		HttpSession session = request.getSession();
		Character[] character = ((Character[]) session.getAttribute("groupe"));
		CharacterPrototypeRegistry characters = (CharacterPrototypeRegistry) session.getAttribute("characters");
			i = (Integer) session.getAttribute("playersFill");
			if(i != null)
					System.out.println(i.intValue());
			else
					System.out.println("it's null");
		String[] imagePath = (String[]) session.getAttribute("imagesPath");
		if(imagePath == null) imagePath = new String[character.length];
		if(i.intValue() < character.length) {
			switch (characterName) {
			case "knight1": {
				imagePath[i] = "elements/Knight_1";
				break;
			}
			case "knight2": {
				imagePath[i] = "elements/Knight_2";
				break;
					}
			case "wizard1": {
				imagePath[i] = "elements/Fire vizard";
				break;
			}
			case "wizard2": {
				imagePath[i] = "elements/Lightning Mage";
				break;
			}
			case "wizard3": {
				imagePath[i] = "elements/Wanderer Magican";
				break;
				
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + characterName);
			}
			
			character[i] = (Character) characters.getCharacters().get(characterName).copy();
			session.setAttribute("imagesPath", imagePath);
			request.setAttribute("playersFill", new Integer(i.intValue() + 1));
		}else {
			request.setAttribute("playersFill", i);
			session.setAttribute("characters", characters);
			}
		request.setAttribute("groupe-table", character);
		getServletContext().getRequestDispatcher("/chooseTeam.jsp").forward(request, response);
	}
		

}
