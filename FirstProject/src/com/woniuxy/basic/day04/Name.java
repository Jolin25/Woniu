package com.woniuxy.basic.day04;

import java.util.Scanner;

public class Name {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String name ;
		do {
			
			System.out.println("请输入用户名：");
			 name = sc.next();
		}while(name.equals("张三")!=true);//!name.equals("")
		System.out.println("Y");
		sc.close();
	}
}
