package com.woniuxy.java.basic;

public class Changeinto {
	public static void main(String[]args) {
		String a = "120";
		String b = "5";
		//将字符串转化为int型
		int a1 = Integer.parseInt(a);
		int b1 = Integer.valueOf(b);
		System.out.println(a1/b1);
	}
}
