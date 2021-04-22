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
 * ��дһ������
 * ��ָ��Ŀ¼�µ����еĴ�.java�ļ�����������һ��Ŀ¼�У�
 * �����ɹ��󣬰Ѻ�׺����.java�ĸĳ�.txt��
 * ����������ָ��Ŀ¼---->�ж���.java�����������----->����һĿ¼��д��------>���ĺ�׺
 */
public class Copy {
	//����.java�ļ�
	public void find(File file1, File file2) throws IOException {
		File[] files = file1.listFiles();// �����Ƶ��ļ���

		if (files == null || files.length <= 0) {
			return;
		}
		for (File i : files) {
			if (i.isDirectory()) {// ������ļ��У�������ٴηֽ�
				find(i, file2);
			} else {
				if (i.getName().endsWith(".java")) {// �������.java��β
					File file3 = new File(i.getPath());// �����Ƶ��ļ�
					File fileDest = new File(file2, file3.getName());// Ҫ������ļ�
					fileDest.createNewFile();
					copy(file3, fileDest);
					rename(fileDest);// �����ļ���
				}
			}
		}

	}
//����
	public void copy(File file3, File fileDest) throws IOException {

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			// ����������
			bis = new BufferedInputStream(new FileInputStream(file3));
			// ���������
			bos = new BufferedOutputStream(new FileOutputStream(fileDest));
			byte[] b = new byte[(int) file3.length()];
			bis.read(b);// �������
			bos.write(b);// �������

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			bos.close();// �ر���
			bis.close();
		}
	}

	public void rename(File fileDest) {
		String sb = fileDest.getName();// ��������
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
