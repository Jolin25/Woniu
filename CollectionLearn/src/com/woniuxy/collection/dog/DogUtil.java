package com.woniuxy.collection.dog;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DogUtil {
	/*
	 * �ڶ�����ӹ��ķ�ʽ���þ�̬��������
	 */
	// ����dogs����
	ArrayList<Dog> dogs = new ArrayList<Dog>();

	// ����������
	public void initial() {// �о�̬�����������践�ع�����

		// ��ʼ������
		Dog dog = new Dog("С��", "��ĦҮ", "��ɫ", 12);
		// ��ӵ�һֻ
		dogs.add(dog);// ��dog��ӵ�dogs������
		// ��ӵڶ���
		dog = new Dog("С��ʺ", "�л���԰Ȯ", "��ɫ", 1);
		dogs.add(dog);
		// ��ӵ���ֻ
		dog = new Dog("momoko", "����", "��ɫ", 1);
		dogs.add(dog);
		// ��ӵ���ֻ
		dog = new Dog("���", "����", "�ڰ�", 2);
		dogs.add(dog);
		// return dogs;
	}

	// ���ҹ�
	public void findDog() {// �о�̬���������Ϻ������贫���Ͻ���
		System.out.println("�����빷�����֣�");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		// ����
		boolean hasDog = false;
		Iterator<Dog> it = dogs.iterator();
		while (it.hasNext()) {
			Dog dog = it.next();// ������������it.next()���´�λ
			if (name.equals(dog.getName())) {
				System.out.println("������ϢΪ��");
				dog.show();
				hasDog = true;
			}
		}
		if (!hasDog) {
			System.out.println("���޴˹�");
		}
	}

	// ��ʾ����������Ϣ
	public void showAllDogs() {// �о�̬���������Ϻ������贫���Ͻ���
		System.out.println("���й�����Ϣ��");
		Iterator<Dog> it = dogs.iterator();
		while (it.hasNext()) {
			it.next().show();
		}
	}
	/*
	 * ��һ����ӹ��ķ�ʽ���Ѽ��ϴ���ȥ���ٷ��� 
	 */
	//���������
	public void addDogs() {// �о�̬���������Ϻ������贫���Ͻ�����Ҳ���践��ֵ
		
		Dog dog = new Dog("С��", "��ʿ��", "��ɫ", 2); // ��ӵ�һֻ
		dogs.add(dog);// ��dog��ӵ�dogs������
		// ��ӵڶ���
		dog = new Dog("����", "����Ȯ", "��ɫ", 1);
		dogs.add(dog);
		// ��ӵ���ֻ
		dog = new Dog("Nikita", "��ë", "��ɫ", 2);
		dogs.add(dog);
		//return dogs;

	}

}
