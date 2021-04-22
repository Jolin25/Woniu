package com.woniuxy.array.basic;

public class MutidensionArray3 {
	public static void main(String[] args) {
		int arr1[][] = { { 11, 11, 32 }, { 22, 32, 23 }, { 34, 22, 4 } };// 静态声明
		int arr2[][] = new int[3][3];// 动态声明
		int number1 = 0;
		int number2 = 0;
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				arr2[i][j] = i * 10 + j * 18;
				System.out.print(arr2[i][j] + "\t");

				if (arr2[i][j] < 50) {
					number2 += 1;
				}
			}
		}
		System.out.print("\n"+"人数：" + number2 +"\n");
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				
				System.out.print(arr1[i][j] + "\t");

				if (arr1[i][j] < 50) {
					number1 += 1;
				}
			}
		}
		System.out.print("\n"+"人数：" + number1+"\n");
	}
}
