package com.woniuxy.java.basic;

import java.util.Scanner;

public class Learn041006 {
	public static void main(String[]args) {
		System.out.println("������HTML�ĳɼ���");
		Scanner sc = new Scanner(System.in);
		int htmlScore = sc.nextInt();
		System.out.println("������JAVA�ĳɼ���");
		int javaScore = sc.nextInt();
		System.out.println("���������ݿ�ĳɼ���");
		int SQLScore = sc.nextInt();
		if((htmlScore > 80 && javaScore > 90) || (javaScore == 100 && SQLScore > 70)) {
			System.out.println("��ϲ");
		}else {
			System.out.println("������ȥ" );
		}
		sc.close();
		
	}
}
