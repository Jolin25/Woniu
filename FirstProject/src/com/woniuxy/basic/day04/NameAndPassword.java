package com.woniuxy.basic.day04;

import java.util.Scanner;

public class NameAndPassword {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name;
		String passWord;
		int flag = 11;
		
		for (int i = 0; i < 3; i++) {
			System.out.println("请输入用户名：");
			name = sc.next();
			if (name.equals("妈耶")) {
				for (int j = 0; j < 3; j++) {
					System.out.println("请输入密码：");
					passWord = sc.next();
					if(passWord.equals("吃的")) {
						flag = 22;
						break;
					}
				}
			}
			System.out.println("用户名输入错误");
			if(flag == 22) {
				System.out.println("成功");
				break;
			}
			
		}
		sc.close();
	}
}
