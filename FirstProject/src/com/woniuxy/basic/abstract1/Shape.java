package com.woniuxy.basic.abstract1;

public abstract class Shape {
	//
	private int length;
	
	//������
	
	public Shape(int length) {
		this.length = length;
	}
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	//���ܳ�
	public abstract void zhouChang();
	//�����
	public abstract void mianJi();
}
