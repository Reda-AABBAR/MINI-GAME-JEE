package com.controleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Character;
import com.model.Wizard;

/**
 * Servlet implementation class GroupChoose
 */
@WebServlet("/GroupChoose")
public class GroupChoose extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupChoose() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer nbrGroupPlayers = Integer.parseInt(request.getParameter("group-Number"));
		Character[]  character = new Character[nbrGroupPlayers];
		String[]  imagesPath = new String[nbrGroupPlayers];
		String[] playerType = new String[nbrGroupPlayers];
		request.setAttribute("groupe-table",character);
		request.setAttribute("groupe-number", nbrGroupPlayers);
		request.setAttribute("playersFill", Integer.valueOf(0));
		request.setAttribute("playersType", playerType);
		request.getSession().setAttribute("imagesPath", imagesPath);
		getServletContext().getRequestDispatcher("/chooseTeam.jsp").forward(request, response);
	}

}
