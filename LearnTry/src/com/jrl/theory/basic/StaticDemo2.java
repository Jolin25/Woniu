package com.jrl.theory.basic;

public class StaticDemo2 {
	public static void main(String[] args) {
		System.out.println(Test.s);
		 new Test();//ʵ�����˲Ż����Test���еľ�̬����飬��Ϊ���������ࣨStaticDemo2��Test����
	}
	static {
		System.out.println("��1");
	}
}

class Test {
	static {
		System.out.println("��3");
	}
	public static final String s = "��ţ2";
	static {
		System.out.println("��4");
	}
}
