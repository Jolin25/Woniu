package com.woniuxy.opp.basic;

import java.util.Scanner;

public class Person {
	private String name;
	private String addr;
	private char sex;
	private int age;
	
	
	//�Ĳ�
	public Person(String name,String addr,char sex,int age) {
		this.name=name;
		this.addr = addr;
		this.sex = sex;
		this.age = age;
		//System.out.println("������"+name+",��ַ��"+addr+",�Ա�"+sex+",���䣺"+age);
	}
	//����
	public Person(String one,int two) {
		this.name= one;
		//this.addr = one;
		this.age = two;
		//this.sex = (char) two;
		//System.out.println("������"+name+",���䣺"+age);
	}
	//�޲�
	public Person() {
		
	}
	//�������
	public void show() {

		System.out.println("������"+name+",��ַ��"+addr+",�Ա�"+sex+",���䣺"+age);
	}
	
}
