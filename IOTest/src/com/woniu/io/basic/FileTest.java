package com.woniu.io.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*
 *  ��D���´����ļ��У�����ʱ������ļ����Ƿ���ڣ������������ʾ��д���룻
 *   ����������򴴽��������ú��ٴ����ļ���
 *  Ȼ��Ӽ����������������ݣ���TOM:89|JERRY:90|TONY:95����
 *  ���ݸ�ʽΪ���������ɼ�|�������ɼ�|�������ɼ�����
 *  �Գɼ�����С�����˳�����򱣴����ļ��У�
 *  ������File�����ļ��� Student----->�ٴ����ļ�student1.txt------>
 */
public class FileTest {
	public void creatFile() throws IOException {
		File folder = new File("d:/TestFile1/TestFile2/TestFile3/TestFile4");
		if (folder.exists()) {
			System.out.println("�Ѵ���");
		} else {
			boolean f = folder.mkdir();// �����ļ���
			System.out.println(f);
			File file = new File(folder, "student.txt");
			file.createNewFile();// �����ļ�
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("������ѧ����Ϣ��");
		String student = sc.next();
		String[] sd1 = student.split("\\|");// ���ѧ��3
		String[] sd11 = sd1[0].split("\\:");// ���ѧ����Ϣ2
		String[] sd12 = sd1[1].split("\\:");// ��Ҫת���ַ��Ĺ�
		String[] sd13 = sd1[2].split("\\:");

		// ����
		int a = Integer.valueOf(sd11[1]);
		int b = Integer.valueOf(sd12[1]);
		int c = Integer.valueOf(sd13[1]);

		if (a > b) {
//			int t = a;
//			a = b;
//			b = t;
			String t = sd11[0];
			sd11[0] = sd12[0];
			sd12[0] = t;
			String name = sd11[1];
			sd11[1] = sd12[1];
			sd12[1] = name;

		} else if (b > c) {
//			int t = b;
//			b = c;
//			c = t;
			String t = sd12[0];
			sd12[0] = sd13[0];
			sd13[0] = t;
			String name = sd12[1];
			sd12[1] = sd13[1];
			sd13[1] = name;
		} else if (c < a) {
//			int t = a;
//			a = c;
//			c = t;
			String t = sd11[0];
			sd11[0] = sd13[0];
			sd13[0] = t;
			String name = sd11[1];
			sd11[1] = sd13[1];
			sd13[1] = name;
		}
		// System.out.println(Arrays.toString(sd11)+Arrays.toString(sd12)+Arrays.toString(sd13));
		// ���컺�������
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(folder, "student.txt")));
		byte[] b1 = new byte[1024];
		b1 = sd11[0].getBytes();
		bos.write(b1);
		bos.flush();
		b1 = sd11[1].getBytes();
		bos.write(b1);
		bos.flush();
		b1 = sd12[0].getBytes();
		bos.write(b1);
		bos.flush();
		b1 = sd12[1].getBytes();
		bos.write(b1);
		bos.flush();
		b1 = sd13[0].getBytes();
		bos.write(b1);
		bos.flush();
		b1 = sd13[1].getBytes();
		bos.write(b1);
		bos.flush();
		bos.close();// �رջ��������
	}

	public static void main(String[] args) throws IOException {
		new FileTest().creatFile();
	}
}
