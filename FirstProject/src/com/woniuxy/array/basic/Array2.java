package com.woniuxy.array.basic;

import java.util.Scanner;

public class Array2 {
	// ���ֵ
	public static void main(String[] args) {
		int[] arr1 = { 11, 22, 1 };
		int max = arr1[0];
		for (int i = 0; i < arr1.length; i++) {
			if (max < arr1[i]) {
				max = arr1[i];
			}
		}
		System.out.print("���ֵ�ǣ�" + max);
		System.out.println();
		System.out.println("---------------------");
		// �������ֵ
		int[] arr2 = { 8, 4, 2, 1, 23, 344, 12 };
		for (int element : arr2) {
			System.out.print(element + "\t");

		}
		System.out.println();
		// ���
		int total = 0;
		for (int i = 0; i < arr2.length; i++) {
			total += arr2[i];
		}
		System.out.println("��Ϊ��" + total);
		// �ж��Ƿ����
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ�����֣�");
		int thing = sc.nextInt();
		int flag = 0;
		for (int i = 0; i < arr2.length; i++) {
			if (arr2[i] == thing) {
				flag = 1;
				break;
			}
		}
		if (flag == 1) {
			System.out.print("����ͬ����");
		} else {
			System.out.print("û����ͬ����");
		}
		sc.close();
	}
}
