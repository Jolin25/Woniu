package com.woniuxy.collection.basic;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();//����ʱȷ������ΪString
		al.add(0,"hello");
		al.add(1,"momoko");
		al.add(2,"!");
		al.add(3,null);
		String a0 = al.get(0);
		System.out.println(a0);
		//al.clear();
		boolean b = al.isEmpty();
		System.out.println(b);
		Object all = al.toArray();
		System.out.println("==================");
		//����
		//forѭ��
		for(int i = 0; i < al.size();i++) {
			System.out.println(al.get(i));
		}
		//foreach
		for(String i:al) {
			System.out.println(i);
		}
		//������Iterator
		Iterator it = al.iterator();//���ø��ࣨcollection���ķ��������ص������ӿڶ���
		while(it.hasNext()) {//��������������һ��Ԫ��ʱ
			System.out.println(it.next());//�����һ��Ԫ��
		}
		System.out.println(al.indexOf("hello"));
	}
}
