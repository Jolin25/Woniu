package com.woniuxy.basic.interface1;

public interface Shape {
	
	public static void main(String[] args) {
		System.out.println("hhhh");
	//	static void dd() {};//�ӿ��еķ����ǲ����ڽӿ���ʵ�ֵģ�ֻ����ʵ�ֽӿڵ�����ʵ�ֽӿ��еķ���
	}
	int age = 10;//�Խӿ���ı��� Ĭ�����public ��final��static
	//����������ʱ���ʼ��

	public abstract void zhouChang();

	void aa();//�Խӿ���ĳ��󷽷�Ĭ�����public abstract
	
	
	//�Խӿ�����Զ��巽�� ������default��static����
	default void bb() {
	}
	static void cc() {
		
	}
}
