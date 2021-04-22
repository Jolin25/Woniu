package com.woniuxy.java.basic;

import java.util.Scanner;

public class Learn041006 {
	public static void main(String[]args) {
		System.out.println("请输入HTML的成绩：");
		Scanner sc = new Scanner(System.in);
		int htmlScore = sc.nextInt();
		System.out.println("请输入JAVA的成绩：");
		int javaScore = sc.nextInt();
		System.out.println("请输入数据库的成绩：");
		int SQLScore = sc.nextInt();
		if((htmlScore > 80 && javaScore > 90) || (javaScore == 100 && SQLScore > 70)) {
			System.out.println("恭喜");
		}else {
			System.out.println("抄代码去" );
		}
		sc.close();
		
	}
}
