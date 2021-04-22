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
 * ��ʱ�ƻ�������������鼮�йص��߼�ҵ��
 * 
 * @author С���ӵ�С�ճ�
 *
 */
public class BookService {
	/*
	 * չʾ���е��鼮
	 */
	public void showAllBook() {
		BookDao bd = new BookDao();
		List<Book> books = bd.showAllBook();
		System.out.println("�����鼮��ϢΪ��");
		for (Book book : books) {
			System.out.println("�鼮��ţ�" + book.getId() + "   " + "�鼮���ƣ�" + book.getName() + "   " + "�鼮���ͣ�"
					+ book.getType() + "   " + "�Ƿ�����" + book.isOut());
		}
	}

	/*
	 * ����
	 */
	public void rentBook() throws FileNotFoundException, IOException {
		System.out.println("��������Ҫ����ͼ���ţ�");
		Scanner sc = new Scanner(System.in);
		String chooseId = sc.next();
		BookDao bd = new BookDao();
		boolean b = bd.rentBook(chooseId);
		if (b) {
			System.out.println("���ĳɹ�");
			Date outDate = new Date();
			// lsid+��λ�������Ϊ��ˮ�����
			int one = (int) (Math.random() * 10);
			int two = (int) (Math.random() * 10);
			int three = (int) (Math.random() * 10);
			String lsId = "lsid" + one + two + three;
			// ������ˮ��
			WaterInformation w = new WaterInformation(lsId, Database.nowUser.getName(), Database.nowBook.getName(),
					Database.nowBook.getId(), Database.nowBook.getType(), outDate, null);
			Database.waterInfomations.add(w);
			System.out.println("===��ˮ��Ϣ===");
			System.out.println(w.toString());// �����ˮ��Ϣ
			Database.updateWaterInformationTxt();// ������ˮ��Ϣ
		} else {
			System.out.println("����ʧ��");
		}
	}

	/*
	 * ����
	 */
	public void returnBookS() throws FileNotFoundException, IOException {
		System.out.println("��ѡ��Ҫ������鼮��ţ�");
		Scanner sc = new Scanner(System.in);
		String choose = sc.next();
		BookDao bd = new BookDao();
		boolean returnBookD = bd.returnBookD(choose);
		if (returnBookD) {
			System.out.println("����ɹ�");
			System.out.println("===��ˮ��Ϣ===");
			// ������ˮ����Ϣ
			// �ҵ���ˮ����
			WaterInformationService wis = new WaterInformationService();
			WaterInformation w = wis.find(choose);
			if (w.getIn() == null) {// �����û�б�������黹
				// �ѻ���ʱ�������
				Date d = new Date();
				w.setIn(d);
				// ������ˮ����
				Database.updateWaterInformationTxt();
				// �����ˮ��Ϣ
				System.out.println(w.toString());
			} else {// ��������Ѿ�����
				System.out.println("���ѻ�����");
			}
		} else {
			System.out.println("����ʧ��");
		}

	}

	/*
	 * ��ѯָ���鼮
	 */
	public void findS() {
		System.out.println("�������鼮���ƣ�");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		BookDao bd = new BookDao();
		Book book = bd.findD(name);
		if (book != null) {
			System.out.println("�鼮��ϢΪ��");
			System.out.println("�鼮��ţ�" + book.getId() + "   " + "�鼮���ƣ�" + book.getName() + "   " + "�鼮���ͣ�"
					+ book.getType() +"   "+"�鼮������"+book.getNumber()+ "   " + "�Ƿ�����" + book.isOut());
			Database.nowBook = book;// ��Ϊ��ǰʹ�õ��鼮
		} else {
			System.out.println("δ�ҵ�ָ���鼮");

		}

	}

