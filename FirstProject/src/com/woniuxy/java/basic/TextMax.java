//�����⣺������
package com.woniuxy.java.basic;

import java.util.Scanner;

public class TextMax {
	public static void main(String[]args) {
		System.out.println("�������������֣�");//������������
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int max = a;//��Ĭ�����Ϊa
		/*�����ж�*/
		if(b>a) {
			max = b;
			if(c>b) {
				max = c;
			}else {
				max = b;
			}
		}else if(c>a) {
			max = c;
		}else {
			max = a;
		}
		System.out.print(max);
		sc.close();
	}
}
