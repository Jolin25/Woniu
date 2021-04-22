package com.woniuxy.opp.basic;

public class Test2 {
public static void main(String[] args) {
	Management m1 = new Management("李管理", 22, '男',"买菜",100);
	m1.show();
	OfficeClerk o1 = new OfficeClerk("张职员", 22, '男',20,"后勤");
	o1.show();
}
}
