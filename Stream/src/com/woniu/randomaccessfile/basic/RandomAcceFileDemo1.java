package com.woniu.randomaccessfile.basic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAcceFileDemo1 {
	public void randomAcceseFile() throws IOException {
		File file = new File("test.txt");
		RandomAccessFile raf = null;
		try {
			 raf = new RandomAccessFile(file, "rw");//����RandomAccessFile����
			 byte [] b = new byte[(int) file.length()];
			 raf.read(b);
			 raf.write(b);
			 System.out.println(new String(b));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			raf.close();//�ر���
		}
	}
	public static void main(String[] args) throws IOException {
		new RandomAcceFileDemo1().randomAcceseFile();
	}
}
