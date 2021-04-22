package com.woniuxy.basic.abstract1;

public abstract class Shape {
	//
	private int length;
	
	//构造器
	
	public Shape(int length) {
		this.length = length;
	}
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	//求周长
	public abstract void zhouChang();
	//求面积
	public abstract void mianJi();
}
