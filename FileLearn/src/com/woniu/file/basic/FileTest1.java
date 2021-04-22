package com.woniu.file.basic;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest1 {
	public static void main(String[] args) {
		// 第一种构造方法
		File file1 = new File("d:/TestFile1/ee1.txt");
		// 第二种构造方法 ： 文件夹的路径名字符串+文件名字符串
		// d:/TestFile1/TestFile2/ 最后还加了一个斜杠是为了好区分这是一个文件夹
		File file2 = new File("d:/TestFile1/TestFile2/" + "ee2.txt");
		// 第三种构造方法：
		File dir = new File("d:/TestFile1/TestFile2/TestFile3/");// 文件夹
		File file3 = new File(dir, "ee3.txt");
		/*
		 * (抽象路径) 项目下的路径（默认路径）：word.txt 包下的路径：src/com.woniu.file.basic/word.txt
		 */
		File file4 = new File("word.txt");
		File file5 = new File("src/com.woniu.file.basic/word.txt");

		/*
		 * 输出文件的绝对路径
		 */
		System.out.println(file1.getAbsolutePath());
		System.out.println(file2.getAbsolutePath());
		System.out.println(file3.getAbsolutePath());
		System.out.println(file4.getAbsolutePath());
		System.out.println(file5.getAbsolutePath());
		/*
		 * 对比指向同一个文件的两个File对象是否相等
		 */
		File file6 = new File("d:/TestFile1/ee1.txt");// 与File1 指向了同一个文件
		System.out.println(file1 == file6);// 因为这是两个不同的对象
		System.out.println(file1.equals(file6));// 因为这两个对象的内容相同

		/*
		 * 使用:显示状态、属性、操作
		 */
		System.out.println("==============状态、属性===============");
		System.out.println("文件是否存在：" + file1.exists());
		System.out.println("文件名为：" + file1.getName());
		System.out.println("绝对路径为：" + file1.getAbsolutePath());
		System.out.println("文件大小：" + file1.length());// 输出文件大小，单位：字节数
		System.out.println("是否为隐藏文件：" + file1.isHidden());
		System.out.println("文件最后修改时间：" + file1.lastModified());// 返回一个距离1970的毫秒值long
		Date date1 = new Date(file1.lastModified());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:s ");// 如果是hh，则为12小时制的
		String lastModifiedTime = sdf.format(date1);
		System.out.println(lastModifiedTime);// 将最后修改时间格式化输出
		System.out.println("===========操作===============");
		boolean del = file1.delete();
		System.out.println("删除文件是否成功：" + del);
		try {
			// 已存在的文件，不能重新创建（不能覆盖已有文件）
			boolean create = file1.createNewFile();// 创建新的空文件
			System.out.println("创建文件是否成功：" + create);
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
