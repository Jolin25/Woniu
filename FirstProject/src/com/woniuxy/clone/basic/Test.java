package com.woniuxy.clone.basic;

public class Test {
	public static void main(String[] args) throws CloneNotSupportedException {
		/*
		 * 浅表克隆，当Book没有实现接口cloneable、重写clone
		 * 以及Person重写clone时没有特别把Book对象的克隆对象保存在Person对象中时
		 */

		Book book = new Book("母爱的羁绊", 20);
		Person p1 = new Person("张一", 17, book);
		Person p2 = (Person) p1.clone();// p1,p2 的地址是不同的，是两个独立的个体
		System.out.println(p2.book.getName());
		p2.book.setName("如何阅读一本书");// 浅克隆，book对象的地址p1和p2是共用的
		p2.setAge(19);
		p2.setName("张二");
		p2.book.setPrice(30);// 浅克隆，book对象的地址p1和p2是共用的
		System.out.println(p2);
		System.out.println(p1);
		// Book 中没重写toString ，打印出book对象的地址，为同一个，
		// 因为Book是自定义类，没有实现接口cloneable
		System.out.println(p1.book);
		System.out.println(p2.book);
		/*
		 * 深表克隆
		 */

	}

}
