package com.woniuxy.basic.abstract1;
/*
 * 孙子继承爸爸时，构造器是根据爹来的，
 * 后面重写方法时，需要把爸爸没有重写爷爷的部分和爸爸自己又扩展的抽象方法都重写了
 */
public class CongruentTriangle extends Triangle{

	public CongruentTriangle(int length, int lengthOfSideA, int lengthOgSideB) {
		super(length, lengthOfSideA, lengthOgSideB);
		
	}

	@Override
	public void a() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void zhouChang() {
		// TODO Auto-generated method stub
		
	}

	
		
	

	
}
