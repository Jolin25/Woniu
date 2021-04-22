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
		System.exit(0);// 非0的状态码表示异常终止，0也可以终止
	}

	public static void systemPropertyTest() {
		//System.getProperties().list(System.out);// 罗列系统属性
		System.out.println(System.getProperty("os.version"));
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("os.name"));

	}

	public static void gcTest() {
		Person p = new Person("王小明");
		System.out.println(p.name);
		p = null;/*
					 * 因为gc需要要回收的对象已经断开了连接了(即没有引用关系)， 才会去回收
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
		// 开始时距离19700101的毫秒值
		long start = System.currentTimeMillis();
		//一段程序
		for (int i = 0; i < 100000; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.println(i);
			}
		}
		// 结束时距离19700101的毫秒值
		long end = System.currentTimeMillis();
		long useTime = end - start;//差值为运行时间
		System.out.println(useTime);
	}
}
