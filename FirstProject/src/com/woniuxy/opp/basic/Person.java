package com.woniuxy.opp.basic;

import java.util.Scanner;

public class Person {
	private String name;
	private String addr;
	private char sex;
	private int age;
	
	
	//四参
	public Person(String name,String addr,char sex,int age) {
		this.name=name;
		this.addr = addr;
		this.sex = sex;
		this.age = age;
		//System.out.println("姓名："+name+",地址："+addr+",性别："+sex+",年龄："+age);
	}
	//两参
	public Person(String one,int two) {
		this.name= one;
		//this.addr = one;
		this.age = two;
		//this.sex = (char) two;
		//System.out.println("姓名："+name+",年龄："+age);
	}
	//无参
	public Person() {
		
	}
	//输出方法
	public void show() {

		System.out.println("姓名："+name+",地址："+addr+",性别："+sex+",年龄："+age);
	}
	
}
