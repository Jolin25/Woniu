package com.woniuxy.basic.day04;

import java.util.Scanner;

public class Verification {
	public static void main(String[] args) {

		for (int i = 0; i < 3; i++) {
			Scanner sc = new Scanner(System.in);
			System.out.println("�������û�����");
			String name = sc.next();
			if (name.equals("ii")) {
				System.out.println("Y");
				
				break;
			} else {
				
				if((2-i)!= 0) {
					System.out.print("N"+"��ʣ��"+(3-i-1)+"��");
				}else {
					System.exit(0);;//��ʾ���쳣���˳�ϵͳ
				}
				
			}
			sc.close();
			
		}
		
		

	}

}
