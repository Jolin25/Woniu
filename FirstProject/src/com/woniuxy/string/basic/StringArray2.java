package com.woniuxy.string.basic;

import java.util.Scanner;
/*
 * ĳ����˾���ù��õ绰�������ݣ���������λ���������ڴ��ݹ������Ǽ��ܵģ�
 * ���ܹ������£�ÿλ���ֶ�����5,Ȼ���úͳ���10��������������֣�
 * �ٽ���һλ�͵���λ�������ڶ�λ�͵���λ������

 */
public class StringArray2 {
	public static void main(String[] args) {
		char[] data = new char[4];
		System.out.println("���������ݣ�");
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
