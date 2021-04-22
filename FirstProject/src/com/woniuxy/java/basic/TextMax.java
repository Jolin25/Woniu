//第四题：输出最大
package com.woniuxy.java.basic;

import java.util.Scanner;

public class TextMax {
	public static void main(String[]args) {
		System.out.println("请输入三个数字：");//输入三个数字
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int max = a;//先默认最大为a
		/*进行判断*/
		if(b>a) {
			max = b;
			if(c>b) {
				max = c;
			}else {
				max = b;
			}
		}else if(c>a) {
			max = c;
		}else {
			max = a;
		}
		System.out.print(max);
		sc.close();
	}
}
