package com.woniuxy.java.basic;

public class TextApp {
	public static void main(String[]args) {
		int x = 10;
		int y = 10;
		x++;
		y = ++x + y++;
		System.out.println(y);
	}
}
