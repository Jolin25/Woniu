package com.woniuxy.java.basic;

import java.util.Scanner;

public class InputCharorString {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入你的姓名");
		String name = sc.next();
		System.out.println("请输入你的年龄");
		int age = sc.nextInt();
		System.out.println("请输入你的性别");
		char sex = sc.next().charAt(0);//输入char
		System.out.println("姓名:" + name +" 年龄:" + age +" 性别："+ sex);
		sc.close();
	}
}
