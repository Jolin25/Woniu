package com.woniuxy.array.basic;

import java.util.Scanner;

public class LoginAndRegist {
	/*
	 * ע�Ტ��½�û�
	 */
	public static void main(String[] args) {
		String user[][] = new String[2][2];
		user[0][0] = "qq";// �û���
		user[0][1] = "q";// �û�����
		user[1][0] = "ww";// �û���
		user[1][1] = "w";// �û�����

		Scanner sc = new Scanner(System.in);

		int choose = 1;

		int flag4 = 1;// �ռ�����

		System.out.println("��ѡ��1.ע�� 2.��½��");
		choose = sc.nextInt();
		// ע��
		if (choose == 1) {
			while (choose == 1) {
				int flag = 1;
				System.out.print("�������µ��û�����\n");
				String name = sc.next();
				for (int i = 0; i < user.length; i++) {
					// ����û����Ѿ�����
					if (name.equals(user[i][0])) {
						System.out.print("�Ñ����Ѵ���\n");
						flag = 0;// flag ==1 ��ʾ�û���������
					}
				} // ����û���������
				System.out.print("========");
				if (flag == 1) {
					System.out.print("�������µ����룺\n");
					String password = sc.next();
					// �жϿռ��Ƿ�����
					for (int k = 0; k < user.length; k++) {
						if (user[k][0] == null) {// ==
							user[k][0] = name;
							user[k][1] = password;
							System.out.print("ע��ɹ�\n");
							flag4 = 0;// flag4==0����ռ�û��

							break;
						}
					}
					// ����ռ����ˣ���̬��չ
					if (flag4 == 1) {

						String[][] newUser = new String[user.length + 1][2];
						newUser[user.length][0] = name;
						newUser[user.length][1] = password;
						for (int j = 0; j < user.length; j++) {
							newUser[j][0] = user[j][0];
							newUser[j][1] = user[j][1];
						}
						user = newUser;
						System.out.print("ע��ɹ�\n");

					}
				}

				System.out.print("��ѡ��1.ע�� 2.��½��\n");
				choose = sc.nextInt();
				System.out.print(choose);
			}

		}

		// ��½

		int flag2 = 0;// ��־�Ƿ��½�ɹ�

		if (choose == 2) {

			int choose2 = 1;// ��־�Ƿ����������û���
			// �Ƿ��½

			int flag5 = 0;// ��־�Ƿ��ҵ����û���
			while (choose2 == 1) {
				System.out.print("�������û�����\n");
				String name = sc.next();
				for (int i = 0; i < user.length; i++) {
					if (name.equals(user[i][0])) {
						flag5 = 1;// �ҵ��û���
						while (flag2 == 0) {

							System.out.print("���������룺\n");
							String password = sc.next();
							if (password.equals(user[i][1])) {
								System.out.print("��½�ɹ�\n");
								flag2 = 1;
								break;
							} else {
								System.out.print("�����������\n");
							}

						}

					}

				}
				// ���û���ҵ��û���
				if (flag5 == 0) {

					System.out.print("�û����������\n");

				}

				if (flag2 == 0) {
					System.out.print("�Ƿ����µ�½��1.�� 2.��\n");
					choose2 = sc.nextInt();
				} else {
					break;
				}
			}
		}
		sc.close();
	}

}
