package com.woniuxy.set.basic;

import java.util.Iterator;
import java.util.TreeSet;

public  class SetDemo implements Comparable<Object>{//ʵ��Comparable�ӿ�
	String name;
	long id;
	
	public SetDemo(String name, long id) {
		super();
		this.name = name;
		this.id = id;
	}
	//��дcompareTo����
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
		SetDemo sd1 = new SetDemo("��һ", 001);
		SetDemo sd2 = new SetDemo("�Ŷ�", 002);
		SetDemo sd3 = new SetDemo("����", 003);
		SetDemo sd4 = new SetDemo("����", 004);
		//TreeSetֻ�ܴ���Ѿ���ʵ��Comparable�ӿڣ��Լ���д��compareTo����������Ԫ�أ�
		TreeSet<SetDemo> ts= new TreeSet<SetDemo>();
		ts.add(sd1);
		ts.add(sd2);
		ts.add(sd3);
		ts.add(sd4);
		Iterator<SetDemo> it = ts.iterator();
		//��������
		System.out.println("Set�����е�����Ԫ�أ�");
		while(it.hasNext()) {
			SetDemo sd = it.next();
			System.out.println(sd.name+"----"+sd.id);
		}
		//��ȡ����sd2֮ǰ�Ķ���
		it = ts.headSet(sd2).iterator();
		System.out.println("Set������sd2ǰ�������Ԫ�أ�");
		while(it.hasNext()) {
			SetDemo sd = it.next();
			System.out.println(sd.name+"----"+sd.id);
		}
		//��ȡ����sd2��sd3֮��Ķ���
		it = ts.subSet(sd2, sd3).iterator();//������ͷ��������β
		System.out.println("Set������sd2��sd3֮�������Ԫ�أ�");
		while(it.hasNext()) {
			SetDemo sd = it.next();
			System.out.println(sd.name+"----"+sd.id);
		}
		
	}
}
