package com.woniuxy.clone.basic;

public class Test {
	public static void main(String[] args) throws CloneNotSupportedException {
		/*
		 * ǳ���¡����Bookû��ʵ�ֽӿ�cloneable����дclone
		 * �Լ�Person��дcloneʱû���ر��Book����Ŀ�¡���󱣴���Person������ʱ
		 */

		Book book = new Book("ĸ�����", 20);
		Person p1 = new Person("��һ", 17, book);
		Person p2 = (Person) p1.clone();// p1,p2 �ĵ�ַ�ǲ�ͬ�ģ������������ĸ���
		System.out.println(p2.book.getName());
		p2.book.setName("����Ķ�һ����");// ǳ��¡��book����ĵ�ַp1��p2�ǹ��õ�
		p2.setAge(19);
		p2.setName("�Ŷ�");
		p2.book.setPrice(30);// ǳ��¡��book����ĵ�ַp1��p2�ǹ��õ�
		System.out.println(p2);
		System.out.println(p1);
		// Book ��û��дtoString ����ӡ��book����ĵ�ַ��Ϊͬһ����
		// ��ΪBook���Զ����࣬û��ʵ�ֽӿ�cloneable
		System.out.println(p1.book);
		System.out.println(p2.book);
		/*
		 * ����¡
		 */

	}

}
