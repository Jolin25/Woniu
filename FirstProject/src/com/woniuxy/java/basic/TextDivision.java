//第二题：判断是否能被3、5、7整除
package com.woniuxy.java.basic;

import java.util.Scanner;

public class TextDivision {
	//输入数字
	public static void main(String[]args) {
		System.out.println("请输入数字：");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int flag1 = 0;
		int flag2 = 0;
		int flag3 = 0;
		/* int flag1 = number % 3;
		 * int flag2 = number % 5;
		 * int flag3 = number % 7;
		 * 也可以用这个来求flag的值
		 * 不过这里是flag==0 代表整除*/
		if(number%3 == 0) {
			flag1 = 1;
		}
		if (number%5==0) {
			flag2 = 1;
		}
		if(number%7==0) {
			flag3 = 1;
		}//分类讨论是否符合整除条件
		if(flag1 ==1 && flag2 == 1 && flag3 == 1) {
			System.out.println("该数可以被3、5、7同时整除");
		}else if(flag1 == 1 && flag2 ==1) {
			System.out.println("该数可以被3、5同时整除");
		}else if(flag1 == 1 && flag3 ==1){
			System.out.println("该数可以被3、7同时整除");
		}else if(flag2 == 1 && flag3 ==1){
			System.out.println("该数可以被5、7同时整除");
		}else if(flag1 == 1 ){
			System.out.println("该数可以被3整除");
		}else if(flag2 == 1 ){
			System.out.println("该数可以被5整除");
		}else if(flag3 == 1 ){
			System.out.println("该数可以被7整除");
		}else {
			System.out.print("该数无法整除3或5或7");
		}
		sc.close();
		}
		
}
