package com.woniuxy.string.basic;

import java.util.Scanner;

/*
 * 1��	�����û������2���ַ����Ƚ����ǵĴ�С��������ȽϽ�������ִ�С����ȣ���

 */
public class StringTest {
	public static void main(String[] args) {
		System.out.println("�������һ���ַ���");
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		System.out.println("������ڶ����ַ���");
		String str2 = sc.next();
		int i = str1.compareTo(str2);
		if(i<0) {
			System.out.println(str1+"С��"+str2);
		}else if(i>0) {
			System.out.println(str1+"����"+str2);
		}else {
			System.out.println(str1+"����"+str2);
		}
		
	}
}
