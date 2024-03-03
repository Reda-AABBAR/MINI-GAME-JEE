package com.controleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metie.CharacterControle;
import com.model.Enemy;
import com.model.Player;
import com.model.Character;

/**
 * Servlet implementation class Attack
 */
@WebServlet("/Attack")
public class Attack extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Attack() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String data = request.getParameter("command");
		
		if(data != null && data.equals("data")) {
			HttpSession session = request.getSession();
			Character[] players = (Character[]) session.getAttribute("groupe-table");
			Character[] enemies = (Character[]) session.getAttribute("enemies");
			Integer[] charactersPv = (Integer[]) session.getAttribute("charactersPv");
			Integer[] enemiesPv = (Integer[]) session.getAttribute("enemiesPv");
			String json = "";
			json += " {\"players\":[";
			for (int i = 0;i<players.length;i++) {
				json += "{\"id\":\"" + i +"\",\"name\":\"" + players[i].getName() + "\",\"pv\":\""+players[i].getPv()+"\",\"maxPV\":\""+ charactersPv[i] +"\"}";
				if(i < enemies.length - 1) {
					json += ",";
				}
			}
			json += "],\"enemies\":[";
			for (int i = 0;i<enemies.length;i++) {
				json += "{\"id\":\"" + i +"\",\"name\":\"" + enemies[i].getName() + "\",\"pv\":\""+enemies[i].getPv()+"\",\"maxPV\":\""+ enemiesPv[i]+"\"}";
				if(i < enemies.length - 1) {
					json += ",";
				}
			}
			json += "]}";
			PrintWriter out= response.getWriter();
			out.println(json);
		}else {
		System.out.println("le servelet attack est appller------------------------------------------------------------------------");
		HttpSession session = request.getSession();
		Character[] players = (Character[]) session.getAttribute("groupe-table");
		Character[] enemies = (Character[]) session.getAttribute("enemies");
		Integer i = (Integer) session.getAttribute("playersFill");
		Integer[] charactersPv = (Integer[]) session.getAttribute("charactersPv");
		Integer[] enemiesPv = (Integer[]) session.getAttribute("enemiesPv");
		String[] imagesPath = (String[]) session.getAttribute("imagesPath");
		Integer counter = (Integer) session.getAttribute("counter");
		String idEnemy = request.getParameter("id");
		Enemy[] myEnemies = new Enemy[enemies.length];
		Player[] myPlayers = new Player[players.length];
		int id = -1;
		try {
			id = Integer.valueOf(idEnemy.charAt(idEnemy.length() - 1));
		}catch(Exception e) {
			System.out.println("error : " + e.getMessage());
		}
		System.out.println(idEnemy);
		System.out.println(id - '0');
		for (int j = 0; j < myPlayers.length; j++) {
			if(players[j] instanceof Player)
				myPlayers[j] = (Player) players[j];
			if(enemies[j] instanceof Enemy)
				myEnemies[j] = (Enemy) enemies[j];
		}
		
		if(counter == null)
			counter = new Integer(0);
		if(counter < players.length && id > -1) {
			((Player) players[counter]).attack(enemies[id-'0']);
			counter = new Integer(counter.intValue() + 1);
		}
		else {
			if(!CharacterControle.estJeuxTerminer(myPlayers, myEnemies)) {
			CharacterControle.enemiesAttack(myEnemies,myPlayers);
			counter = new Integer(0);
			}
		}
		session.setAttribute("groupe-table", players);
		session.setAttribute("playersFill", i);
		session.setAttribute("enemies", enemies);
		session.setAttribute("charactersPv", charactersPv);
		session.setAttribute("enemiesPv", enemiesPv);
		session.setAttribute("imagesPath", imagesPath);
		session.setAttribute("counter", counter);
		
		request.getServletContext().getRequestDispatcher("/game.jsp").forward(request, response);
		}
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
