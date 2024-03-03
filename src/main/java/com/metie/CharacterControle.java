package com.metie;



import com.model.Enemy;
import com.model.Player;

public class CharacterControle {
	public static boolean hasPlayerAlive(Player[] players) {
		for (Player player : players) {
			if(player.isAlive())
				return true;
		}
		return false;
	}
	
	public static boolean hasEnemyAlive(Enemy[] enemies) {
		for (Enemy enemy : enemies) {
			if(enemy.isAlive())
				return true;
		}
		return false;
	}
	
	public static boolean estJeuxTerminer(Player[] players, Enemy[] enemies) {	
		if(!hasPlayerAlive(players) || !hasEnemyAlive(enemies))
			return true;
		return false;
	}
	
//	public static void playersAttack(Player[] players,Enemy[] enemies) {
//		
//		Scanner sc = new Scanner(System.in);
//		int i, len = enemies.length;
//
//		for (Player player : players) {
//			if(player.isAlive() && !estJeuxTerminer(players, enemies)) {
//				System.out.println("----------------------------------------------------------------------------------");
//				System.out.println(player.getName() +" va attaquer : ");
//				System.out.print("donner le numero de l'enemy que vous voulez attaquer : ");
//				i = sc.nextInt() - 1;
//				if(i >= 0 && i < len && enemies[i].isAlive()) {
//					player.attack(enemies[i]);
//				}else {
//					while((i < 0 || i >= len) || !enemies[i].isAlive())
//					{
//						System.out.print("donner un numero de l'enemy qui vous voulez attaquer : ");
//						i = sc.nextInt() - 1;
//					}
//					player.attack(enemies[i]);
//				}
//				System.out.println(player.getName() +" a attaquer " + enemies[i].getName());
//			}
//		}
//	}
	public static void enemiesAttack(Enemy[] enemies, Player[] players) {
		
		int i = 0;

		for (Enemy enemy : enemies) {
			if(enemy.isAlive() && !estJeuxTerminer(players, enemies)) {
				System.out.println("----------------------------------------------------------------------------------");
				System.out.println(enemy.getName() +" va attaquer : ");
				if(i >= players.length) 
					i = 0;
				while(!players[i].isAlive()) {
					i++;
					if(i >= players.length)
						i=0;
				
				}
				enemy.attack(players[i]);
				System.out.println(enemy.getName() +" a attaquer " + players[i].getName());
				i++;
				
			}
		}
	}
}
