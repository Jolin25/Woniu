package com.woniuxy.basic.system;
/*
 * Ҫ�����յ�
 */
public class Person {
	String name;
	public Person(String name) {
		this.name  = name;
	}
	@Override
		protected void finalize() throws Throwable {
			System.out.println("���ճɹ�:"+this.name);
		}
}
