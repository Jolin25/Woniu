package com.woniuxy.opp.basic;



public class Student extends Person {

	int math;
	int english;

	// 两参
	public Student(int math,int english) {
		
		this.english = english;
		this.math = math;
		System.out.println("英语成绩为："+english+"数学成绩为："+math);
	}
	// 六参
	public Student(String name, String addr, char sex, int age, int math, int english) {
		super(name, addr, sex, age);//调用父类的构造方法
		
		this.math = math;
		this.english = english;
		System.out.println("姓名："+name+",地址："+addr+",性别："
		+sex+",年龄："+age+"，数学成绩："+math+"，英语成绩："+english);
	}

	// 无参
	public Student() {
		
		
	}
	// 重写
	@Override
	public void show(){	
		
		System.out.print("数学成绩："+math+"，英语成绩："+english);
		super.show();//调用父类的show方法
	}
}
