package com.woniuxy.clone.basic;

public class Person implements Cloneable {
	private String name;
	private int age;
	Book book;

	// 加入Book的对象
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

		return "姓名：" + name + "，年龄：" + age + "，书籍名称：" + book.getName() + "，书籍价格：" + book.getPrice();
	}
	// 重写clone，因为原本是native,无法调用

	@Override
	protected Object clone() throws CloneNotSupportedException {
		/*
		 * 实现把克隆出来的Book对象保存在克隆出来的Person对象中
		 */
		/*
		 * super.clone（） 用来告诉Object要克隆的是哪个？？？---->
		 * super.clone()会在堆中开辟一个新的空间，然后返回子类的类型（这里指的是Object）给
		 * 引用
		 * 
		 */

		Person person = (Person) super.clone();// 先克隆Person的对象
		Book book = (Book) person.getBook().clone();// 获取克隆的person的克隆对象book
		person.setBook(book);// 把克隆的Book对象保存到Person对象中
		return person;
	}
}
