package com.woniuxy.basic.abstract1;

public class Circle extends  Shape{

	public Circle(int length) {
		super(length);
		
	}

	@Override
	public void zhouChang() {
	  System.out.println("�ܳ�Ϊ��"+getLength() * 2 * Math.PI);
		
	}

	@Override
	public void mianJi() {
		System.out.println("���Ϊ��"+Math.PI * getLength()*getLength());
	}
	
	
	

}
