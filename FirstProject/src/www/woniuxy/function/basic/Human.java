package www.woniuxy.function.basic;
/*
 * 
 * ����
 * 
 */
public class Human {
	//����
	public String name;
	public int age;
	// public int weight;
	public char sex;
	//��Ϊ
	public void eat() {
		System.out.print("���ڳԶ�����");
	}
	public void walk() {
		System.out.print("������·��");
	}
	public void os() {
		System.out.print("���ﻹ�кö������������࣬��Ү���������ҡ��� ��Ҫ�ؼҡ���\n");
	}
	public void showMe() {
		//walk();
		
		System.out.print("�ҽ�"+name+",�Ա�"+sex+",����" + age+"�ꡣ\n");
		//os();
	}
	//���캯��
	public Human(String name,int age,char sex) {
		this.name = name;//this.nameΪ��Ա����
		this.age = age;
		this.sex = sex;
	}
	
	
}

