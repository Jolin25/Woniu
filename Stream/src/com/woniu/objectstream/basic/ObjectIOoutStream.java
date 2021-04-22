package com.woniu.objectstream.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class ObjectIOoutStream {
	public void objectInputStream(File file) {// 读对象
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(file));// 创建对象流
			/*
			 * 第二种方式：遍历
			 */
			Person pp = (Person) ois.readObject();
			while (pp != null) {

				System.out.println(pp);
				pp = (Person) ois.readObject();
			}
			/*
			 *第一种方式： 用对象数组的形式读对象流中的对象
			 */

//			Person[] p = (Person[]) ois.readObject();// 把读到的对象数组放到对象数组中
//			for (Person i : p) {
//				System.out.println(i);
//			}
			// System.out.println(Arrays.toString(p));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();// 关闭对象流
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 写对象
	public void objectOutputStream(File file) {
		ObjectOutputStream oos = null;// 声明
		try {
			oos = new java.io.ObjectOutputStream(new FileOutputStream(file));// 创建对象流
			/*
			 * 第二种方式：用遍历   注意最后要有作为结束判断的null
			 */
			Person p = new Person("小呆货", 1);// 创建对象
			oos.writeObject(p);// 写入第一个
			oos.writeObject(new Person("aha", 2));// 写入第二个
			oos.writeObject(null);// 作为结束判断
			/*
			 * 方式一：用对象数组
			 */
//			Person[] p = new Person[3];
//			p[0] = new Person("小呆货", 1);
//			p[1] = new Person("小呆货2", 2);
//			p[2] = new Person("小呆货3", 3);
//			oos.writeObject(p);// 把数组对象通过输出流写到程序中
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();// 关闭对象流
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ObjectIOoutStream oios = new ObjectIOoutStream();
		oios.objectOutputStream(new File("test.txt"));
		oios.objectInputStream(new File("test.txt"));
	}
}
