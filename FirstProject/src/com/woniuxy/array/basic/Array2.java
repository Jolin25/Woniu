package com.woniuxy.array.basic;

import java.util.Scanner;

public class Array2 {
	// 最大值
	public static void main(String[] args) {
		int[] arr1 = { 11, 22, 1 };
		int max = arr1[0];
		for (int i = 0; i < arr1.length; i++) {
			if (max < arr1[i]) {
				max = arr1[i];
			}
		}
		System.out.print("最大值是：" + max);
		System.out.println();
		System.out.println("---------------------");
		// 输出数组值
		int[] arr2 = { 8, 4, 2, 1, 23, 344, 12 };
		for (int element : arr2) {
			System.out.print(element + "\t");

		}
		System.out.println();
		// 求和
		int total = 0;
		for (int i = 0; i < arr2.length; i++) {
			total += arr2[i];
		}
		System.out.println("和为：" + total);
		// 判断是否包含
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个数字：");
		int thing = sc.nextInt();
		int flag = 0;
		for (int i = 0; i < arr2.length; i++) {
			if (arr2[i] == thing) {
				flag = 1;
				break;
			}
		}
		if (flag == 1) {
			System.out.print("有相同的数");
		} else {
			System.out.print("没有相同的数");
		}
		sc.close();
	}
}
