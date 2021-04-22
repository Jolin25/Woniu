package com.woniuxy.basic.abstract1;
/*
 * 1、定义一个人的类(属性有名字，年龄。写一个能输出各自个属 性值的方法showInfo())，
 * 定义一个学生类(属性有性别)，学生继 承人类。
要求：
1）父类的属性赋值用构造方法来实现；
2）子类 的属性也用构造方法来赋值；
3）在子类中重写父类的showInfo() 方法；
4）声明学生类的对象，调用学生的显示信息的方法；
 */
public class Student extends Person {
	
	char sex;
	//构造器
	public Student(String name, int age,char sex) {
		super(name, age);
		this.sex = sex;
		
	}
	//重写
	@Override
	public void showInfo() {
		System.out.println("姓名："+name+"，年龄："+age+"，性别："+sex);
	}

}
