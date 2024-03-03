package com.model;

public abstract class Player extends Character{

	private int expiriance;
	public Player(String name, int pv) {
		super(name, pv);
	}
	public int getExpiriance() {
		return expiriance;
	}
	public void setExpiriance(int expiriance) {
		this.expiriance = expiriance;
	}
	
	@Override
	public void attack(Character character) {
		character.takeDamage(10);
		expiriance += 10;
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "\nl'expiriance : " + expiriance;
	}

}
