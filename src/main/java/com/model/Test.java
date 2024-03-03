package com.model;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class Test {
	private static boolean hasPlayerAlive(List<Player> players) {
		for (Player player : players) {
			if(player.isAlive())
				return true;
		}
		return false;
	}
	
	private static boolean hasEnemyAlive(List<Enemy> enemies) {
		for (Enemy enemy : enemies) {
			if(enemy.isAlive())
				return true;
		}
		return false;
	}
	
	private static boolean estJeuxTerminer(List<Player> players, List<Enemy> enemies) {	
		if(!hasPlayerAlive(players) || !hasEnemyAlive(enemies))
			return true;
		return false;
	}
	
	private static void playersAttack(List<Player> players,List<Enemy> enemies) {
		
		Scanner sc = new Scanner(System.in);
		int i, len = enemies.size();

		for (Player player : players) {
			if(player.isAlive() && !estJeuxTerminer(players, enemies)) {
				System.out.println("----------------------------------------------------------------------------------");
				System.out.println(player.getName() +" va attaquer : ");
				System.out.print("donner le numero de l'enemy que vous voulez attaquer : ");
				i = sc.nextInt() - 1;
				if(i >= 0 && i < len && enemies.get(i).isAlive()) {
					player.attack(enemies.get(i));
				}else {
					while((i < 0 || i >= len) || !enemies.get(i).isAlive())
					{
						System.out.print("donner un numero de l'enemy qui vous voulez attaquer : ");
						i = sc.nextInt() - 1;
					}
					player.attack(enemies.get(i));
				}
				System.out.println(player.getName() +" a attaquer " + enemies.get(i).getName());
			}
		}
	}
	private static void enemiesAttack(List<Enemy> enemies, List<Player> players) {
		
		int i = 0, len = players.size();

		for (Enemy enemy : enemies) {
			if(enemy.isAlive() && !estJeuxTerminer(players, enemies)) {
				System.out.println("----------------------------------------------------------------------------------");
				System.out.println(enemy.getName() +" va attaquer : ");
				i = (int) (len * Math.random());
				while(!players.get(i).isAlive()) {
					i = (int) (len * Math.random());
				}
				enemy.attack(players.get(i));
				System.out.println(enemy.getName() +" a attaquer " + players.get(i).getName());
			}
		}
	}
	
	private static ArrayList<Player> sort(List<Player> players) {
		int i;
		ArrayList<Player> playersByOrder = new ArrayList<Player>();
		playersByOrder.add(players.get(0));
		for (Player player : players) {
			for (Player player2 : playersByOrder) {
				if(player.compareTo(player2) < 0) {
					i = playersByOrder.indexOf(player2);
					playersByOrder.add(player2);
					playersByOrder.set(i, player);
					break;
				}
			}
		}
		return playersByOrder;
	}
	
	public static void main(String[] args) {
        ArrayList<Character> characters = new ArrayList<Character>();
        List<Player> players = new ArrayList<Player>();
        List<Enemy> enemies = new ArrayList<Enemy>();
        
        Knight knight = new Knight("Knight", 100);
        Wizard wizard = new Wizard("wizard", 150, 100);
        Enemy enemy = new Enemy("Enemy", 50, Loot.POTION); 

        characters.add(enemy);
        characters.add(wizard);
        characters.add(knight);
        for (Character character : characters) {
			if(character instanceof Player)
				players.add((Player) character);
			else if(character instanceof Enemy)
					enemies.add((Enemy) character);
		}
        
        while(!estJeuxTerminer(players,enemies)) {
        	playersAttack(players, enemies);
        	enemiesAttack(enemies, players);
        	for (Character character : characters) {
    			System.out.println(character.toString());
    		}
        }
        System.out.println("-----------------------FIN DE JUE---------------------------");
//        for (Character character : characters) {
//        	System.out.println(character.toString());
//		}
//        players = sort(players);
//      for (Player player : players) {
//    	System.out.println(player.toString());
//	}
      Collections.sort(characters);
      
      for (Character character : characters) {
    	  System.out.println(character.toString());
	}
        
        
    }
}
