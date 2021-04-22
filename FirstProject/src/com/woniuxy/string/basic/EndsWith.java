package com.woniuxy.string.basic;

import java.util.Scanner;

/*
 * 6、	判断输入的字符串是否是 .java 结束；

 */
public class EndsWith {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个字符串");
		String str = sc.next();
		System.out.println(str.endsWith(".java"));
	}
}
