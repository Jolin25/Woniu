package com.woniu.inputstream.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest {
	public static void main(String[] args) throws IOException {
		// ��d���µ�ee�ļ���ȡ��������
		// �����ļ�����
		File file = new File("d:/TestFile/ee.txt");
		//�Ѵ����õ��ļ�����װ���������
		FileInputStream fs = new FileInputStream(file);
		//��ȡ���е�����
		//int i = fs.read();
		//System.out.println(i);
		/*��ʽһ��
		 * �Ѵ����ж�ȡ����������װ���ֽ������У�
		 * 1.�����ֽ�����
		 * 2.�ٰѶ�ȡ������װ�������� 
		 */
//		byte[]b = new byte[(int) file.length()];
//		fs.read(b);
//		System.out.println(new String(b));
		/*
		 * ��ʽ����
		 */
		int number = fs.read();
		while(number!=-1) {
			System.out.println((char)number);
			number = fs.read();
		}
		//�ر���
		fs.close();
	}
}
