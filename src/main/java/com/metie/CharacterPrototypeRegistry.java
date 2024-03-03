package com.metie;

import java.util.HashMap;
import java.util.Map;

import com.model.Character;
import com.model.Enemy;
import com.model.Knight;
import com.model.Loot;
import com.model.Wizard;

public class CharacterPrototypeRegistry {
	private Map<String, Character> characters = new HashMap<String, Character>();
	
	public CharacterPrototypeRegistry() {
		characters.put("knight1", new Knight("knight1",100));
		characters.put("knight2", new Knight("knight2",150));
		characters.put("wizard1", new Wizard("wizard1", 100, 40));
		characters.put("wizard2", new Wizard("wizard2", 150, 20));
		characters.put("wizard3", new Wizard("wizard3", 120, 30));
		characters.put("enemy1", new Enemy("enemy1",100, Loot.POTION));
		characters.put("enemy2", new Enemy("enemy2",150,Loot.POTION));
		characters.put("enemy3", new Enemy("enemy3", 100,Loot.POTION));
		characters.put("enemy4", new Enemy("enemy4", 150, Loot.MANA_POSION));
		characters.put("enemy5", new Enemy("enemy5", 120, Loot.MANA_POSION));
	}

	public Map<String, Character> getCharacters() {
		return characters;
	}

	public void setCharacters(Map<String, Character> characters) {
		this.characters = characters;
	}
	
	
}
