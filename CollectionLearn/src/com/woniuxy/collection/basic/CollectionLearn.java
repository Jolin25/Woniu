package com.woniuxy.collection.basic;

import java.util.*;
/*
 * Collection���������඼����ֱ��ʹ����Щ����
 */
public class CollectionLearn {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		System.out.println("�����ǲ��ǿյģ�"+c.isEmpty()+"���ϵĳ��ȣ�"+c.size());
		c.add("���");
		c.add(3.14);
		c.add(new Object());
		//���ϵĳ���Ϊ3����Ϊ���������Ԫ��
		System.out.println("�����ǲ��ǿյģ�"+c.isEmpty()+"���ϵĳ��ȣ�"+c.size());
		c.remove(3.14);//ɾ��һ��Ԫ��3.14
		System.out.println("�����ǲ��ǿյģ�"+c.isEmpty()+"���ϵĳ��ȣ�"+c.size());
		//������:���ڱ�������������ЩԪ�أ����Ұ�Ԫ�����ε�ȡ����
		Iterator it = c.iterator();
		while(it.hasNext()) {
			Object o = it.next();
			System.out.println(o);
		}
	}
}
