package com.woniuxy.map.basic;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class LinkedHashMapDemo {
	//���Ԫ��
	public LinkedHashMap<Integer, String> add(){
		LinkedHashMap<Integer, String> lhm = new LinkedHashMap<Integer, String>();
		lhm.put(0, "һһ");
		lhm.put(1, "��");
		lhm.put(1, "��");//�����˼�ֵΪ1��ֵ
		lhm.put(2, "һһ");//����ֵ�ظ�
		lhm.put(null, null);//���Լ���ֵ��Ϊnull
		lhm.put(null, "��");//���Լ�Ϊnull
		lhm.put(null, "��");//���Ǽ�ֵΪnull��ֵ
		lhm.put(3, null);//����ֵΪnull
		lhm.put(3, null);//���Ǽ�ֵΪnull��ֵ
		lhm.put(4, null);
		return lhm;
		
	}
	//��ȡԪ��
	public void get(LinkedHashMap<Integer, String>lhm) {
		Set<Integer> set = lhm.keySet();
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			Integer key = it.next();
			System.out.println(key + "-------"+lhm.get(key));
		}
	}
	public static void main(String[] args) {
		LinkedHashMapDemo demo = new LinkedHashMapDemo();
		LinkedHashMap<Integer, String> lhm = demo.add();
		demo.get(lhm);
	}
}
