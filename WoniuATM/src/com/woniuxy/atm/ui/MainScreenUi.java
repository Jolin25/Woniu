package com.woniuxy.atm.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

import com.woniuxy.atm.database.UserDatabase;
import com.woniuxy.atm.service.BalanceService;
import com.woniuxy.atm.service.DrawMoneyService;
import com.woniuxy.atm.service.LoginService;
import com.woniuxy.atm.service.SaveMoneyService;
import com.woniuxy.atm.service.SignUpService;
import com.woniuxy.atm.service.TransferService;

/*
 * 主页面
 */
public class MainScreenUi {
	/*
	 * 登陆前的欢迎部分
	 */
	public void startMenu() {
		System.out.println("======欢迎来到蜗牛ATM=====");
		//保持登录状态的判断
	}
	//保持登录状态的判断
	public void keepOnline() throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File("d:/TestFile1/nowUser.txt");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		ois.readObject();
	}
	/*
	 * 登陆后的欢迎部分
	 */
	public void welcom() {//欢迎UI
		System.out.println("欢迎" + UserDatabase.nowUserName + "使用蜗牛ATM");

	}

	/*
	 * 登陆前选择登陆或注册功能
	 */
	// boolean flagLogin = false;// 标志是否登陆成功

	public void chooseBeforLongin() throws IOException {//主菜单UI
		System.out.println("请选择功能：1.登陆 2.注册 3.退出系统");
		Scanner sc = new Scanner(System.in);
		int choose = sc.nextInt();
		switch (choose) {
		case 1:
			// 进入登陆页面
			LoginService logS = new LoginService();
			boolean login = logS.LoginS();// 进入登陆service部分

			// 匹配争取，则登陆
			if (login) {
				// flagLogin = true;
				welcom();
				chooseAfterLogin();
			} // 匹配失败则重新选择要进行的功能
			else {
				// flagLogin = false;
				System.out.println("请重新选择");

				chooseBeforLongin();
			}
			break;
		case 2:
			// 进入注册页面
			SignUpService signS = new SignUpService();
			boolean signup = signS.signUp();// 进入signupservice部分
			// 如果注册成功，进入欢迎界面进行功能选择
			if (signup) {
				System.out.println("注册成功！");
				startMenu();
				chooseBeforLongin();
			} // 注册失败，则提示并重选
			else {
				System.out.println("注册失败，请重新选择");
				startMenu();
				chooseBeforLongin();
			}
			break;
		case 3:
			// 退出系统
			System.exit(0);
			break;
		default:
			System.out.println("输入错误，请重新选择：");
			chooseBeforLongin();
			break;
		}
	}

	/*
	 * 登陆后选择业务功能
	 */
	public void chooseAfterLogin() throws IOException {//功能UI
		System.out.println("请选择功能：1.查看余额 2.转账 3.取钱 4.存钱 5.退出账户6.退出系统");
		Scanner sc = new Scanner(System.in);
		int choose = sc.nextInt();
		switch (choose) {
		case 1:
			// 查看余额
			BalanceService balanceS = new BalanceService();
			int balance = balanceS.getBalance(UserDatabase.nowUserName);// 进入service，获取余额
			System.out.println("余额为：" + balance);
			chooseAfterLogin();
			break;
		case 2:
			// 转账
			TransferService transforS = new TransferService();
			boolean transfer = transforS.transfer(UserDatabase.nowUserName);// 进入transferService
			if (transfer) {
				System.out.println("转账成功");
				LiuShuiUi liu = new LiuShuiUi();
				liu.liuShui();
			} else {
				System.out.println("转账失败，请重新选择：");
			}

			chooseAfterLogin();
			break;
		case 3:
			// 取钱
			DrawMoneyService drawS = new DrawMoneyService();
			boolean draw = drawS.drawMoney(UserDatabase.nowUserName);
			if (draw) {
				System.out.println("取款成功");
				LiuShuiUi liu = new LiuShuiUi();
				liu.liuShui();
			} else {
				System.out.println("取款失败，请重新选择：");
			}

			chooseAfterLogin();
			break;
		case 4:
			// 存钱
			SaveMoneyService saveS = new SaveMoneyService();
			boolean save = saveS.saveMoney(UserDatabase.nowUserName);
			if (save) {
				System.out.println("存款成功");
				LiuShuiUi liu = new LiuShuiUi();
				liu.liuShui();
			} else {
				System.out.println("存款失败，请重新选择：");
			}

			chooseAfterLogin();
			break;
		case 5:
			// 退出账户
			UserDatabase.nowUserName = null;
			System.out.println("退出成功！");
			startMenu();
			chooseBeforLongin();
			break;
		case 6:
			// 退出系统
			System.exit(0);
			break;
		default:
			System.out.println("输入错误，请重新选择");
			chooseAfterLogin();
			break;
		}
	}
}
