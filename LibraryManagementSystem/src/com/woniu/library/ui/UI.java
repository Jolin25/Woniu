package com.woniu.library.ui;

import java.util.Scanner;

import com.woniu.library.database.Database;
import com.woniu.library.service.LoginService;

/*
 * ���еĲ˵�չʾ---ui
 */
public class UI {
	// ��½ǰ��ӭ
	public void welcomeBeforLogin() {
		System.out.println("****************");
		System.out.println("��ӭʹ��ͼ��ݹ���ϵͳ");
		System.out.println("1:��½    2���˳�");
		System.out.println("****************");
	}

	// �û�ѡ��˵�
	public void userChooseMenu() {
		System.out.println("****************");
		System.out.println("1:����");
		System.out.println("****************");
	}

	// ����Աѡ��˵�
	public void adminChooseMenu() {

	}

	// �û�ѡ�����
	public void userChoose() {

	}

	// ����Աѡ�����
	public void adminChoose() {

	}

	// ��½ѡ��-
	public void login() {
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			// ��½
			LoginService ls = new LoginService();
			Boolean b = ls.loginS();
			if (b) {
				// ������û�Ȩ��
				if (Database.nowUser.getLimits() == 0) {
					userChooseMenu();
					userChoose();
				} else {// ����ǹ���ԱȨ��
						// ����Ա�˵�
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
