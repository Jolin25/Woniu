package com.woniu.stream.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * ��c���µ�ĳ��ͼƬ������d���У�1.����C��ĳ���ļ��µ�ͼƬ 2.���������� 3.��������� 4.ͨ��������ŵ�d�̵�ĳ��λ��
 */
public class Copy {
	public static void main(String[] args) {
		File file1 = new File("c:/Ҫ������ͼƬ�ļ���/ͼƬ.jpg");
		File file2 = new File("d:/TestFile1/4.jpg");
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			fis = new FileInputStream(file1);// ����������
			bis = new BufferedInputStream(fis);// ����������װ����������
			try {
				fos = new FileOutputStream(file2);// �����
				bos = new BufferedOutputStream(fos);// ���������װ����������
				/*
				 * ��ʽһ��
				 * ��һ����дһ��
				 */
//				int number = bis.read();
//				while (number != -1) {
//					bos.write(number);// ��һ����дһ��
//
//					number = bis.read();
//					bos.flush();// ˢ�����������
//				}
				/*
				 * ��ʽ����
				 * ȫ�浽�ֽ���������д
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
				if(bos != null) {//�رջ��������
					try {
						bos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (fos != null) {//�ر��ֽ������
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
			if(bis != null) {//�رջ���������
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fis != null) {//�ر��ֽ�������
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
