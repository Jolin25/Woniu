package com.woniuxy.polymorfhism.test2;

public class Bone extends Food {

	public Bone(String name, String type) {
		super(name);
		this.type = type;
	}

	String type;

	public String food() {
		return type + name;
	}

}
