package com.woniuxy.opp.basic;

public class Father {
	{
		System.out.println("Father非静态--代码块---");
	}
	
	
	static{
		System.out.println("Father静态--代码块----");
	}
	
	public void a() {
		System.out.println("Father自定义-----方法----");
	}
	
	
	public Father() {
		System.out.println("Father默认---构造器----");
	}
	
	public Father(int i) {
		System.out.println("Father显示------构造器");
	}
	
}
