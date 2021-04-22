package com.woniuxy.collection.dog;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DogUtil {
	/*
	 * 第二种添加狗的方式：用静态变量处理
	 */
	// 构造dogs集合
	ArrayList<Dog> dogs = new ArrayList<Dog>();

	// 创建狗集合
	public void initial() {// 有静态变量后，则无需返回狗集合

		// 初始化集合
		Dog dog = new Dog("小白", "萨摩耶", "白色", 12);
		// 添加第一只
		dogs.add(dog);// 把dog添加到dogs集合中
		// 添加第二中
		dog = new Dog("小狗屎", "中华田园犬", "黄色", 1);
		dogs.add(dog);
		// 添加第三只
		dog = new Dog("momoko", "比熊", "白色", 1);
		dogs.add(dog);
		// 添加第四只
		dog = new Dog("子寤", "边牧", "黑白", 2);
		dogs.add(dog);
		// return dogs;
	}

	// 查找狗
	public void findDog() {// 有静态变量狗集合后，则无需传集合进来
		System.out.println("请输入狗的名字：");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		// 遍历
		boolean hasDog = false;
		Iterator<Dog> it = dogs.iterator();
		while (it.hasNext()) {
			Dog dog = it.next();// 避免下面多次用it.next()导致错位
			if (name.equals(dog.getName())) {
				System.out.println("狗的信息为：");
				dog.show();
				hasDog = true;
			}
		}
		if (!hasDog) {
			System.out.println("查无此狗");
		}
	}

	// 显示四条狗的信息
	public void showAllDogs() {// 有静态变量狗集合后，则无需传集合进来
		System.out.println("所有狗的信息：");
		Iterator<Dog> it = dogs.iterator();
		while (it.hasNext()) {
			it.next().show();
		}
	}
	/*
	 * 第一种添加狗的方式：把集合传进去，再返回 
	 */
	//添加三条狗
	public void addDogs() {// 有静态变量狗集合后，则无需传集合进来，也无需返回值
		
		Dog dog = new Dog("小呆", "哈士奇", "白色", 2); // 添加第一只
		dogs.add(dog);// 把dog添加到dogs集合中
		// 添加第二中
		dog = new Dog("阿呆", "蝴蝶犬", "白色", 1);
		dogs.add(dog);
		// 添加第三只
		dog = new Dog("Nikita", "金毛", "黄色", 2);
		dogs.add(dog);
		//return dogs;

	}

}
