package com.woniuxy.atm.ui;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.woniuxy.atm.database.UserDatabase;

/*
 * ��ˮUI
 */
public class LiuShuiUi {
	public void liuShui() {
		// ��ʾСƱ����
		// ��ǰʱ��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ssa");
		String time = sdf.format(new Date());
		/*
		 * �����û���
		 */
		String changUserName = UserDatabase.nowUserName;
		char[]changUser = changUserName.toCharArray();//�����ַ�����
		if(changUser.length<3) {
			changUser[1]='*';
		}else {
			for(int i= 1;i<changUser.length-1;i++) {
				changUser[i]='*';
			}
		}
		String afterName= String.valueOf(changUser);//Ҫ��ӡ������û���
		System.out.println("======СƱ======\n"+"�˺ţ�"+UserDatabase.nowUserAccount+"\n"+"�û�����" + afterName + 
				"\n" + "���׽�" + UserDatabase.nowChangeMoney + "\n"
				+ "����ʱ�䣺" + time);
	}
	
}
