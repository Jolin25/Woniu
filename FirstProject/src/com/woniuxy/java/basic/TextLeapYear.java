//第三题：判断闰年  第五题：求天数
package com.woniuxy.java.basic;

import java.util.Scanner;

public class TextLeapYear {
	public static void main(String[]args) {
		System.out.println("请输入年份：");
		Scanner sc = new Scanner(System.in);
		//输入年份
		int year = sc.nextInt();
		/*判断该年是否为闰年*/
		if(year % 4 != 0) {
			System.out.println("不是闰年");
			System.out.println("该年有365天");
		}else if((year % 100 == 0 )&&( year % 400 != 0)) {
			System.out.println("不是闰年");
			System.out.println("该年有365天");
		}else {
			System.out.println("是闰年");
			System.out.println("该年有366天");
		}/* if((year%400 == 0)||(year%4==0 && year%100 != 0))
		 	也可以用这个来判断是不是闰年*/
		
		sc.close();
	}
}
