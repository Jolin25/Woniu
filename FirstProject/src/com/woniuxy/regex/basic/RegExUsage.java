package com.woniuxy.regex.basic;
/*
 * 利用Pattern Matcher 来进行正则表达式的匹配
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
		//指定为字符串的正则表达式必须首先被编译为此类(Pattern)的实例。
		Pattern pattern = Pattern.compile(phoneEx);
		//System.out.println(pattern);
		/*
		 * 然后，可将得到的模式用于创建 Matcher 对象，(通过Pattern对象调用)
		 * 依照正则表达式，该对象可以与任意字符序列匹配。
		 * 执行匹配所涉及的所有状态都驻留在匹配器中，所以多个匹配器可以共享同一模式。
		 */	
		Matcher matcherPhone = pattern.matcher(phone);
	//	System.out.println(matcherPhone);
		//利用matcher类提供的matches方法返回得到匹配的结果
		boolean rs = matcherPhone.matches();
		System.out.println("手机验证："+rs);
	}
}
