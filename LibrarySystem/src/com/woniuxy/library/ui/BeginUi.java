package com.woniuxy.library.ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.woniuxy.library.database.Database;
import com.woniuxy.library.service.BookService;
import com.woniuxy.library.service.LoginService;
import com.woniuxy.library.service.UserService;
import com.woniuxy.library.service.WaterInformationService;

/**
 * 开始界面
 * 备注：管理员admin：admin1  用户至少有：zhang3:zhang3
 * 
 * @author 小虫子的小日常
 *
 */
public class BeginUi {
	/*
	 * 欢迎界面
	 */
	public void welcome() {
		System.out.println("===欢迎来到图书馆管理系统===");
	}

	/*
	 * 登陆前的功能选择页面（也许可以放在welcome方法中）
	 */
	public void loginUi() {
		System.out.println("===请选择功能===");
		System.out.println("1:登陆	2：退出系统");
	}

	/*
	 * 登陆成功后的功能选择页面(普通用户)
	 */
	public void normalUserUi() {
		System.out.println("===请选择您要进行的操作===");
		System.out.println("1：租书	2：还书	3：查找书籍	4：退出登陆	5：退出系统");
	}

	/*
	 * 登陆成功后的功能选择页面(管理员)
	 */
	public void adminUi() {
		System.out.println("===请选择您要进行的操作===");
		System.out.println("1:查询流水    2：查询所有书籍   3:新增普通用户 4：新增书籍     5：修改书籍   6：删除书籍   7：退出登陆   8：退出系统");
	}

	/*
	 * 登陆前的功能选择菜单
	 */
	public void loginMenu() throws FileNotFoundException, IOException {

		Scanner sc = new Scanner(System.in);
		int choose = sc.nextInt();
		switch (choose) {
		case 1:
			// 登陆
			// 调用登陆逻辑部分
			LoginService ls = new LoginService();
			boolean isLogin = ls.loginS();
			// 根据结果进入不同的步骤
			if (isLogin) {// 验证成功
				System.out.println("登陆成功");
				if (Database.nowUser.getLimit() == 0) {// 管理员
					adminUi();
					adminMenu();
				} else {// 普通用户
					normalUserUi();
					normalUserMenu();
				}
			} else {// 验证失败
				System.out.println("登陆失败，请重新选择：");
				loginUi();
				loginMenu();
			}
			break;
		case 2:
			// 退出系统
			System.out.println("退出系统成功");
			System.exit(0);
			break;
		default:
			break;
		}
	}

	/*
	 * 登陆成功后的功能选择菜单(管理员)
	 */
	public void adminMenu() throws FileNotFoundException, IOException {
		Scanner sc = new Scanner(System.in);
		int choose = sc.nextInt();
		switch (choose) {
		case 1:
			// 1:查询流水
			WaterInformationService wis = new WaterInformationService();
			wis.look();
			//循环
			adminUi();
			adminMenu();
			break;
		case 2:
			// 2：查询所有书籍
			BookService bsl = new BookService();
			bsl.lookBookS();
			//循环
			adminUi();
			adminMenu();
			break;
		case 3:
			// 3：新增普通用户
			UserService usa = new UserService();
			usa.addUserS();
			//循环
			adminUi();
			adminMenu();
			break;
		case 4:
			// 4:新增书籍
			BookService bsa = new BookService();
			bsa.addBookS();
			//循环
			adminUi();
			adminMenu();
			break;
		case 5://(有问题，需要修改)
			// 5：修改书籍
			BookService bsm = new BookService();
			bsm.findS();//先查找指定书籍
			bsm.modifyBookS();//更改指定内容
			
			//循环
			adminUi();
			adminMenu();
			break;
		case 6:
			// 6：删除书籍
			BookService bsd = new BookService();
			bsd.deleteBookS();
			//循环
			adminUi();
			adminMenu();
			break;
		case 7:
			// 7：退出登陆

			Database.nowUser = null;
			// 开始页面
			loginUi();
			loginMenu();
			break;
		case 8:
			// 8：退出系统
			System.out.println("退出系统成功");
			System.exit(0);
			break;
		default:
			break;

		}
	}

	/*
	 * 登陆成功后功能选择菜单（普通用户）
	 */
	public void normalUserMenu() throws FileNotFoundException, IOException {
		Scanner sc = new Scanner(System.in);
		int choose = sc.nextInt();
		switch (choose) {
		case 1:
			// 1：租书
			BookService bsr = new BookService();
			bsr.showAllBook();
			bsr.rentBook();
			// 循环
			normalUserUi();
			normalUserMenu();
			break;
		case 2:
			// 2：还书
			// 展示当前用户的流水信息
			WaterInformationService ws = new WaterInformationService();
			ws.showNowUserWaterRentS();
			// 还书
			BookService bsre = new BookService();
			bsre.returnBookS();
			// 循环
			normalUserUi();
			normalUserMenu();
			break;
		case 3:
			// 3：查找书籍
			BookService bsf = new BookService();
			bsf.findS();
			// 循环
			normalUserUi();
			normalUserMenu();
			break;
		case 4:
			// 4：退出登陆
			Database.nowUser = null;
			// 开始页面
			loginUi();
			loginMenu();
			break;
		case 5:
			// 5：退出系统
			System.out.println("退出系统成功");
			System.exit(0);
			break;
		default:
			break;
		}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		BeginUi bu = new BeginUi();
		while (true) {
			bu.welcome();
			bu.loginUi();
			bu.loginMenu();
		}
	}

}
