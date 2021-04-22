package com.woniuxy.basic.day04;

import java.util.Scanner;

public class BooleanDoWhile {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String name ;
		boolean flag = true;
		do {
			System.out.println("请输入用户名：");
			name = sc.next();
			if(name.equals("张三")) {
				flag = false;
			}
			
		}while(flag);
		System.out.println("Y");
		sc.close();
	}
	
}
