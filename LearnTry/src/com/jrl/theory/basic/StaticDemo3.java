package com.jrl.theory.basic;

public class StaticDemo3 {
	public static StaticDemo3 s3 = new StaticDemo3();
	{
		System.out.println("��ţ");
	}
	static {
		System.out.println("ѧԺ");
	}

	public static void main(String[] args) {
		new StaticDemo3();
	}

}
