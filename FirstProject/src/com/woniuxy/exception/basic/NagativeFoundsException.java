package com.woniuxy.exception.basic;
/*
 * 银行取款余额为负数自定义异常类
 */
public class NagativeFoundsException extends Exception {
	@Override
	public String getMessage() {
		return "取款为负";  
	}
	 
}
   