
package com.woniuxy.array.basic;

import java.util.Scanner;

//���ε�½��֤
public class UserLogin {
	public static void main(String[] args) {

		String user[][] = new String[3][2];
		user[0][0] = "��һ";// �û���
		user[0][1] = "1";// ����
		user[1][0] = "�Ŷ�";
		user[1][1] = "2";
		user[2][0] = "����";
		user[2][1] = "3";
		boolean flagName = false;
		Scanner sc = new Scanner(System.in);

		for (int k = 0; k < 3; k++) {// ���������û�������
			System.out.println("������������\n");
			String name = sc.next();
			for (int i = 0; i < user.length; i++) {

				if (name.equals(user[i][0])) {// �ҵ��û���
					k = 3;//�ҵ��û��������û����������εĻ����ù�
					flagName = true;
					
					for (int m = 0; m < 3; m++) {// ���������������
						System.out.print("���������룺\n");
						if (sc.next().equals(user[i][1])) {
							System.out.print("��¼�ɹ�");
							k = 3;
							break;
						} else {// �������
							System.out.print("�����������");
						}

					}
					
				} else if (!flagName && i == user.length - 1) {// δ�ҵ�����
					System.out.println("�û��������ڣ�");
				}

			}

		}
		sc.close();
	}
}
