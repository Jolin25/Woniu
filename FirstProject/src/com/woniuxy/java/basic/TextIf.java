//��һ�⣺��������
package com.woniuxy.java.basic;

import java.util.Scanner;

public class TextIf {
	public static void main(String[]args) {
		//����ɼ�
		Scanner sc = new Scanner(System.in);
		
		System.out.println("��������ĳɼ���");
		int score = sc.nextInt();
		//�жϳɼ���׼�����
		if(score>80) {
			System.out.println("��");
		}else if(score > 70 && score <= 80){
			System.out.println("��");
		}else if(score > 60 && score <= 70){
			System.out.println("����");
		}else if(score < 60){
			System.out.println("������");
		}
		sc.close();
	}
}
