package com.woniuxy.string.basic;

/*
 * �ַ�������,����һ�ַ���,"����˹��#ɱ�����#��Ѱ�#����˹#",������ÿ��Ԫ��
 */
public class StringSplit {
	public static void main(String[] args) {
		String str = "����˹��#ɱ�����#��Ѱ�#����˹#";
		String[] str1 = str.split("#");
		for(String i : str1) {
			System.out.println(i);
		}
	}
}
