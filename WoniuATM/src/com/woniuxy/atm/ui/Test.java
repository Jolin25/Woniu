package com.woniuxy.atm.ui;

import java.io.File;
import java.io.IOException;

import com.woniuxy.atm.database.UserDatabase;

public class Test {
	public static void main(String[] args) throws IOException {
		
		UserDatabase ud = new UserDatabase();
		MainScreenUi m = new MainScreenUi();
		//因为while里面的判断语句是true，故无法相似while循环外面去再写任何语句
		while (true) {

			m.startMenu();
			m.chooseBeforLongin();

		}
		

	}
}
