package com.woniuxy.polymorphism.basic;

public class Demo {
	public int test(Person per) {
		per.eat();
		per.paly(2);
		return per.eat();
	}

	public static void main(String[] args) {
		Demo demo = new Demo();//���������һ������
		// ��̬��
		// �ӿ��� ������ = new ʵ����������
		Person per = new Son();
		demo.test(per);
	    int i = demo.test(per);
	    int j = demo.test(new Sister());
		System.out.println(i+"  "+j);
	}
}
