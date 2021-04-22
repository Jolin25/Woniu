package com.woniuxy.exception.basic;

public class TestName {
	public static void main(String[] args) throws UserNameException  {
		
		String name = "Ð¡¹·Êº";
		if(!name.equals("momoko")) {
			throw new UserNameException();
		}
	}
} 
