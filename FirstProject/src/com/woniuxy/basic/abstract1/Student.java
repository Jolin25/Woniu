package com.woniuxy.basic.abstract1;
/*
 * 1������һ���˵���(���������֣����䡣дһ����������Ը��� ��ֵ�ķ���showInfo())��
 * ����һ��ѧ����(�������Ա�)��ѧ���� �����ࡣ
Ҫ��
1����������Ը�ֵ�ù��췽����ʵ�֣�
2������ ������Ҳ�ù��췽������ֵ��
3������������д�����showInfo() ������
4������ѧ����Ķ��󣬵���ѧ������ʾ��Ϣ�ķ�����
 */
public class Student extends Person {
	
	char sex;
	//������
	public Student(String name, int age,char sex) {
		super(name, age);
		this.sex = sex;
		
	}
	//��д
	@Override
	public void showInfo() {
		System.out.println("������"+name+"�����䣺"+age+"���Ա�"+sex);
	}

}
