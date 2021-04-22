package com.woniuxy.basic.interface1;

public interface Shape {
	
	public static void main(String[] args) {
		System.out.println("hhhh");
	//	static void dd() {};//接口中的方法是不能在接口中实现的，只能由实现接口的类来实现接口中的方法
	}
	int age = 10;//对接口里的变量 默认添加public 、final、static
	//必须声明的时候初始化

	public abstract void zhouChang();

	void aa();//对接口里的抽象方法默认添加public abstract
	
	
	//对接口里的自定义方法 必须用default或static修饰
	default void bb() {
	}
	static void cc() {
		
	}
}
