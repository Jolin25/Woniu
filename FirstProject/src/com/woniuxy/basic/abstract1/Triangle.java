package com.woniuxy.basic.abstract1;

public  abstract class Triangle extends Shape {
     int lengthOfSideA;
     int lengthOgSideB;
	public Triangle(int length,int lengthOfSideA,int lengthOgSideB) {
		super(length);
	}
	
	public abstract void a ();//�������󷽷�

	@Override
	public void mianJi() {
		System.out.println("���Ϊ��"+getLength() );		
	}
		
	
	
}
