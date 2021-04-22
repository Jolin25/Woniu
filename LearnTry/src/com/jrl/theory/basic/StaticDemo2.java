package com.jrl.theory.basic;

public class StaticDemo2 {
	public static void main(String[] args) {
		System.out.println(Test.s);
		 new Test();//实例化了才会调用Test类中的静态代码块，因为这是两个类（StaticDemo2和Test）啊
	}
	static {
		System.out.println("好1");
	}
}

class Test {
	static {
		System.out.println("好3");
	}
	public static final String s = "蜗牛2";
	static {
		System.out.println("好4");
	}
}
