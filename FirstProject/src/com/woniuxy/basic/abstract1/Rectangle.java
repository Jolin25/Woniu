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
		System.out.println("�ܳ�Ϊ��"+(width + getLength())*2);
		
	}

	@Override
	public void mianJi() {
		System.out.println("���Ϊ��"+getLength() *this.width);		
	}

}
