package com.woniuxy.java.basic;

import java.util.Scanner;

public class InputCharorString {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�������������");
		String name = sc.next();
		System.out.println("�������������");
		int age = sc.nextInt();
		System.out.println("����������Ա�");
		char sex = sc.next().charAt(0);//����char
		System.out.println("����:" + name +" ����:" + age +" �Ա�"+ sex);
		sc.close();
	}
}
