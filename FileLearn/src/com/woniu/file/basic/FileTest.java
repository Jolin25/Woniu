package com.woniu.file.basic;

import java.io.File;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) {
		File file = new File("d:/TestFile/ee.txt");
		try {
			file.createNewFile();//��Ϊ����creatNewFile������ʱ����ô����쳣������Ҫдtry����
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
