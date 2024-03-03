package com.model;

public class Enemy extends Character{
	private Loot loot;
	public Enemy(String name, int pv, Loot loot) {
		super(name, pv);
		this.loot = loot;
	}

	@Override
	public void attack(Character character) {
		character.takeDamage(5);
		
	}

	@Override
	public Prototype copy() {
		return new Enemy(this.getName(), this.getPv(), loot);
	}
}
