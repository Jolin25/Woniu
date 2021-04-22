package com.woniuxy.regex.basic;
/*
 * 利用字符串来进行正则表达式的匹配
 */
public class Demo {
	public static void main(String[] args) {
		String str = "张三@@@李四@@王五@赵六";
		Demo demo = new Demo();
		System.out.println(demo.isName(str));
	}
	public boolean isName(String str) {
		String regex = "@+";
		String[] s = str.split(regex);
		boolean isTrue = false;
		if (s != null) {
			isTrue = true;
		}
		for (String i : s) {
			System.out.println(i);
		}
		return isTrue;
	}
}
