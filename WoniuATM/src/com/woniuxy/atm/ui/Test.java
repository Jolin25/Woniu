package com.woniuxy.atm.ui;

import java.io.File;
import java.io.IOException;

import com.woniuxy.atm.database.UserDatabase;

public class Test {
	public static void main(String[] args) throws IOException {
		
		UserDatabase ud = new UserDatabase();
		MainScreenUi m = new MainScreenUi();
		//��Ϊwhile������ж������true�����޷�����whileѭ������ȥ��д�κ����
		while (true) {

			m.startMenu();
			m.chooseBeforLongin();

		}
		

	}
}
