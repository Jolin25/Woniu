package com.woniuxy.java.basic;
import java.util.Scanner;//1.导包
public class FirstClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);//2.创建Scanner的对象（固定格式）
		System.out.println("请输入你的姓名");
		String name = sc.next();//3.使用Scanner的对象去调用Scanner类所提供的方法
		System.out.println("请输入你的年龄");
		String age = sc.nextLine();
		System.out.println("请输入你的家乡");
		String place = sc.next();
		System.out.println("姓名:" + name +" 年龄:" + age +" 家乡："+ place);
		sc.close();//4.关闭Scanner
	}

}
