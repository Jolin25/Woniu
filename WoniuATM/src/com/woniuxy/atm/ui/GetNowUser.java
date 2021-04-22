package com.woniuxy.atm.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.woniuxy.atm.database.UserTemplateDatabase;

public class GetNowUser {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File("d:/TestFile1/nowUser.txt");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		UserTemplateDatabase u =(UserTemplateDatabase)ois.readObject();
		System.out.println(u.toString());
	}
}
