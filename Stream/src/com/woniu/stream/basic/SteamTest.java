package com.woniu.stream.basic;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/*
 * 写十行数据到文件中：1.创建文件 2.输出流 
 */
public class SteamTest {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		File file = new File("test.txt");
		try {
			boolean i = file.createNewFile();//创建文件test.txt
			//System.out.println(i);
		} catch (IOException e) {
			e.printStackTrace();
		}
		FileOutputStream fos = null;//不作为全局变量的话，异常处理部分没法统一
		 BufferedOutputStream bos = null;
		try {
			 fos = new FileOutputStream(file,true);//fos字节流
			 bos = new BufferedOutputStream(fos);//bos缓存流
			 for(int i =0;i<10;i++) {
				 System.out.println("请输入数据：");
				 String str = sc.next();
				byte[] b = str.getBytes();//把字符串转换为字节数组
				try {
					bos.write(b);//写入缓存流中
					//fos.write(b);//写进文件中
					//换行处理(让输入的内容可以自动换行)
					fos.write("\r\n".getBytes());
					bos.flush();//将缓存流中的数据刷新，存到文件中
				} catch (IOException e) {
					e.printStackTrace();
				}
			 }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos!=null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
}
