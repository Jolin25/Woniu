package com.woniu.file.basic;

import java.io.File;

public class FileListTest {
	//显示磁盘里的所有文件
	public void showAllFile(File path) {
		//调用listFile的到该磁盘里的文件及其文件夹
		File[] files =path.listFiles();
		/*
		 * 对于c盘系统盘来说，有些隐藏的目录，
		 * listFiles方法是没有权限访问的，因此需要在程序中对获取出来的文件夹做为空判断：
		 * 			隐藏的文件在程序中是用null来表示的
		 */
		if(files == null || files.length<=0) {
			return;	
		}//因为递归了。。。所以可以判断到里面的每一个文件夹
		//遍历数组
		for(File file:files) {
			//判断是否是目录
			if(file.isDirectory()) {
				//如果是目录，则继续遍历
				showAllFile(file);
			}else {
				System.out.println(file.getPath());
			}
		}
	}
	public static void main(String[] args) {
		File path = new File("c:");
		FileListTest f = new FileListTest();
		f.showAllFile(path);
	}
}
