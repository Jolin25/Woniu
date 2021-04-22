package com.woniuxy.collection.basic;

import java.util.*;
/*
 * Collection的所有子类都可以直接使用这些方法
 */
public class CollectionLearn {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		System.out.println("集合是不是空的："+c.isEmpty()+"集合的长度："+c.size());
		c.add("你好");
		c.add(3.14);
		c.add(new Object());
		//集合的长度为3，因为添加了三个元素
		System.out.println("集合是不是空的："+c.isEmpty()+"集合的长度："+c.size());
		c.remove(3.14);//删掉一个元素3.14
		System.out.println("集合是不是空的："+c.isEmpty()+"集合的长度："+c.size());
		//迭代器:用于遍历集合中有哪些元素，并且把元素依次的取出来
		Iterator it = c.iterator();
		while(it.hasNext()) {
			Object o = it.next();
			System.out.println(o);
		}
	}
}
