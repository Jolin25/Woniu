package com.woniuxy.basic.day04;

import java.util.Scanner;

public class NameAndPassword {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name;
		String passWord;
		int flag = 11;
		
		for (int i = 0; i < 3; i++) {
			System.out.println("�������û�����");
			name = sc.next();
			if (name.equals("��Ү")) {
				for (int j = 0; j < 3; j++) {
					System.out.println("���������룺");
					passWord = sc.next();
					if(passWord.equals("�Ե�")) {
						flag = 22;
						break;
					}
				}
			}
			System.out.println("�û����������");
			if(flag == 22) {
				System.out.println("�ɹ�");
				break;
			}
			
		}
		sc.close();
	}
}
