package com.woniu.objectstream.basic;

import java.io.Serializable;

public class Person implements Serializable{//ʵ�ֽӿڲſ��Ա�������ʹ��
	String name;
	int age;
	public Person(String name,int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "����Ϊ��"+name+"����Ϊ��"+age;
	}
}
