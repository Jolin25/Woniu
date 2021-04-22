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
 * ��ʼ����
 * ��ע������Աadmin��admin1  �û������У�zhang3:zhang3
 * 
 * @author С���ӵ�С�ճ�
 *
 */
public class BeginUi {
	/*
	 * ��ӭ����
	 */
	public void welcome() {
		System.out.println("===��ӭ����ͼ��ݹ���ϵͳ===");
	}

	/*
	 * ��½ǰ�Ĺ���ѡ��ҳ�棨Ҳ����Է���welcome�����У�
	 */
	public void loginUi() {
		System.out.println("===��ѡ����===");
		System.out.println("1:��½	2���˳�ϵͳ");
	}

	/*
	 * ��½�ɹ���Ĺ���ѡ��ҳ��(��ͨ�û�)
	 */
	public void normalUserUi() {
		System.out.println("===��ѡ����Ҫ���еĲ���===");
		System.out.println("1������	2������	3�������鼮	4���˳���½	5���˳�ϵͳ");
	}

	/*
	 * ��½�ɹ���Ĺ���ѡ��ҳ��(����Ա)
	 */
	public void adminUi() {
		System.out.println("===��ѡ����Ҫ���еĲ���===");
		System.out.println("1:��ѯ��ˮ    2����ѯ�����鼮   3:������ͨ�û� 4�������鼮     5���޸��鼮   6��ɾ���鼮   7���˳���½   8���˳�ϵͳ");
	}

	/*
	 * ��½ǰ�Ĺ���ѡ��˵�
	 */
	public void loginMenu() throws FileNotFoundException, IOException {

		Scanner sc = new Scanner(System.in);
		int choose = sc.nextInt();
		switch (choose) {
		case 1:
			// ��½
			// ���õ�½�߼�����
			LoginService ls = new LoginService();
			boolean isLogin = ls.loginS();
			// ���ݽ�����벻ͬ�Ĳ���
			if (isLogin) {// ��֤�ɹ�
				System.out.println("��½�ɹ�");
				if (Database.nowUser.getLimit() == 0) {// ����Ա
					adminUi();
					adminMenu();
				} else {// ��ͨ�û�
					normalUserUi();
					normalUserMenu();
				}
			} else {// ��֤ʧ��
				System.out.println("��½ʧ�ܣ�������ѡ��");
				loginUi();
				loginMenu();
			}
			break;
		case 2:
			// �˳�ϵͳ
			System.out.println("�˳�ϵͳ�ɹ�");
			System.exit(0);
			break;
		default:
			break;
		}
	}

	/*
	 * ��½�ɹ���Ĺ���ѡ��˵�(����Ա)
	 */
	public void adminMenu() throws FileNotFoundException, IOException {
		Scanner sc = new Scanner(System.in);
		int choose = sc.nextInt();
		switch (choose) {
		case 1:
			// 1:��ѯ��ˮ
			WaterInformationService wis = new WaterInformationService();
			wis.look();
			//ѭ��
			adminUi();
			adminMenu();
			break;
		case 2:
			// 2����ѯ�����鼮
			BookService bsl = new BookService();
			bsl.lookBookS();
			//ѭ��
			adminUi();
			adminMenu();
			break;
		case 3:
			// 3��������ͨ�û�
			UserService usa = new UserService();
			usa.addUserS();
			//ѭ��
			adminUi();
			adminMenu();
			break;
		case 4:
			// 4:�����鼮
			BookService bsa = new BookService();
			bsa.addBookS();
			//ѭ��
			adminUi();
			adminMenu();
			break;
		case 5://(�����⣬��Ҫ�޸�)
			// 5���޸��鼮
			BookService bsm = new BookService();
			bsm.findS();//�Ȳ���ָ���鼮
			bsm.modifyBookS();//����ָ������
			
			//ѭ��
			adminUi();
			adminMenu();
			break;
		case 6:
			// 6��ɾ���鼮
			BookService bsd = new BookService();
			bsd.deleteBookS();
			//ѭ��
			adminUi();
			adminMenu();
			break;
		case 7:
			// 7���˳���½

			Database.nowUser = null;
			// ��ʼҳ��
			loginUi();
			loginMenu();
			break;
		case 8:
			// 8���˳�ϵͳ
			System.out.println("�˳�ϵͳ�ɹ�");
			System.exit(0);
			break;
		default:
			break;

		}
	}

	/*
	 * ��½�ɹ�����ѡ��˵�����ͨ�û���
	 */
	public void normalUserMenu() throws FileNotFoundException, IOException {
		Scanner sc = new Scanner(System.in);
		int choose = sc.nextInt();
		switch (choose) {
		case 1:
			// 1������
			BookService bsr = new BookService();
			bsr.showAllBook();
			bsr.rentBook();
			// ѭ��
			normalUserUi();
			normalUserMenu();
			break;
		case 2:
			// 2������
			// չʾ��ǰ�û�����ˮ��Ϣ
			WaterInformationService ws = new WaterInformationService();
			ws.showNowUserWaterRentS();
			// ����
			BookService bsre = new BookService();
			bsre.returnBookS();
			// ѭ��
			normalUserUi();
			normalUserMenu();
			break;
		case 3:
			// 3�������鼮
			BookService bsf = new BookService();
			bsf.findS();
			// ѭ��
			normalUserUi();
			normalUserMenu();
			break;
		case 4:
			// 4���˳���½
			Database.nowUser = null;
			// ��ʼҳ��
			loginUi();
			loginMenu();
			break;
		case 5:
			// 5���˳�ϵͳ
			System.out.println("�˳�ϵͳ�ɹ�");
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
