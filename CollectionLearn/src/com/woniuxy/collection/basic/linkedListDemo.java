package com.woniuxy.collection.basic;

import java.util.Iterator;
import java.util.LinkedList;

public class linkedListDemo {
	public static void main(String[] args) {
		LinkedList<String> ll = new LinkedList<String>();
		ll.add("I");
		ll.add("am");
		ll.add("dog");
		ll.add("tired");
		ll.addFirst("...blabla:");
		ll.addLast("...");
		int i = ll.indexOf("dog");
		ll.add(i+1, "-");
		//±éÀú
		Iterator it = ll.iterator();
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
		
	}
}
