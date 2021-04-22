package com.woniuxy.polymorfhism.test3;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1、狗，2、猫，请选择：");
		int sel = sc.nextInt();
		
		if(sel==1) {
			System.out.println("你选择领养了"+((new Animals()).adopt(new Dog())).getName());
		}
		else if(sel ==2)
			System.out.println("你选择领养了"+((new Animals()).adopt(new Cat())).getName());
		else 
			System.out.println("输入不合法");
		sc.close();
	
	}

}
