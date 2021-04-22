package com.woniuxy.map.basic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesDemo {
	public void read() throws IOException {
		// �������ļ�װ����������
		// InputStream in =
		// PropertiesDemo.class.getClassLoader().getResourceAsStream("message2.properties");
		InputStream in = PropertiesDemo.class.getResourceAsStream("../../../../message2.properties");
		// ����properties����
		Properties p = new Properties();
		// ������
		p.load(in);
		// ��ȡ�����ļ��е�����
		String name = p.getProperty("name");
		String age = p.getProperty("age");
		String sex = p.getProperty("sex");
		String chinese = p.getProperty("Chinese");
		System.out.println(name + "---" + age + "---" + sex + "---" + chinese);
		// �ر���
		in.close();

	}
	//�������ļ���д��
	public void write() throws IOException {
		//�����������У��õ���Ӧ��������
		InputStream in = PropertiesDemo.class.getResourceAsStream("/message2.properties");
		//����properties����
		Properties p = new Properties();
		//���ü��ط���,��������
		p.load(in);
		//��properties����д����
		/*
		 * put������Ȼ���Դ�Ŷ���������hashcode�����ǣ�
		 * ��properties�й涨��storeֻ�ܴ��ַ�����ʽ
		 */
		p.put("userName","helloKitty");
		p.put("password", "111");
		//�����������ļ���
		FileOutputStream out = new FileOutputStream("src/message2.properties",true);
		p.store(out, "write something");
		out.close();
		in.close();
		
		
	}
}
