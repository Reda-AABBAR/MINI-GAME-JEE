package com.model;

public abstract class Character implements Comparable<Character>, Prototype{
	private String name;
	private int pv;
	
	public Character(String name, int pv) {
		super();
		this.name = name;
		if(pv < 0)
			throw new IllegalStateException("le points de vie est inferiere a 0");
		else
			this.pv = pv;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPv() {
		return pv;
	}
	public void setPv(int pv) {
		this.pv = pv;
	}
	
	public boolean isAlive() {
		if(pv > 0) 
			return true;
		else
			return false;
	}
	
	public void takeDamage(int amount) {
		pv -= amount;
	}
	public abstract void attack(Character character) ;
	
	public String toString() {
		return "name : " + name + "\npoints de vie : " + pv;
	}
	public int compareTo(Character o) {
		
		return this.getPv() - o.getPv();
	}
}
