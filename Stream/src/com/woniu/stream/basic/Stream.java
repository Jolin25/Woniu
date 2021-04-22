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
			boolean i = file.createNewFile();// 创建word.txt文件
			System.out.println(i);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		FileOutputStream out = null;
		try {
			// 创建输出流
			/*
			 * 把file放到out这么一个数据缓存区；如果在后面加了true，则为在文件末尾追加内容； 如果是false，则为替换内容
			 */
			out = new FileOutputStream(file, false);
			// 向file引用的文件添加内容
			String str = "你好啊，momoko";
			byte[] b = str.getBytes();// 把字符串转化为字节数组
			out.write(b);// 把字节数组写入到文件中
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
		 * 输入流，输入程序的流
		*/
		FileInputStream in = null;
		try {
			in = new FileInputStream(file);// 输入文件流
			byte b2[] = new byte[1024];//缓冲区
			int len = in.read(b2);//把读到的东西放到b2中
			System.out.println("文件中的数据是："+ new String(b2,0,len));//自动将字节数组转化为String
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
