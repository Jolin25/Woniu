package com.woniuxy.opp.basic;

public class Staff {
  public String name;
  public int age;
  public char sex;
  
  public Staff(String name,int age,char sex) {
	  this.name =name;
	  this.age =age;
	  this.sex = sex;
  }
  
  public void show() {
	  System.out.print("������"+name+",����"+age+",�Ա�"+sex+",");
  }
}
