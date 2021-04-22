package com.woniuxy.basic.system;
/*
 * 要被回收的
 */
public class Person {
	String name;
	public Person(String name) {
		this.name  = name;
	}
	@Override
		protected void finalize() throws Throwable {
			System.out.println("回收成功:"+this.name);
		}
}
