package com.woniuxy.polymorphism.basic;

public class Sister implements Person {
	int time;
	@Override
	public int eat() {
		System.out.println("���ó�.....");
		return 3;
	}

	@Override
	public void paly(int time) {
		this.time = time;
		System.out.println("������....."+time);
	}

}
