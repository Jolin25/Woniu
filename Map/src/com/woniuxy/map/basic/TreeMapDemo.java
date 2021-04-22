package com.woniuxy.map.basic;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo {
	//���Ԫ��
	public TreeMap<Integer, String> add() {
		TreeMap<Integer, String> tm = new TreeMap<Integer, String>();
		tm.put(1, "one");
		tm.put(2, "two");
		//tm.put(null, null);
		tm.put(2, "twotwo");
		//tm.put(null, "qq");
		tm.put(3, "null");
		return tm;
	}
	//��ȡԪ��
	public void get(TreeMap<Integer, String> tm) {
		Set<Integer> set =tm.keySet();
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			Integer key = it.next();
			System.out.println(key+"----------"+tm.get(key));
		}
	}
}
