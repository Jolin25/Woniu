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
 * ��ҳ��
 */
public class MainScreenUi {
	/*
	 * ��½ǰ�Ļ�ӭ����
	 */
	public void startMenu() {
		System.out.println("======��ӭ������ţATM=====");
		//���ֵ�¼״̬���ж�
	}
	//���ֵ�¼״̬���ж�
	public void keepOnline() throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File("d:/TestFile1/nowUser.txt");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		ois.readObject();
	}
	/*
	 * ��½��Ļ�ӭ����
	 */
	public void welcom() {//��ӭUI
		System.out.println("��ӭ" + UserDatabase.nowUserName + "ʹ����ţATM");

	}

	/*
	 * ��½ǰѡ���½��ע�Ṧ��
	 */
	// boolean flagLogin = false;// ��־�Ƿ��½�ɹ�

	public void chooseBeforLongin() throws IOException {//���˵�UI
		System.out.println("��ѡ���ܣ�1.��½ 2.ע�� 3.�˳�ϵͳ");
		Scanner sc = new Scanner(System.in);
		int choose = sc.nextInt();
		switch (choose) {
		case 1:
			// �����½ҳ��
			LoginService logS = new LoginService();
			boolean login = logS.LoginS();// �����½service����

			// ƥ����ȡ�����½
			if (login) {
				// flagLogin = true;
				welcom();
				chooseAfterLogin();
			} // ƥ��ʧ��������ѡ��Ҫ���еĹ���
			else {
				// flagLogin = false;
				System.out.println("������ѡ��");

				chooseBeforLongin();
			}
			break;
		case 2:
			// ����ע��ҳ��
			SignUpService signS = new SignUpService();
			boolean signup = signS.signUp();// ����signupservice����
			// ���ע��ɹ������뻶ӭ������й���ѡ��
			if (signup) {
				System.out.println("ע��ɹ���");
				startMenu();
				chooseBeforLongin();
			} // ע��ʧ�ܣ�����ʾ����ѡ
			else {
				System.out.println("ע��ʧ�ܣ�������ѡ��");
				startMenu();
				chooseBeforLongin();
			}
			break;
		case 3:
			// �˳�ϵͳ
			System.exit(0);
			break;
		default:
			System.out.println("�������������ѡ��");
			chooseBeforLongin();
			break;
		}
	}

	/*
	 * ��½��ѡ��ҵ����
	 */
	public void chooseAfterLogin() throws IOException {//����UI
		System.out.println("��ѡ���ܣ�1.�鿴��� 2.ת�� 3.ȡǮ 4.��Ǯ 5.�˳��˻�6.�˳�ϵͳ");
		Scanner sc = new Scanner(System.in);
		int choose = sc.nextInt();
		switch (choose) {
		case 1:
			// �鿴���
			BalanceService balanceS = new BalanceService();
			int balance = balanceS.getBalance(UserDatabase.nowUserName);// ����service����ȡ���
			System.out.println("���Ϊ��" + balance);
			chooseAfterLogin();
			break;
		case 2:
			// ת��
			TransferService transforS = new TransferService();
			boolean transfer = transforS.transfer(UserDatabase.nowUserName);// ����transferService
			if (transfer) {
				System.out.println("ת�˳ɹ�");
				LiuShuiUi liu = new LiuShuiUi();
				liu.liuShui();
			} else {
				System.out.println("ת��ʧ�ܣ�������ѡ��");
			}

			chooseAfterLogin();
			break;
		case 3:
			// ȡǮ
			DrawMoneyService drawS = new DrawMoneyService();
			boolean draw = drawS.drawMoney(UserDatabase.nowUserName);
			if (draw) {
				System.out.println("ȡ��ɹ�");
				LiuShuiUi liu = new LiuShuiUi();
				liu.liuShui();
			} else {
				System.out.println("ȡ��ʧ�ܣ�������ѡ��");
			}

			chooseAfterLogin();
			break;
		case 4:
			// ��Ǯ
			SaveMoneyService saveS = new SaveMoneyService();
			boolean save = saveS.saveMoney(UserDatabase.nowUserName);
			if (save) {
				System.out.println("���ɹ�");
				LiuShuiUi liu = new LiuShuiUi();
				liu.liuShui();
			} else {
				System.out.println("���ʧ�ܣ�������ѡ��");
			}

			chooseAfterLogin();
			break;
		case 5:
			// �˳��˻�
			UserDatabase.nowUserName = null;
			System.out.println("�˳��ɹ���");
			startMenu();
			chooseBeforLongin();
			break;
		case 6:
			// �˳�ϵͳ
			System.exit(0);
			break;
		default:
			System.out.println("�������������ѡ��");
			chooseAfterLogin();
			break;
		}
	}
}
