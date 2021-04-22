//第一题：分数评级
package com.woniuxy.java.basic;

import java.util.Scanner;

public class TextIf {
	public static void main(String[]args) {
		//输入成绩
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入你的成绩：");
		int score = sc.nextInt();
		//判断成绩标准并输出
		if(score>80) {
			System.out.println("优");
		}else if(score > 70 && score <= 80){
			System.out.println("良");
		}else if(score > 60 && score <= 70){
			System.out.println("及格");
		}else if(score < 60){
			System.out.println("不及格");
		}
		sc.close();
	}
}
