package com.woniu.file.basic;

import java.io.File;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) {
		File file = new File("d:/TestFile/ee.txt");
		try {
			file.createNewFile();//因为调用creatNewFile（）的时候会让处理异常，所以要写try。。
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
