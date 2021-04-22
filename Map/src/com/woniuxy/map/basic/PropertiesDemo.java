package com.woniuxy.map.basic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesDemo {
	public void read() throws IOException {
		// 把配置文件装到输入流中
		// InputStream in =
		// PropertiesDemo.class.getClassLoader().getResourceAsStream("message2.properties");
		InputStream in = PropertiesDemo.class.getResourceAsStream("../../../../message2.properties");
		// 创建properties对象
		Properties p = new Properties();
		// 加载流
		p.load(in);
		// 获取配置文件中的属性
		String name = p.getProperty("name");
		String age = p.getProperty("age");
		String sex = p.getProperty("sex");
		String chinese = p.getProperty("Chinese");
		System.out.println(name + "---" + age + "---" + sex + "---" + chinese);
		// 关闭流
		in.close();

	}
	//向配置文件中写入
	public void write() throws IOException {
		//放入输入流中，得到对应的输入流
		InputStream in = PropertiesDemo.class.getResourceAsStream("/message2.properties");
		//创建properties对象
		Properties p = new Properties();
		//调用加载方法,将流加载
		p.load(in);
		//向properties对象写属性
		/*
		 * put方法虽然可以存放对象，来自于hashcode，但是，
		 * 在properties中规定了store只能存字符串形式
		 */
		p.put("userName","helloKitty");
		p.put("password", "111");
		//保存在配置文件中
		FileOutputStream out = new FileOutputStream("src/message2.properties",true);
		p.store(out, "write something");
		out.close();
		in.close();
		
		
	}
}
