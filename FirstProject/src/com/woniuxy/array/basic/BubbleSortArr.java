package com.woniuxy.array.basic;

//ð������
public class BubbleSortArr {
	public static void main(String[] args) {
		int[] arr1 = { 1, 6, 3, 8, 5, 4 };
		int t = 0;
		// ��С����
		for (int i = 0; i < arr1.length - 1; i++) {
			for (int j = 0; j < arr1.length - 1 - i; j++) {
				if (arr1[j] > arr1[j + 1]) {
					t = arr1[j];
					arr1[j] = arr1[j + 1];
					arr1[j + 1] = t;
				}
			}
		}
		for (int i : arr1) {
			System.out.print(i + " ");
		}
		System.out.println("");
		// �Ӵ�С
		for (int i = 0; i < arr1.length - 1; i++) {
			for (int j = 0; j < arr1.length - 1 - i; j++) {
				if (arr1[j] < arr1[j + 1]) {
					t = arr1[j];
					arr1[j] = arr1[j + 1];
					arr1[j + 1] = t;
				}
			}
		}
		for (int i : arr1) {
			System.out.print(i + " ");
		}
	}
}
