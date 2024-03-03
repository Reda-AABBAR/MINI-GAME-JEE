package com.controleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metie.CharacterPrototypeRegistry;
import com.model.Character;

/**
 * Servlet implementation class Game
 */
@WebServlet("/Game")
public class Game extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Game() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Character[] characters = (Character[]) session.getAttribute("groupe");
		Integer i = (Integer) session.getAttribute("playersFill");
		Character[] enemy = new Character[i.intValue()];
		String[] imagesPath = (String[]) session.getAttribute("imagesPath");
		CharacterPrototypeRegistry prototypeRegistry = new CharacterPrototypeRegistry();
		
		for(int j = 0; j < enemy.length; j++) {
			enemy[j] = (Character) prototypeRegistry.getCharacters().get("enemy"+(j + 1)).copy();
		}
		
		session.setAttribute("enemies", enemy);
		session.setAttribute("playersFill", i);
		session.setAttribute("groupe-table", characters);
		session.setAttribute("imagesPath", imagesPath);
		getServletContext().getRequestDispatcher("/game.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
