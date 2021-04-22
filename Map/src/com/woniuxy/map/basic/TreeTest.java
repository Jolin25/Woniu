package com.woniuxy.map.basic;

import java.util.Map.Entry;
import java.util.TreeMap;

public class TreeTest {
	public static void main(String[] args) {
		TreeMapDemo tmd = new TreeMapDemo();
		TreeMap<Integer, String> tm = tmd.add();
		tmd.get(tm);
		System.out.println("-------------");
		tm.remove(1);
		tmd.get(tm);
		System.out.println("--------------");
		Integer f = tm.firstKey();
		System.out.println(f);
		System.out.println("--------------");
		Entry<Integer, String> ef = tm.firstEntry();
		
	}
}
