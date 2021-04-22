package com.woniuxy.basic.day04;

import java.util.Scanner;

public class MaxMin {
	public static void main(String[]args) {
		System.out.println("请输入10个数字：");
		Scanner sc = new Scanner(System.in);
		int [] number = new int[10] ;
		for(int i = 0;i<10;i++) {
			int a = sc.nextInt();
			number[i]=a;
		}
		int max = number[0];
		int min = number[0];
		for(int j = 0;j<10;j++) {
			if(max<number[j]) {
				max = number[j];
			}
			if(min>number[j]) {
				min = number[j];
			}
		}
		System.out.println("最大值为："+max+"最小值为："+min);
		sc.close();
	}
}
