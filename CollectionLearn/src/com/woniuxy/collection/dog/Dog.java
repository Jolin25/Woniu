package com.woniuxy.collection.dog;

public class Dog {
	private String name;
	private String type;//Ʒ��
	private String color;
	private int age;
	//������
	public Dog() {
		
	}
	//������
	public Dog(String name,String type,String color,int age) {
		this.age = age;
		this.color =color;
		this.type = type;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return name + age + color + type;
	}
	public void show() {
		
		System.out.println("��������ƣ�"+name);
		System.out.println("�����Ʒ�֣�"+type);
		System.out.println("��������䣺"+age);
		System.out.println("�������ɫ��"+color);
	}
	
}
