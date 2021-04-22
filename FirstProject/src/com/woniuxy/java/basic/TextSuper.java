//第七题：超市换购
package com.woniuxy.java.basic;

import java.util.Scanner;

public class TextSuper {
	public static void main(String[]args) {
		System.out.println("请输入消费金额：");//输入金额
		Scanner sc = new Scanner(System.in);
		double money = sc.nextDouble();
		String thing = "nothing";
		System.out.println("是否参加优惠换购活动：\n"+
				"1:满50元，加2元换购百事可乐一瓶\n"+
				"2:满100元，加3元换购500ml可乐一瓶\n"+
				"3：满100元，加10元换购五公斤面粉\n"+
				"4：满200元，加10元换购一个苏泊尔炒菜锅"+
				"5：满200元，加20元可换购欧莱雅爽肤水一瓶\n"+
				"0：不换购\n");
		System.out.println("请选择：");//选择换购物品
		int choose = sc.nextInt();
		if((money<50&&choose!=0)||
			(money<100&&(choose==2||choose==3))||
			(money<200)&&(choose==4||choose==5)) {
			System.out.println("输入错误");
			choose = 0;
		}/*计算总金额和换购物品*/
		switch(choose){
			case 1:
				money += 2;
				thing = "百事可乐一瓶";
				break;
			case 2:
				money += 3;
				thing = "500ml可乐一瓶";
				break;
			case 3:
				money += 10;
				thing = "五公斤面粉";
				break;
			case 4:
				money += 10;
				thing = "一个苏泊尔炒菜锅";
				break;
			case 5:
				money += 20;
				thing = "莱雅爽肤水一瓶";
				break;
			case 0:
				thing = "nothing";
					break;
			
		}
		System.out.println("本次消费总金额："+money+"成功换购："+thing);
		sc.close();
}
}
