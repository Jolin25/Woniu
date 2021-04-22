package com.woniuxy.polymorfhism.test2;

public class Fish extends Food {
	String size;

	public Fish(String name, String size) {
		super(name);
		this.size = size;
	}

	public String food() {
		return size + name;
	}

}