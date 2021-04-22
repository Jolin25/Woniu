
package com.woniuxy.array.basic;

import java.util.Scanner;

//三次登陆验证
public class UserLogin {
	public static void main(String[] args) {

		String user[][] = new String[3][2];
		user[0][0] = "张一";// 用户名
		user[0][1] = "1";// 密码
		user[1][0] = "张二";
		user[1][1] = "2";
		user[2][0] = "张三";
		user[2][1] = "3";
		boolean flagName = false;
		Scanner sc = new Scanner(System.in);

		for (int k = 0; k < 3; k++) {// 控制输入用户名次数
			System.out.println("请输入姓名：\n");
			String name = sc.next();
			for (int i = 0; i < user.length; i++) {

				if (name.equals(user[i][0])) {// 找到用户名
					k = 3;//找到用户名，则用户名输入三次的机会用光
					flagName = true;
					
					for (int m = 0; m < 3; m++) {// 控制输入密码次数
						System.out.print("请输入密码：\n");
						if (sc.next().equals(user[i][1])) {
							System.out.print("登录成功");
							k = 3;
							break;
						} else {// 密码错误
							System.out.print("密码输入错误！");
						}

					}
					
				} else if (!flagName && i == user.length - 1) {// 未找到姓名
					System.out.println("用户名不存在！");
				}

			}

		}
		sc.close();
	}
}
