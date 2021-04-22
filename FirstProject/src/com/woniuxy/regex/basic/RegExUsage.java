package com.woniuxy.regex.basic;
/*
 * ����Pattern Matcher ������������ʽ��ƥ��
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExUsage {
	public static void main(String[] args) {
		RegExUsage re = new RegExUsage();
		re.match();
	}
	public void match() {
		String phone = "15681223235";
		String phoneEx = "^1[3578]\\d{9}";
		//System.out.println(phoneEx);
		//ָ��Ϊ�ַ�����������ʽ�������ȱ�����Ϊ����(Pattern)��ʵ����
		Pattern pattern = Pattern.compile(phoneEx);
		//System.out.println(pattern);
		/*
		 * Ȼ�󣬿ɽ��õ���ģʽ���ڴ��� Matcher ����(ͨ��Pattern�������)
		 * ����������ʽ���ö�������������ַ�����ƥ�䡣
		 * ִ��ƥ�����漰������״̬��פ����ƥ�����У����Զ��ƥ�������Թ���ͬһģʽ��
		 */	
		Matcher matcherPhone = pattern.matcher(phone);
	//	System.out.println(matcherPhone);
		//����matcher���ṩ��matches�������صõ�ƥ��Ľ��
		boolean rs = matcherPhone.matches();
		System.out.println("�ֻ���֤��"+rs);
	}
}