	/*
	 * ��ѯ�����鼮
	 */
	public void lookBookS() {
		BookDao bd = new BookDao();
		List<Book> books = bd.lookBookD();
		System.out.println("�����鼮��ϢΪ��");
		for (Book book : books) {

			System.out.println("�鼮��ţ�" + book.getId() + "   " + "�鼮���ƣ�" + book.getName() + "   " + "�鼮���ͣ�"
					+ book.getType() + "   "+"�鼮������"+book.getNumber()+"   " + "�Ƿ�����" + book.isOut());
		}
	}

	/*
	 * �����鼮
	 */
	public void addBookS() throws FileNotFoundException, IOException {
		System.out.println("������Ҫ�������鼮���ƣ�");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		System.out.println("������Ҫ�������鼮id��");
		String id = sc.next();

		System.out.println("������Ҫ�������鼮���ͣ�");
		String type = sc.next();
		System.out.println("������Ҫ�������鼮������");
		int number = sc.nextInt();
		BookDao bd = new BookDao();
		boolean addBookD = bd.addBookD(name, id, type, number);
		if (addBookD) {
			System.out.println("��ӳɹ�");
		} else {
			System.out.println("���ʧ��");
		}

	}

	/*
	 * �޸��鼮
	 */
	public void modifyBookS() throws FileNotFoundException, IOException {
		Scanner sc = new Scanner(System.in);
		boolean continueModify = true;
		while (continueModify) {
			System.out.println("��������Ҫ���ĵĲ��֣�");
			System.out.println("1:�鼮id  2���鼮����3:�鼮����4���鼮����  5���鼮����״̬");
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
				System.out.println("������Ҫ�µ��鼮id��");
				String newId = sc.next();
				boolean modifyBookDid = bd.modifyBookD(newId, name, type, number, isOut);
				if (modifyBookDid) {
					System.out.println("�޸ĳɹ�");
				} else {
					System.out.println("�޸�ʧ��");
				}
				break;
			case 2:
				System.out.println("�������µ��鼮���ƣ�");
				String newName = sc.next();
				boolean modifyBookDname = bd.modifyBookD(id, newName, type, number, isOut);
				if (modifyBookDname) {
					System.out.println("�޸ĳɹ�");
				} else {
					System.out.println("�޸�ʧ��");
				}
				break;
			case 3:
				System.out.println("������Ҫ�µ��鼮���ͣ�");
				String newType = sc.next();
				boolean modifyBookDtype = bd.modifyBookD(id, name, newType, number, isOut);
				if (modifyBookDtype) {
					System.out.println("�޸ĳɹ�");
				} else {
					System.out.println("�޸�ʧ��");
				}
				break;
			case 4:
				System.out.println("������Ҫ�µ��鼮������");
				int newNumber = sc.nextInt();
				boolean modifyBookDnumber = bd.modifyBookD(id, name, type, newNumber, isOut);
				if (modifyBookDnumber) {
					System.out.println("�޸ĳɹ�");
				} else {
					System.out.println("�޸�ʧ��");
				}
				break;
			case 5:
				System.out.println("������Ҫ�µĽ��������");
				boolean newIsOut = sc.nextBoolean();
				boolean modifyBookDisout = bd.modifyBookD(id, name, type, number, newIsOut);
				if (modifyBookDisout) {
					System.out.println("�޸ĳɹ�");
				} else {
					System.out.println("�޸�ʧ��");
				}
				break;
			default:
				break;

			}
			System.out.println("�Ƿ�����޸ģ�y/n");
			if(sc.next().equals("n")) {
				continueModify=false;
			}
		}
		

	}

	/*
	 * ɾ��ָ���鼮
	 */
	public void deleteBookS() throws FileNotFoundException, IOException {
		System.out.println("������Ҫɾ�����鼮���ƣ�");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		BookDao bd = new BookDao();
		boolean deleteBookD = bd.deleteBookD(name);
		if (deleteBookD) {
			System.out.println("ɾ���ɹ�");
		} else {
			System.out.println("ɾ��ʧ��");
		}
	}
}
