package com.woniu.objectstream.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class ObjectIOoutStream {
	public void objectInputStream(File file) {// ������
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(file));// ����������
			/*
			 * �ڶ��ַ�ʽ������
			 */
			Person pp = (Person) ois.readObject();
			while (pp != null) {

				System.out.println(pp);
				pp = (Person) ois.readObject();
			}
			/*
			 *��һ�ַ�ʽ�� �ö����������ʽ���������еĶ���
			 */

//			Person[] p = (Person[]) ois.readObject();// �Ѷ����Ķ�������ŵ�����������
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
				ois.close();// �رն�����
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// д����
	public void objectOutputStream(File file) {
		ObjectOutputStream oos = null;// ����
		try {
			oos = new java.io.ObjectOutputStream(new FileOutputStream(file));// ����������
			/*
			 * �ڶ��ַ�ʽ���ñ���   ע�����Ҫ����Ϊ�����жϵ�null
			 */
			Person p = new Person("С����", 1);// ��������
			oos.writeObject(p);// д���һ��
			oos.writeObject(new Person("aha", 2));// д��ڶ���
			oos.writeObject(null);// ��Ϊ�����ж�
			/*
			 * ��ʽһ���ö�������
			 */
//			Person[] p = new Person[3];
//			p[0] = new Person("С����", 1);
//			p[1] = new Person("С����2", 2);
//			p[2] = new Person("С����3", 3);
//			oos.writeObject(p);// ���������ͨ�������д��������
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();// �رն�����
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
