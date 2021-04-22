package com.woniuxy.string.basic;

/*
 * 字符串解析,现有一字符串,"卡巴斯基#杀毒软件#免费版#俄罗斯#",解析出每个元素
 */
public class StringSplit {
	public static void main(String[] args) {
		String str = "卡巴斯基#杀毒软件#免费版#俄罗斯#";
		String[] str1 = str.split("#");
		for(String i : str1) {
			System.out.println(i);
		}
	}
}
