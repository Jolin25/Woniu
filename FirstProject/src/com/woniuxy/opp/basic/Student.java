package com.woniuxy.opp.basic;



public class Student extends Person {

	int math;
	int english;

	// ����
	public Student(int math,int english) {
		
		this.english = english;
		this.math = math;
		System.out.println("Ӣ��ɼ�Ϊ��"+english+"��ѧ�ɼ�Ϊ��"+math);
	}
	// ����
	public Student(String name, String addr, char sex, int age, int math, int english) {
		super(name, addr, sex, age);//���ø���Ĺ��췽��
		
		this.math = math;
		this.english = english;
		System.out.println("������"+name+",��ַ��"+addr+",�Ա�"
		+sex+",���䣺"+age+"����ѧ�ɼ���"+math+"��Ӣ��ɼ���"+english);
	}

	// �޲�
	public Student() {
		
		
	}
	// ��д
	@Override
	public void show(){	
		
		System.out.print("��ѧ�ɼ���"+math+"��Ӣ��ɼ���"+english);
		super.show();//���ø����show����
	}
}
