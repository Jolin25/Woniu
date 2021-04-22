package com.woniuxy.opp.basic;

public class OfficeClerk extends Staff {

	
	int monthlySalary;
	String depatment;
	
	public OfficeClerk(String name, int age, char sex,int monthlySalary,String depatment) {
		super(name, age, sex);
		this.monthlySalary = monthlySalary;
		this. depatment = depatment;
	}
	
	
	@Override
	public void show() {
		super.show();
		System.out.println("ÔÂÐ½£º"+monthlySalary+",²¿ÃÅ£º" + depatment);
		
	}
}
