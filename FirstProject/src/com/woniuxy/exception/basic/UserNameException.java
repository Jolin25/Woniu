package com.woniuxy.exception.basic;

public class UserNameException extends Exception {
	
	public UserNameException(String message) {
		super(message);
	} 

	public UserNameException() {
		super("�û������벻��ȷ");
	}
}
