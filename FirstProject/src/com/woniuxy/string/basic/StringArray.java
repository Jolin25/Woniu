package com.woniuxy.string.basic;

import java.util.Scanner;

/*
 * ĳ����˾���ù��õ绰�������ݣ���������λ���������ڴ��ݹ������Ǽ��ܵģ�
 * ���ܹ������£�ÿλ���ֶ�����5,Ȼ���úͳ���10��������������֣�
 * �ٽ���һλ�͵���λ�������ڶ�λ�͵���λ������

 */
public class StringArray {
	public static void main(String[] args) {
		int[] data = new int[4];
		Scanner sc = new Scanner(System.in);
		for(int i = 0;i<data.length;i++) {
			System.out.println("�������"+(i+1)+"����");
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
