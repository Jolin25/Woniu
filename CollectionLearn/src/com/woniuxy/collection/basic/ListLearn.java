package com.woniuxy.collection.basic;

import java.util.ArrayList;
import java.util.List;

/*
 * List�ӿ�
 */
public class ListLearn {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("��һ��");
		list.add("�ڶ���");
		list.add("������");
		list.add("���ľ�");
		list.remove(1);//ɾ���ڶ���
		list.set(2, "���ľ䱻set��");
		list.add(null);//�������nullԪ��
		for(int i=0;i<list.size();i++) {
			System.out.println("list������"+i+"��Ԫ��:"+list.get(i));
		}
	}
}
