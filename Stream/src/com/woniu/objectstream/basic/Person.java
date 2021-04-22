package com.woniu.objectstream.basic;

import java.io.Serializable;

public class Person implements Serializable{//实现接口才可以被对象流使用
	String name;
	int age;
	public Person(String name,int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "姓名为："+name+"年龄为："+age;
	}
}
