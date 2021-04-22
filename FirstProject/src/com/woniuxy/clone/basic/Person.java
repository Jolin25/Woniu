package com.woniuxy.clone.basic;

public class Person implements Cloneable {
	private String name;
	private int age;
	Book book;

	// ����Book�Ķ���
	public Person(String name, int age, Book book) {
		this.name = name;
		this.age = age;
		this.book = book;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {

		return "������" + name + "�����䣺" + age + "���鼮���ƣ�" + book.getName() + "���鼮�۸�" + book.getPrice();
	}
	// ��дclone����Ϊԭ����native,�޷�����

	@Override
	protected Object clone() throws CloneNotSupportedException {
		/*
		 * ʵ�ְѿ�¡������Book���󱣴��ڿ�¡������Person������
		 */
		/*
		 * super.clone���� ��������ObjectҪ��¡�����ĸ�������---->
		 * super.clone()���ڶ��п���һ���µĿռ䣬Ȼ�󷵻���������ͣ�����ָ����Object����
		 * ����
		 * 
		 */

		Person person = (Person) super.clone();// �ȿ�¡Person�Ķ���
		Book book = (Book) person.getBook().clone();// ��ȡ��¡��person�Ŀ�¡����book
		person.setBook(book);// �ѿ�¡��Book���󱣴浽Person������
		return person;
	}
}
