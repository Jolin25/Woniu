package com.woniuxy.string.basic;

import java.util.Scanner;

/*
 * 某个公司采用公用电话传递数据，数据是四位的整数，在传递过程中是加密的，
 * 加密规则如下：每位数字都加上5,然后用和除以10的余数代替该数字，
 * 再将第一位和第四位交换，第二位和第三位交换。

 */
public class StringArray {
	public static void main(String[] args) {
		int[] data = new int[4];
		Scanner sc = new Scanner(System.in);
		for(int i = 0;i<data.length;i++) {
			System.out.println("请输入第"+(i+1)+"数字");
			data[i] = sc.nextInt();
		}
		
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum = sum + data[i] + 5;
		}
		for (int i = 0; i < data.length; i++) {

			data[i] = sum % 10;

		}
		int t = data[0];
		data[0] = data[3];
		data[3] = t;
		int tt = data[1];
		data[2] = data[1];
		data[1] = t;
		for (int i : data) {
			System.out.println(i);
		}
	}
}
