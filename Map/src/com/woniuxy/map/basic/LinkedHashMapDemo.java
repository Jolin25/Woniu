package com.woniuxy.map.basic;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class LinkedHashMapDemo {
	//添加元素
	public LinkedHashMap<Integer, String> add(){
		LinkedHashMap<Integer, String> lhm = new LinkedHashMap<Integer, String>();
		lhm.put(0, "一一");
		lhm.put(1, "二");
		lhm.put(1, "三");//覆盖了键值为1的值
		lhm.put(2, "一一");//可以值重复
		lhm.put(null, null);//可以键和值都为null
		lhm.put(null, "四");//可以键为null
		lhm.put(null, "五");//覆盖键值为null的值
		lhm.put(3, null);//可以值为null
		lhm.put(3, null);//覆盖键值为null的值
		lhm.put(4, null);
		return lhm;
		
	}
	//读取元素
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
