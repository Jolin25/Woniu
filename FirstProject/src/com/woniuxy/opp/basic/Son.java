package com.woniuxy.opp.basic;

public class Son extends Father{
	{
		System.out.println("Son非静态--代码块---");
	}
	
	
	static{
		System.out.println("Son静态--代码块----");
	}
	
	public void b() {
		System.out.println("Son自定义-----方法----");
	}
	
	
	public Son() {
		System.out.println("Son默认---构造器----");
	}
	
	public Son(int i) {
		System.out.println("Son显示------构造器");
	}
	Son son1 = new Son();
}
