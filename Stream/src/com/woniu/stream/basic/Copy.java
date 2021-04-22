package com.woniu.stream.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 把c盘下的某张图片拷贝到d盘中；1.访问C盘某个文件下的图片 2.放入输入流 3.放入输出流 4.通过输出流放到d盘的某个位置
 */
public class Copy {
	public static void main(String[] args) {
		File file1 = new File("c:/要拷贝的图片文件夹/图片.jpg");
		File file2 = new File("d:/TestFile1/4.jpg");
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			fis = new FileInputStream(file1);// 放入输入流
			bis = new BufferedInputStream(fis);// 把输入流包装到缓存流中
			try {
				fos = new FileOutputStream(file2);// 输出流
				bos = new BufferedOutputStream(fos);// 把输出流包装到缓存流中
				/*
				 * 方式一：
				 * 读一个就写一个
				 */
//				int number = bis.read();
//				while (number != -1) {
//					bos.write(number);// 读一个，写一个
//
//					number = bis.read();
//					bos.flush();// 刷新输出缓存流
//				}
				/*
				 * 方式二：
				 * 全存到字节数组了再写
				 */
				byte[] b = new byte[(int) file1.length()];
				bis.read(b);
				bos.write(b);
				bos.flush();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if(bos != null) {//关闭缓存输出流
					try {
						bos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (fos != null) {//关闭字节输出流
					try {

						fos.close();

					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(bis != null) {//关闭缓存输入流
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fis != null) {//关闭字节输入流
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
