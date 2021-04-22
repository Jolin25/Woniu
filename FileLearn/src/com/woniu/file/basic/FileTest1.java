package com.woniu.file.basic;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest1 {
	public static void main(String[] args) {
		// ��һ�ֹ��췽��
		File file1 = new File("d:/TestFile1/ee1.txt");
		// �ڶ��ֹ��췽�� �� �ļ��е�·�����ַ���+�ļ����ַ���
		// d:/TestFile1/TestFile2/ ��󻹼���һ��б����Ϊ�˺���������һ���ļ���
		File file2 = new File("d:/TestFile1/TestFile2/" + "ee2.txt");
		// �����ֹ��췽����
		File dir = new File("d:/TestFile1/TestFile2/TestFile3/");// �ļ���
		File file3 = new File(dir, "ee3.txt");
		/*
		 * (����·��) ��Ŀ�µ�·����Ĭ��·������word.txt ���µ�·����src/com.woniu.file.basic/word.txt
		 */
		File file4 = new File("word.txt");
		File file5 = new File("src/com.woniu.file.basic/word.txt");

		/*
		 * ����ļ��ľ���·��
		 */
		System.out.println(file1.getAbsolutePath());
		System.out.println(file2.getAbsolutePath());
		System.out.println(file3.getAbsolutePath());
		System.out.println(file4.getAbsolutePath());
		System.out.println(file5.getAbsolutePath());
		/*
		 * �Ա�ָ��ͬһ���ļ�������File�����Ƿ����
		 */
		File file6 = new File("d:/TestFile1/ee1.txt");// ��File1 ָ����ͬһ���ļ�
		System.out.println(file1 == file6);// ��Ϊ����������ͬ�Ķ���
		System.out.println(file1.equals(file6));// ��Ϊ�����������������ͬ

		/*
		 * ʹ��:��ʾ״̬�����ԡ�����
		 */
		System.out.println("==============״̬������===============");
		System.out.println("�ļ��Ƿ���ڣ�" + file1.exists());
		System.out.println("�ļ���Ϊ��" + file1.getName());
		System.out.println("����·��Ϊ��" + file1.getAbsolutePath());
		System.out.println("�ļ���С��" + file1.length());// ����ļ���С����λ���ֽ���
		System.out.println("�Ƿ�Ϊ�����ļ���" + file1.isHidden());
		System.out.println("�ļ�����޸�ʱ�䣺" + file1.lastModified());// ����һ������1970�ĺ���ֵlong
		Date date1 = new Date(file1.lastModified());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:s ");// �����hh����Ϊ12Сʱ�Ƶ�
		String lastModifiedTime = sdf.format(date1);
		System.out.println(lastModifiedTime);// ������޸�ʱ���ʽ�����
		System.out.println("===========����===============");
		boolean del = file1.delete();
		System.out.println("ɾ���ļ��Ƿ�ɹ���" + del);
		try {
			// �Ѵ��ڵ��ļ����������´��������ܸ��������ļ���
			boolean create = file1.createNewFile();// �����µĿ��ļ�
			System.out.println("�����ļ��Ƿ�ɹ���" + create);
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
