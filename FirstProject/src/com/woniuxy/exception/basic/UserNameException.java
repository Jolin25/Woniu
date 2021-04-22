package com.woniuxy.exception.basic;

public class UserNameException extends Exception {
	
	public UserNameException(String message) {
		super(message);
	} 

	public UserNameException() {
		super("用户名输入不正确");
	}
}
