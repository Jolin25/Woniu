package com.woniu.stream.basic;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/*
 * дʮ�����ݵ��ļ��У�1.�����ļ� 2.����� 
 */
public class SteamTest {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		File file = new File("test.txt");
		try {
			boolean i = file.createNewFile();//�����ļ�test.txt
			//System.out.println(i);
		} catch (IOException e) {
			e.printStackTrace();
		}
		FileOutputStream fos = null;//����Ϊȫ�ֱ����Ļ����쳣������û��ͳһ
		 BufferedOutputStream bos = null;
		try {
			 fos = new FileOutputStream(file,true);//fos�ֽ���
			 bos = new BufferedOutputStream(fos);//bos������
			 for(int i =0;i<10;i++) {
				 System.out.println("���������ݣ�");
				 String str = sc.next();
				byte[] b = str.getBytes();//���ַ���ת��Ϊ�ֽ�����
				try {
					bos.write(b);//д�뻺������
					//fos.write(b);//д���ļ���
					//���д���(����������ݿ����Զ�����)
					fos.write("\r\n".getBytes());
					bos.flush();//���������е�����ˢ�£��浽�ļ���
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
