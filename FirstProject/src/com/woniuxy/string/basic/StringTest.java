package com.woniuxy.string.basic;

import java.util.Scanner;

/*
 * 1、	接受用户输入的2个字符，比较它们的大小，并输出比较结果（区分大、小及相等）；

 */
public class StringTest {
	public static void main(String[] args) {
		System.out.println("请输入第一个字符：");
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		System.out.println("请输入第二个字符：");
		String str2 = sc.next();
		int i = str1.compareTo(str2);
		if(i<0) {
			System.out.println(str1+"小于"+str2);
		}else if(i>0) {
			System.out.println(str1+"大于"+str2);
		}else {
			System.out.println(str1+"等于"+str2);
		}
		
	}
}
