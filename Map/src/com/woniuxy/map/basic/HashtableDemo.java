package com.woniuxy.map.basic;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/*
 * ��дһ�����򣬴���һ�� Hashtable����
 * ���ڴ洢���д����� ��Ϣ(���д�������Ҫ��Ϣ�д�����ID�����������)��
 * ���⣬���㲢��ʾ����ĳ�������ĵ�ǰ��
 */
public class HashtableDemo {
	public static void main(String[] args) {
		Hashtable<Integer, String[]> ht = new Hashtable<Integer, String[]>();
		String[] one = new String[3];
		one[0] = "001";
		one[1] = "��һ";
		one[2] = "1000";
		ht.put(0, one);
		one = new String[3];
		one[0] = "002";
		one[1] = "�Ŷ�";
		one[2] = "2000";
		ht.put(1, one);
		one = new String[3];
		one[0] = "003";
		one[1] = "����";
		one[2] = "3000";
		ht.put(2, one);
		Set<Integer> set = ht.keySet();// ȡ������Ԫ��
		Scanner sc = new Scanner(System.in);
		System.out.println("������Ҫ���ҵ������˻���");
		String str = sc.next();
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			
		}
	}
}
