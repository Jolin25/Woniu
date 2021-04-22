package com.woniuxy.atm.ui;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.woniuxy.atm.database.UserDatabase;

/*
 * 流水UI
 */
public class LiuShuiUi {
	public void liuShui() {
		// 显示小票内容
		// 当前时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ssa");
		String time = sdf.format(new Date());
		/*
		 * 隐藏用户名
		 */
		String changUserName = UserDatabase.nowUserName;
		char[]changUser = changUserName.toCharArray();//换成字符数组
		if(changUser.length<3) {
			changUser[1]='*';
		}else {
			for(int i= 1;i<changUser.length-1;i++) {
				changUser[i]='*';
			}
		}
		String afterName= String.valueOf(changUser);//要打印输出的用户名
		System.out.println("======小票======\n"+"账号："+UserDatabase.nowUserAccount+"\n"+"用户名：" + afterName + 
				"\n" + "交易金额：" + UserDatabase.nowChangeMoney + "\n"
				+ "交易时间：" + time);
	}
	
}
