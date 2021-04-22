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
 *  在D盘下创建文件夹，创建时看这个文件夹是否存在，如果存在则提示重写输入；
 *   如果不存在则创建，创建好后再创建文件，
 *  然后从键盘上输入以下数据：“TOM:89|JERRY:90|TONY:95”，
 *  数据格式为“姓名：成绩|姓名：成绩|姓名：成绩”，
 *  对成绩按从小到大的顺序排序保存在文件中；
 *  分析：File创建文件夹 Student----->再创建文件student1.txt------>
 */
public class FileTest {
	public void creatFile() throws IOException {
		File folder = new File("d:/TestFile1/TestFile2/TestFile3/TestFile4");
		if (folder.exists()) {
			System.out.println("已存在");
		} else {
			boolean f = folder.mkdir();// 创建文件夹
			System.out.println(f);
			File file = new File(folder, "student.txt");
			file.createNewFile();// 创建文件
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入学生信息：");
		String student = sc.next();
		String[] sd1 = student.split("\\|");// 拆分学生3
		String[] sd11 = sd1[0].split("\\:");// 拆分学生信息2
		String[] sd12 = sd1[1].split("\\:");// 需要转义字符的哈
		String[] sd13 = sd1[2].split("\\:");

		// 排序
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
		// 构造缓存输出流
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
		bos.close();// 关闭缓存输出流
	}

	public static void main(String[] args) throws IOException {
		new FileTest().creatFile();
	}
}
