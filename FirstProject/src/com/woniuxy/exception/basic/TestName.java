package com.woniuxy.exception.basic;

public class TestName {
	public static void main(String[] args) throws UserNameException  {
		
		String name = "С��ʺ";
		if(!name.equals("momoko")) {
			throw new UserNameException();
		}
	}
} 
