package com.woniuxy.opp.basic;

public class Management extends Staff{
	
	String duty;
	int salary;
	
	
	public Management(String name, int age, char sex,String duty,int salary) {
		super(name, age, sex);	
		this.duty = duty;
		this.salary =salary;
	}
	@Override
	public void show() {
		super.show();
		System.out.println("Ö°Îñ£º"+duty +"£¬ÄêÐ½£º"+ salary);
		
	}
}
