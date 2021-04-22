package com.woniuxy.set.basic;

import java.util.Iterator;
import java.util.TreeSet;

public  class SetDemo implements Comparable<Object>{//实现Comparable接口
	String name;
	long id;
	
	public SetDemo(String name, long id) {
		super();
		this.name = name;
		this.id = id;
	}
	//重写compareTo方法
	@Override
	public int compareTo(Object o) {
		SetDemo sd = (SetDemo)o;
		int result = id>sd.id?1:(id==sd.id?0:-1);
		return result;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public static void main(String[] args) {
		SetDemo sd1 = new SetDemo("张一", 001);
		SetDemo sd2 = new SetDemo("张二", 002);
		SetDemo sd3 = new SetDemo("张三", 003);
		SetDemo sd4 = new SetDemo("张四", 004);
		//TreeSet只能存放已经被实现Comparable接口，以及重写了compareTo方法的类型元素；
		TreeSet<SetDemo> ts= new TreeSet<SetDemo>();
		ts.add(sd1);
		ts.add(sd2);
		ts.add(sd3);
		ts.add(sd4);
		Iterator<SetDemo> it = ts.iterator();
		//遍历集合
		System.out.println("Set集合中的所有元素：");
		while(it.hasNext()) {
			SetDemo sd = it.next();
			System.out.println(sd.name+"----"+sd.id);
		}
		//截取排在sd2之前的对象
		it = ts.headSet(sd2).iterator();
		System.out.println("Set集合中sd2前面的所有元素：");
		while(it.hasNext()) {
			SetDemo sd = it.next();
			System.out.println(sd.name+"----"+sd.id);
		}
		//截取排在sd2和sd3之间的对象
		it = ts.subSet(sd2, sd3).iterator();//包含了头，不包含尾
		System.out.println("Set集合中sd2与sd3之间的所有元素：");
		while(it.hasNext()) {
			SetDemo sd = it.next();
			System.out.println(sd.name+"----"+sd.id);
		}
		
	}
}
