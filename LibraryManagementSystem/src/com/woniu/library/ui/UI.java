package com.woniu.library.ui;

import java.util.Scanner;

import com.woniu.library.database.Database;
import com.woniu.library.service.LoginService;

/*
 * 所有的菜单展示---ui
 */
public class UI {
	// 登陆前欢迎
	public void welcomeBeforLogin() {
		System.out.println("****************");
		System.out.println("欢迎使用图书馆管理系统");
		System.out.println("1:登陆    2：退出");
		System.out.println("****************");
	}

	// 用户选择菜单
	public void userChooseMenu() {
		System.out.println("****************");
		System.out.println("1:借书");
		System.out.println("****************");
	}

	// 管理员选择菜单
	public void adminChooseMenu() {

	}

	// 用户选择操作
	public void userChoose() {

	}

	// 管理员选择操作
	public void adminChoose() {

	}

	// 登陆选项-
	public void login() {
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			// 登陆
			LoginService ls = new LoginService();
			Boolean b = ls.loginS();
			if (b) {
				// 如果是用户权限
				if (Database.nowUser.getLimits() == 0) {
					userChooseMenu();
					userChoose();
				} else {// 如果是管理员权限
						// 管理员菜单
					adminChooseMenu();
					adminChoose();
				}
			} else {

			}
			break;
		default:
			break;
		}
	}

}
