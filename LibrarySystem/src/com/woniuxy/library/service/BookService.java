package com.woniuxy.library.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.woniuxy.library.dao.BookDao;
import com.woniuxy.library.dao.po.Book;
import com.woniuxy.library.dao.po.WaterInformation;
import com.woniuxy.library.database.Database;

/**
 * 暂时计划是用来处理和书籍有关的逻辑业务
 * 
 * @author 小虫子的小日常
 *
 */
public class BookService {
	/*
	 * 展示所有的书籍
	 */
	public void showAllBook() {
		BookDao bd = new BookDao();
		List<Book> books = bd.showAllBook();
		System.out.println("所有书籍信息为：");
		for (Book book : books) {
			System.out.println("书籍编号：" + book.getId() + "   " + "书籍名称：" + book.getName() + "   " + "书籍类型："
					+ book.getType() + "   " + "是否借出：" + book.isOut());
		}
	}

	/*
	 * 租书
	 */
	public void rentBook() throws FileNotFoundException, IOException {
		System.out.println("请输入您要租借的图书编号：");
		Scanner sc = new Scanner(System.in);
		String chooseId = sc.next();
		BookDao bd = new BookDao();
		boolean b = bd.rentBook(chooseId);
		if (b) {
			System.out.println("借阅成功");
			Date outDate = new Date();
			// lsid+三位随机数作为流水单编号
			int one = (int) (Math.random() * 10);
			int two = (int) (Math.random() * 10);
			int three = (int) (Math.random() * 10);
			String lsId = "lsid" + one + two + three;
			// 生成流水单
			WaterInformation w = new WaterInformation(lsId, Database.nowUser.getName(), Database.nowBook.getName(),
					Database.nowBook.getId(), Database.nowBook.getType(), outDate, null);
			Database.waterInfomations.add(w);
			System.out.println("===流水信息===");
			System.out.println(w.toString());// 输出流水信息
			Database.updateWaterInformationTxt();// 跟新流水信息
		} else {
			System.out.println("借阅失败");
		}
	}

	/*
	 * 还书
	 */
	public void returnBookS() throws FileNotFoundException, IOException {
		System.out.println("请选择要还书的书籍编号：");
		Scanner sc = new Scanner(System.in);
		String choose = sc.next();
		BookDao bd = new BookDao();
		boolean returnBookD = bd.returnBookD(choose);
		if (returnBookD) {
			System.out.println("还书成功");
			System.out.println("===流水信息===");
			// 更新流水单信息
			// 找到流水单号
			WaterInformationService wis = new WaterInformationService();
			WaterInformation w = wis.find(choose);
			if (w.getIn() == null) {// 如果书没有被还，则归还
				// 把还书时间添加上
				Date d = new Date();
				w.setIn(d);
				// 跟新流水数据
				Database.updateWaterInformationTxt();
				// 输出流水信息
				System.out.println(w.toString());
			} else {// 否则输出已经还了
				System.out.println("您已还该书");
			}
		} else {
			System.out.println("还书失败");
		}

	}

	/*
	 * 查询指定书籍
	 */
	public void findS() {
		System.out.println("请输入书籍名称：");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		BookDao bd = new BookDao();
		Book book = bd.findD(name);
		if (book != null) {
			System.out.println("书籍信息为：");
			System.out.println("书籍编号：" + book.getId() + "   " + "书籍名称：" + book.getName() + "   " + "书籍类型："
					+ book.getType() +"   "+"书籍数量："+book.getNumber()+ "   " + "是否借出：" + book.isOut());
			Database.nowBook = book;// 设为当前使用的书籍
		} else {
			System.out.println("未找到指定书籍");

		}

	}

	/*
	 * 查询所有书籍
	 */
	public void lookBookS() {
		BookDao bd = new BookDao();
		List<Book> books = bd.lookBookD();
		System.out.println("所有书籍信息为：");
		for (Book book : books) {

			System.out.println("书籍编号：" + book.getId() + "   " + "书籍名称：" + book.getName() + "   " + "书籍类型："
					+ book.getType() + "   "+"书籍数量："+book.getNumber()+"   " + "是否借出：" + book.isOut());
		}
	}

	/*
	 * 新增书籍
	 */
	public void addBookS() throws FileNotFoundException, IOException {
		System.out.println("请输入要新增的书籍名称：");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		System.out.println("请输入要新增的书籍id：");
		String id = sc.next();

		System.out.println("请输入要新增的书籍类型：");
		String type = sc.next();
		System.out.println("请输入要新增的书籍数量：");
		int number = sc.nextInt();
		BookDao bd = new BookDao();
		boolean addBookD = bd.addBookD(name, id, type, number);
		if (addBookD) {
			System.out.println("添加成功");
		} else {
			System.out.println("添加失败");
		}

	}

	/*
	 * 修改书籍
	 */
	public void modifyBookS() throws FileNotFoundException, IOException {
		Scanner sc = new Scanner(System.in);
		boolean continueModify = true;
		while (continueModify) {
			System.out.println("请输入您要更改的部分：");
			System.out.println("1:书籍id  2：书籍名称3:书籍类型4：书籍数量  5：书籍借阅状态");
			int choose = sc.nextInt();
			BookDao bd = new BookDao();
			Book nowBook = Database.nowBook;
			String id = nowBook.getId();
			String name = nowBook.getName();
			String type = nowBook.getType();
			int number = nowBook.getNumber();
			boolean isOut = nowBook.isOut();
			switch (choose) {
			case 1:
				System.out.println("请输入要新的书籍id：");
				String newId = sc.next();
				boolean modifyBookDid = bd.modifyBookD(newId, name, type, number, isOut);
				if (modifyBookDid) {
					System.out.println("修改成功");
				} else {
					System.out.println("修改失败");
				}
				break;
			case 2:
				System.out.println("请输入新的书籍名称：");
				String newName = sc.next();
				boolean modifyBookDname = bd.modifyBookD(id, newName, type, number, isOut);
				if (modifyBookDname) {
					System.out.println("修改成功");
				} else {
					System.out.println("修改失败");
				}
				break;
			case 3:
				System.out.println("请输入要新的书籍类型：");
				String newType = sc.next();
				boolean modifyBookDtype = bd.modifyBookD(id, name, newType, number, isOut);
				if (modifyBookDtype) {
					System.out.println("修改成功");
				} else {
					System.out.println("修改失败");
				}
				break;
			case 4:
				System.out.println("请输入要新的书籍数量：");
				int newNumber = sc.nextInt();
				boolean modifyBookDnumber = bd.modifyBookD(id, name, type, newNumber, isOut);
				if (modifyBookDnumber) {
					System.out.println("修改成功");
				} else {
					System.out.println("修改失败");
				}
				break;
			case 5:
				System.out.println("请输入要新的借阅情况：");
				boolean newIsOut = sc.nextBoolean();
				boolean modifyBookDisout = bd.modifyBookD(id, name, type, number, newIsOut);
				if (modifyBookDisout) {
					System.out.println("修改成功");
				} else {
					System.out.println("修改失败");
				}
				break;
			default:
				break;

			}
			System.out.println("是否继续修改：y/n");
			if(sc.next().equals("n")) {
				continueModify=false;
			}
		}
		

	}

	/*
	 * 删除指定书籍
	 */
	public void deleteBookS() throws FileNotFoundException, IOException {
		System.out.println("请输入要删除的书籍名称：");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		BookDao bd = new BookDao();
		boolean deleteBookD = bd.deleteBookD(name);
		if (deleteBookD) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
	}
}
