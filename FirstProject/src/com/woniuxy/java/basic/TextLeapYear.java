//�����⣺�ж�����  �����⣺������
package com.woniuxy.java.basic;

import java.util.Scanner;

public class TextLeapYear {
	public static void main(String[]args) {
		System.out.println("��������ݣ�");
		Scanner sc = new Scanner(System.in);
		//�������
		int year = sc.nextInt();
		/*�жϸ����Ƿ�Ϊ����*/
		if(year % 4 != 0) {
			System.out.println("��������");
			System.out.println("������365��");
		}else if((year % 100 == 0 )&&( year % 400 != 0)) {
			System.out.println("��������");
			System.out.println("������365��");
		}else {
			System.out.println("������");
			System.out.println("������366��");
		}/* if((year%400 == 0)||(year%4==0 && year%100 != 0))
		 	Ҳ������������ж��ǲ�������*/
		
		sc.close();
	}
}
