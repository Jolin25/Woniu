package com.woniuxy.polymorfhism.test3;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1������2��è����ѡ��");
		int sel = sc.nextInt();
		
		if(sel==1) {
			System.out.println("��ѡ��������"+((new Animals()).adopt(new Dog())).getName());
		}
		else if(sel ==2)
			System.out.println("��ѡ��������"+((new Animals()).adopt(new Cat())).getName());
		else 
			System.out.println("���벻�Ϸ�");
		sc.close();
	
	}

}
