package com.woniuxy.regex.basic;
/*
 * �����ַ���������������ʽ��ƥ��
 */
public class Demo {
	public static void main(String[] args) {
		String str = "����@@@����@@����@����";
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
