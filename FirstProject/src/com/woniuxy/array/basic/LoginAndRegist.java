package com.woniuxy.array.basic;

import java.util.Scanner;

public class LoginAndRegist {
	/*
	 * 注册并登陆用户
	 */
	public static void main(String[] args) {
		String user[][] = new String[2][2];
		user[0][0] = "qq";// 用户名
		user[0][1] = "q";// 用户密码
		user[1][0] = "ww";// 用户名
		user[1][1] = "w";// 用户密码

		Scanner sc = new Scanner(System.in);

		int choose = 1;

		int flag4 = 1;// 空间满否

		System.out.println("请选择：1.注册 2.登陆：");
		choose = sc.nextInt();
		// 注册
		if (choose == 1) {
			while (choose == 1) {
				int flag = 1;
				System.out.print("请输入新的用户名：\n");
				String name = sc.next();
				for (int i = 0; i < user.length; i++) {
					// 如果用户名已经存在
					if (name.equals(user[i][0])) {
						System.out.print("用戶名已存在\n");
						flag = 0;// flag ==1 表示用户名不存在
					}
				} // 如果用户名不存在
				System.out.print("========");
				if (flag == 1) {
					System.out.print("请输入新的密码：\n");
					String password = sc.next();
					// 判断空间是否已满
					for (int k = 0; k < user.length; k++) {
						if (user[k][0] == null) {// ==
							user[k][0] = name;
							user[k][1] = password;
							System.out.print("注册成功\n");
							flag4 = 0;// flag4==0代表空间没满

							break;
						}
					}
					// 如果空间满了，则动态扩展
					if (flag4 == 1) {

						String[][] newUser = new String[user.length + 1][2];
						newUser[user.length][0] = name;
						newUser[user.length][1] = password;
						for (int j = 0; j < user.length; j++) {
							newUser[j][0] = user[j][0];
							newUser[j][1] = user[j][1];
						}
						user = newUser;
						System.out.print("注册成功\n");

					}
				}

				System.out.print("请选择：1.注册 2.登陆：\n");
				choose = sc.nextInt();
				System.out.print(choose);
			}

		}

		// 登陆

		int flag2 = 0;// 标志是否登陆成功

		if (choose == 2) {

			int choose2 = 1;// 标志是否重新输入用户名
			// 是否登陆

			int flag5 = 0;// 标志是否找到了用户名
			while (choose2 == 1) {
				System.out.print("请输入用户名：\n");
				String name = sc.next();
				for (int i = 0; i < user.length; i++) {
					if (name.equals(user[i][0])) {
						flag5 = 1;// 找到用户名
						while (flag2 == 0) {

							System.out.print("请输入密码：\n");
							String password = sc.next();
							if (password.equals(user[i][1])) {
								System.out.print("登陆成功\n");
								flag2 = 1;
								break;
							} else {
								System.out.print("密码输入错误\n");
							}

						}

					}

				}
				// 如果没有找到用户名
				if (flag5 == 0) {

					System.out.print("用户名输入错误\n");

				}

				if (flag2 == 0) {
					System.out.print("是否重新登陆：1.是 2.否：\n");
					choose2 = sc.nextInt();
				} else {
					break;
				}
			}
		}
		sc.close();
	}

}
