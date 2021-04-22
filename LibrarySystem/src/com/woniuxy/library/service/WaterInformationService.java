package com.woniuxy.library.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.woniuxy.library.dao.WaterInformationDao;
import com.woniuxy.library.dao.po.WaterInformation;
import com.woniuxy.library.database.Database;

/**
 * �߼�ҵ��㣺���ڴ������ˮ�йص�ҵ��
 * 
 * @author С���ӵ�С�ճ�
 *
 */
public class WaterInformationService {
	/*
	 * չʾ��ǰ�û�����ˮ�嵥
	 */
	public void showNowUserWaterInformationS() {
		WaterInformationDao wd = new WaterInformationDao();
		List<WaterInformation> nowUserWater = wd.showNowUserWaterInformationD();
		System.out.println("������ˮ�嵥Ϊ��");
		for (WaterInformation w : nowUserWater) {
			System.out.println(w.toString());
		}

	}

	/*
	 * չʾ��ǰ�û��������嵥
	 */
	public void showNowUserWaterRentS() {
		WaterInformationDao wd = new WaterInformationDao();
		List<WaterInformation> nowUserWaterRent = wd.showNowUserWaterRentD();
		if (nowUserWaterRent.size() != 0) {
			System.out.println("���������嵥Ϊ��");
			for (WaterInformation w : nowUserWaterRent) {
				System.out.println(w.toString());
			}
		}else {
			System.out.println("��û����Ҫ�黹���鼮");
		}
	}

	/*
	 * �����鼮����ҵ�ָ������ˮ����
	 */
	public WaterInformation find(String bookId) throws FileNotFoundException, IOException {

		for (int i = 0; i < Database.waterInfomations.size(); i++) {
			WaterInformation w = Database.waterInfomations.get(i);
			if (w.getBookId().equals(bookId)) {

				return w;
			}
		}
		return null;

	}

	/*
	 * ��ѯ��ˮ�������ˮ�򻹵���ˮ��
	 */
	public void look() {
		System.out.println("����������鿴����ˮ���ͣ�1.�����ˮ   2��������ˮ");
		Scanner sc = new Scanner(System.in);
		int choose = sc.nextInt();
		WaterInformationDao wid = new WaterInformationDao();
		switch (choose) {
		case 1:// �����ˮ
			List<WaterInformation> rentls = wid.rentls();
			System.out.println("�����ˮΪ��");
			for (WaterInformation w : rentls) {
				System.out.println(w.toString());
			}
			break;
		case 2:// ������ˮ
			List<WaterInformation> returnls = wid.returnls();
			System.out.println("������ˮΪ��");
			for (WaterInformation w : returnls) {
				System.out.println(w.toString());
			}
			break;
		default:
			break;
		}
	}
}
