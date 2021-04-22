package com.woniu.stream.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Stream {
	public static void main(String[] args) {

		File file = new File("word.txt");
		try {
			boolean i = file.createNewFile();// ����word.txt�ļ�
			System.out.println(i);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		FileOutputStream out = null;
		try {
			// ���������
			/*
			 * ��file�ŵ�out��ôһ�����ݻ�����������ں������true����Ϊ���ļ�ĩβ׷�����ݣ� �����false����Ϊ�滻����
			 */
			out = new FileOutputStream(file, false);
			// ��file���õ��ļ��������
			String str = "��ð���momoko";
			byte[] b = str.getBytes();// ���ַ���ת��Ϊ�ֽ�����
			out.write(b);// ���ֽ�����д�뵽�ļ���
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		/*
		 * ������������������
		*/
		FileInputStream in = null;
		try {
			in = new FileInputStream(file);// �����ļ���
			byte b2[] = new byte[1024];//������
			int len = in.read(b2);//�Ѷ����Ķ����ŵ�b2��
			System.out.println("�ļ��е������ǣ�"+ new String(b2,0,len));//�Զ����ֽ�����ת��ΪString
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (file != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
