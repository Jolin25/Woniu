package com.woniuxy.polymorphism.basic;

public class Son implements Person {

	int time;

	@Override
	public int eat() {
		
		System.out.println("¶ù×Ó³Ô¡£¡£¡£");
		return 5;
	}

	@Override
	public void paly(int time) {
		this.time = time;
		System.out.println("¶ù×ÓÍæ......"+time);
	}

}
