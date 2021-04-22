package com.woniu.io.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;

import javax.imageio.stream.FileImageInputStream;

/*
 * 编写一个程序，
 * 把指定目录下的所有的带.java文件都拷贝到另一个目录中，
 * 拷贝成功后，把后缀名是.java的改成.txt。
 * 分析：遍历指定目录---->判断是.java则放入输入流----->到另一目录中写入------>更改后缀
 */
public class Copy {
	//查找.java文件
	public void find(File file1, File file2) throws IOException {
		File[] files = file1.listFiles();// 待复制的文件夹

		if (files == null || files.length <= 0) {
			return;
		}
		for (File i : files) {
			if (i.isDirectory()) {// 如果是文件夹，则进入再次分解
				find(i, file2);
			} else {
				if (i.getName().endsWith(".java")) {// 如果是以.java结尾
					File file3 = new File(i.getPath());// 被复制的文件
					File fileDest = new File(file2, file3.getName());// 要放入的文件
					fileDest.createNewFile();
					copy(file3, fileDest);
					rename(fileDest);// 更改文件名
				}
			}
		}

	}
//复制
	public void copy(File file3, File fileDest) throws IOException {

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			// 缓存输入流
			bis = new BufferedInputStream(new FileInputStream(file3));
			// 缓存输出流
			bos = new BufferedOutputStream(new FileOutputStream(fileDest));
			byte[] b = new byte[(int) file3.length()];
			bis.read(b);// 输入程序
			bos.write(b);// 输出程序

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			bos.close();// 关闭流
			bis.close();
		}
	}

	public void rename(File fileDest) {
		String sb = fileDest.getName();// 更改名称
		String ssb = sb.replace(".java", ".txt");
		File file2 = new File("D:/TestFile1/Copy1/");
		boolean r = fileDest.renameTo(new File(file2, ssb));
		System.out.println(r);
	}

	public static void main(String[] args) throws IOException {
		Copy c = new Copy();

		c.find(new File("D:/eclipse-demo/LearnTry/"), new File("D:/TestFile1/Copy1/"));

	}

}
