package com.woniu.inputstream.basic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutPutStreamDemo {

	// 写数据到磁盘文件中
	public void writeMessage(File file) throws IOException {
		OutputStream os = null;
		
		try {
			os = new FileOutputStream(file);
			try {
				os.write("123".getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			os.close();
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("d:/TestFile/ee.txt");
		FileOutputStream fo = new FileOutputStream(file);
	}
}
