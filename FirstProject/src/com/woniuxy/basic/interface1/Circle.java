package com.woniuxy.basic.interface1;

public class Circle implements Shape{
	int length;
	public Circle(int length) {
		this.length = length;
	}
	@Override
	public void zhouChang() {
		 System.out.println("�ܳ�Ϊ��"+length * 2 * Math.PI);
			
		
	}
	@Override
	public void aa() {
		// TODO Auto-generated method stub
		
	}

}
