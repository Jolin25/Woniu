package com.woniuxy.clone.basic;

public class Book implements Cloneable {
	private String name;
	private double price;

	public Book(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// super.clone()会在堆中开辟一个新空间，然后返回子类的类型给引用

		return super.clone();
	}
}
