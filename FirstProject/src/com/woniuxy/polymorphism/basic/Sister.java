package com.woniuxy.polymorphism.basic;

public class Sister implements Person {
	int time;
	@Override
	public int eat() {
		System.out.println("รรรรณิ.....");
		return 3;
	}

	@Override
	public void paly(int time) {
		this.time = time;
		System.out.println("รรรรอๆ....."+time);
	}

}
