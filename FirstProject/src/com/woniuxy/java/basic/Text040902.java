package com.woniuxy.java.basic;

public class Text040902 {
	public static void main(String[] args) {
		byte a = 1;
		a += 1;/* += �� ��� ��ߵı����Ǳ��ұ߼�������ͻ�С���������ͣ�
					��ô+=��Щ��������ʵ����ϵͳĬ�ϵ�����һ����ʽ��ǿ�����͵�ת����*/
		System.out.println(a);
		a = 1;
		a = (byte) (a + 1);
		System.out.println(a);
	}
}
