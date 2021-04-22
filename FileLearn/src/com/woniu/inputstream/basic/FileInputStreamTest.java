package com.woniu.inputstream.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest {
	public static void main(String[] args) throws IOException {
		// 将d盘下的ee文件读取到程序中
		// 创建文件对象
		File file = new File("d:/TestFile/ee.txt");
		//把创建好的文件对象装到输出流中
		FileInputStream fs = new FileInputStream(file);
		//读取流中的数据
		//int i = fs.read();
		//System.out.println(i);
		/*方式一：
		 * 把从流中读取出来的数据装到字节数组中：
		 * 1.创建字节数组
		 * 2.再把读取的数据装到数组中 
		 */
//		byte[]b = new byte[(int) file.length()];
//		fs.read(b);
//		System.out.println(new String(b));
		/*
		 * 方式二：
		 */
		int number = fs.read();
		while(number!=-1) {
			System.out.println((char)number);
			number = fs.read();
		}
		//关闭流
		fs.close();
	}
}
