package com.woniuxy.string.basic;

import java.util.Scanner;
/*
 * 某个公司采用公用电话传递数据，数据是四位的整数，在传递过程中是加密的，
 * 加密规则如下：每位数字都加上5,然后用和除以10的余数代替该数字，
 * 再将第一位和第四位交换，第二位和第三位交换。

 */
public class StringArray2 {
	public static void main(String[] args) {
		char[] data = new char[4];
		System.out.println("请输入数据：");
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		for(int i = 0;i<str.length();i++) {
			data[i] =  ((char)(((int)(str.charAt(i)-'0')+5)%10+48));
		}
		char t = data[0];
		data[0] = data[3];
		data[3] = t;
		char tt = data[1];
		data[2] = data[1];
		data[1] = t;
		for (char i : data) {
			System.out.print(i+"  ");
		}
	}
}
