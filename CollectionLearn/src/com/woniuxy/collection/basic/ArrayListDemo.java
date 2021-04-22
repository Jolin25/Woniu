package com.woniuxy.collection.basic;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();//声明时确定泛型为String
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
		//遍历
		//for循环
		for(int i = 0; i < al.size();i++) {
			System.out.println(al.get(i));
		}
		//foreach
		for(String i:al) {
			System.out.println(i);
		}
		//迭代器Iterator
		Iterator it = al.iterator();//调用父类（collection）的方法，返回迭代器接口对象
		while(it.hasNext()) {//当迭代器中有下一个元素时
			System.out.println(it.next());//输出下一个元素
		}
		System.out.println(al.indexOf("hello"));
	}
}
