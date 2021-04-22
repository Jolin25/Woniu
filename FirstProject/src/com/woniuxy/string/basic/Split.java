package com.woniuxy.string.basic;
/*
 * 有如下格式的字符串name-age-sex-address,解析出姓名,年龄等信息；

 */
public class Split {
	public static void main(String[] args) {
		String str = "炸鸡-0.7-公-人民广场";
		String[] str1 = str.split("-");
		System.out.println("name:"+str1[0]+" age:"+str1[1]+" sex:"+str1[2]+" address:"+str1[3]);
	}
}
