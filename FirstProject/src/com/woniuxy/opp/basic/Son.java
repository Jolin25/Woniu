package com.woniuxy.opp.basic;

public class Son extends Father{
	{
		System.out.println("Son�Ǿ�̬--�����---");
	}
	
	
	static{
		System.out.println("Son��̬--�����----");
	}
	
	public void b() {
		System.out.println("Son�Զ���-----����----");
	}
	
	
	public Son() {
		System.out.println("SonĬ��---������----");
	}
	
	public Son(int i) {
		System.out.println("Son��ʾ------������");
	}
	Son son1 = new Son();
}
