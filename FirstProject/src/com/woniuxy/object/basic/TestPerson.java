package com.woniuxy.object.basic;

public class TestPerson {
	public static void main(String[] args) {
		Person person = new Person(10, "小张");
		Person person2 = new Person(10, "小张");
		Person person3 = new Person(12, "小张");
		System.out.println(person.equals(person3));
		System.out.println(person.equals(person2));
	}
	
}
