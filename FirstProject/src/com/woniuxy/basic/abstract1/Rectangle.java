package com.woniuxy.basic.abstract1;

public class Rectangle extends Shape{
	int width;
	public Rectangle(int length,int width) {
		super(length);
		this.width = width;
		;
	}

	@Override
	public void zhouChang() {
		System.out.println("周长为："+(width + getLength())*2);
		
	}

	@Override
	public void mianJi() {
		System.out.println("面积为："+getLength() *this.width);		
	}

}
