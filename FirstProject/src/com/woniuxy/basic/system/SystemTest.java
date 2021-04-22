package com.woniuxy.basic.system;

import java.util.Arrays;

public class SystemTest {
	public static void main(String[] args) {
		// arrayCopyTest();
		//currentTimeMillisTest();
		// systemExitTest();
		// gcTest();
		systemPropertyTest();

	}

	public static void systemExitTest() {
		System.exit(0);// ��0��״̬���ʾ�쳣��ֹ��0Ҳ������ֹ
	}

	public static void systemPropertyTest() {
		//System.getProperties().list(System.out);// ����ϵͳ����
		System.out.println(System.getProperty("os.version"));
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("os.name"));

	}

	public static void gcTest() {
		Person p = new Person("��С��");
		System.out.println(p.name);
		p = null;/*
					 * ��Ϊgc��ҪҪ���յĶ����Ѿ��Ͽ���������(��û�����ù�ϵ)�� �Ż�ȥ����
					 */
		System.gc();
		System.out.println(p);
	}

	public static void arrayCopyTest() {
		int[] i1 = { 0, 1, 2, 3, 4, 5, 6 };
		int[] i2 = { 9, 9, 9, 9, 9, 9, 9 };
		System.arraycopy(i1, 2, i2, 3, 2);
		System.out.println(Arrays.toString(i2));
	}

	public static void currentTimeMillisTest() {
		// ��ʼʱ����19700101�ĺ���ֵ
		long start = System.currentTimeMillis();
		//һ�γ���
		for (int i = 0; i < 100000; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.println(i);
			}
		}
		// ����ʱ����19700101�ĺ���ֵ
		long end = System.currentTimeMillis();
		long useTime = end - start;//��ֵΪ����ʱ��
		System.out.println(useTime);
	}
}
