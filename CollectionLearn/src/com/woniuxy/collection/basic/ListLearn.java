package com.woniuxy.collection.basic;

import java.util.ArrayList;
import java.util.List;

/*
 * List接口
 */
public class ListLearn {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("第一句");
		list.add("第二句");
		list.add("第三句");
		list.add("第四句");
		list.remove(1);//删除第二句
		list.set(2, "第四句被set了");
		list.add(null);//可以添加null元素
		for(int i=0;i<list.size();i++) {
			System.out.println("list的索引"+i+"的元素:"+list.get(i));
		}
	}
}
