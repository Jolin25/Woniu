package com.woniuxy.basic.day04;

import java.util.Scanner;

public class Verification {
	public static void main(String[] args) {

		for (int i = 0; i < 3; i++) {
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入用户名：");
			String name = sc.next();
			if (name.equals("ii")) {
				System.out.println("Y");
				
				break;
			} else {
				
				if((2-i)!= 0) {
					System.out.print("N"+"还剩下"+(3-i-1)+"次");
				}else {
					System.exit(0);;//表示无异常的退出系统
				}
				
			}
			sc.close();
			
		}
		
		

	}

}
