package com.woniuxy.basic.day04;

import java.util.Scanner;

public class Shopping {
	public static void main(String[] args) {
		String another = "y";// 是否继续购买
		Scanner sc = new Scanner(System.in);
		int thing;// 编号
		int number;// 数量
		double price;// 单价
		// double money;// 单次消费总额
		double allMoney = 0;// 合计消费
		String Vip;// 会员
		double outOfPocket;// 实付金额
		/*当要继续购买时，计算单次购买情况*/
		while (another.equals("y")) {
			System.out.println("*******************************");
			System.out.println("请选择购买的商品编号：\n" + "1.T 恤        2.网球鞋        3.网球拍");
			System.out.println("*******************************");
			System.out.println("请输入商品编号：");
			thing = sc.nextInt();
			System.out.println("请输入购买数量：");
			number = sc.nextInt();
			/*判断购买的商品和数量，进行单次计算，输出，
			并选择是否继续*/
			switch (thing) {
			case 1:
				price = 245;
				System.out.println("T恤：￥" + price + "   " + "数量：" + number + "   " + "合计:￥" + price * number);
				allMoney += price * number;
				System.out.println("是否继续：（y/n）");
				System.out.println();
				another = sc.next();
				break;
			case 2:
				price = 570;
				System.out.println("网球鞋：￥" + price + "   " + "数量：" + number + "   " + "合计:￥" + price * number);
				allMoney += price * number;
				System.out.println("是否继续：（y/n）");
				System.out.println();
				another = sc.next();
				break;
			case 3:
				price = 460;
				System.out.println("网球拍：￥" + price + "   " + "数量：" + number + "   " + "合计:￥" + price * number);
				allMoney += price * number;
				System.out.println("是否继续：（y/n）");
				System.out.println();
				another = sc.next();
				break;
			default:
				System.out.println("输入错误");
				System.out.println();
				break;
			}

		}/*结束购买后，计算总金额等*/
		System.out.println("是否是会员（y/n）：");
		Vip = sc.next();
		/*会员*/
		if (Vip.equals("y")) {
			System.out.println("折扣：" + allMoney * 0.1);
			System.out.println("应付金额：" + allMoney * 0.9);
			System.out.println("请输入实付金额：");
			outOfPocket = sc.nextDouble();
			System.out.println("实付金额：" + outOfPocket);
			if (outOfPocket - allMoney * 0.9 > 0) {
				System.out.println("找钱：" + (outOfPocket - allMoney * 0.9));
			} else {
				System.out.println("输入错误");
			}
		} 
		/*非会员*/
		else {
			System.out.println("折扣：0");
			System.out.println("应付金额：" + allMoney);
			System.out.println("请输入实付金额：");
			outOfPocket = sc.nextDouble();
			System.out.println("实付金额：" + outOfPocket);
			if (outOfPocket - allMoney > 0) {
				System.out.println("找钱：" + (outOfPocket - allMoney));
			} else {
				System.out.print("输入错误");
			}
		}
		sc.close();
	}
}
