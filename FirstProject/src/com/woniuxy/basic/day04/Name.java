package com.woniuxy.basic.day04;

import java.util.Scanner;

public class Name {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String name ;
		do {
			
			System.out.println("�������û�����");
			 name = sc.next();
		}while(name.equals("����")!=true);//!name.equals("")
		System.out.println("Y");
		sc.close();
	}
}
