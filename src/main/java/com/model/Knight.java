package com.model;

public class Knight extends Player{

	public Knight(String name, int pv) {
		super(name, pv);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Prototype copy() {
		// TODO Auto-generated method stub
		return new Knight(getName(), getPv());
	}
	
	
}
