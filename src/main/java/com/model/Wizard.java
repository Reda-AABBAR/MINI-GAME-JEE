package com.model;

public class Wizard extends Player{
	

	private int mp;
	
	public Wizard(String name, int pv, int mp) {
		super(name, pv);
		this.mp = mp;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attack(Character character) {
		if(mp > 10) {
			character.takeDamage(10);
			mp -= 10;
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "\nPoints de mana : " + mp;
	}

	@Override
	public Prototype copy() {
		// TODO Auto-generated method stub
		return new Wizard(getName(), getPv(), mp);
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}
	
}
