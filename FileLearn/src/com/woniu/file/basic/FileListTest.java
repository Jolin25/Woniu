package com.woniu.file.basic;

import java.io.File;

public class FileListTest {
	//��ʾ������������ļ�
	public void showAllFile(File path) {
		//����listFile�ĵ��ô�������ļ������ļ���
		File[] files =path.listFiles();
		/*
		 * ����c��ϵͳ����˵����Щ���ص�Ŀ¼��
		 * listFiles������û��Ȩ�޷��ʵģ������Ҫ�ڳ����жԻ�ȡ�������ļ�����Ϊ���жϣ�
		 * 			���ص��ļ��ڳ���������null����ʾ��
		 */
		if(files == null || files.length<=0) {
			return;	
		}//��Ϊ�ݹ��ˡ��������Կ����жϵ������ÿһ���ļ���
		//��������
		for(File file:files) {
			//�ж��Ƿ���Ŀ¼
			if(file.isDirectory()) {
				//�����Ŀ¼�����������
				showAllFile(file);
			}else {
				System.out.println(file.getPath());
			}
		}
	}
	public static void main(String[] args) {
		File path = new File("c:");
		FileListTest f = new FileListTest();
		f.showAllFile(path);
	}
}
