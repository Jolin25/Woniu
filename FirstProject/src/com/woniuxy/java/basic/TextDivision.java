//�ڶ��⣺�ж��Ƿ��ܱ�3��5��7����
package com.woniuxy.java.basic;

import java.util.Scanner;

public class TextDivision {
	//��������
	public static void main(String[]args) {
		System.out.println("���������֣�");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int flag1 = 0;
		int flag2 = 0;
		int flag3 = 0;
		/* int flag1 = number % 3;
		 * int flag2 = number % 5;
		 * int flag3 = number % 7;
		 * Ҳ�������������flag��ֵ
		 * ����������flag==0 ��������*/
		if(number%3 == 0) {
			flag1 = 1;
		}
		if (number%5==0) {
			flag2 = 1;
		}
		if(number%7==0) {
			flag3 = 1;
		}//���������Ƿ������������
		if(flag1 ==1 && flag2 == 1 && flag3 == 1) {
			System.out.println("�������Ա�3��5��7ͬʱ����");
		}else if(flag1 == 1 && flag2 ==1) {
			System.out.println("�������Ա�3��5ͬʱ����");
		}else if(flag1 == 1 && flag3 ==1){
			System.out.println("�������Ա�3��7ͬʱ����");
		}else if(flag2 == 1 && flag3 ==1){
			System.out.println("�������Ա�5��7ͬʱ����");
		}else if(flag1 == 1 ){
			System.out.println("�������Ա�3����");
		}else if(flag2 == 1 ){
			System.out.println("�������Ա�5����");
		}else if(flag3 == 1 ){
			System.out.println("�������Ա�7����");
		}else {
			System.out.print("�����޷�����3��5��7");
		}
		sc.close();
		}
		
}
