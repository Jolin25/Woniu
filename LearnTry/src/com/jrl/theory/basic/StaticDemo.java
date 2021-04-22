package com.jrl.theory.basic;

public class StaticDemo {
	static {
		int x = 10;
		System.out.println("static:"+x);
	}
	static int x,y;
	public static void test1() {
		 int z = 0;
		 int y;
		y = x++ + ++x;
		System.out.println(y);
		System.out.println(x);
	}
	
	public static void main(String[] args) {
		StaticDemo s = new StaticDemo();
		s.test1();
		
		System.out.println(x);
	}
}
