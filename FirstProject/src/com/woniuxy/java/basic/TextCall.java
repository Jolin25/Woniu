//�����⣺�绰��
package com.woniuxy.java.basic;

import java.util.Scanner;

public class TextCall {
	public static void main(String[]args) {
		//����绰��ݺ�
		System.out.println("������Ҫ����Ŀ�ݺţ�");
		Scanner sc = new Scanner(System.in);
		int call = sc.nextInt();
		//�ж������������˭ƥ��
		switch(call) {
		case 1:
			System.out.println("����ְֵĺ�");
			break;
		case 2:
			System.out.println("��������ĺ�");
			break;
		case 3:
			System.out.println("����үү�ĺ�");
			break;
		case 4:
			System.out.println("�������̵ĺ�");
			break;
			default:
				System.out.println("�������");
				break;
		}
		sc.close();
		}
}
