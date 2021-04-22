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
 * 逻辑业务层：用于处理和流水有关的业务
 * 
 * @author 小虫子的小日常
 *
 */
public class WaterInformationService {
	/*
	 * 展示当前用户的流水清单
	 */
	public void showNowUserWaterInformationS() {
		WaterInformationDao wd = new WaterInformationDao();
		List<WaterInformation> nowUserWater = wd.showNowUserWaterInformationD();
		System.out.println("您的流水清单为：");
		for (WaterInformation w : nowUserWater) {
			System.out.println(w.toString());
		}

	}

	/*
	 * 展示当前用户待还的清单
	 */
	public void showNowUserWaterRentS() {
		WaterInformationDao wd = new WaterInformationDao();
		List<WaterInformation> nowUserWaterRent = wd.showNowUserWaterRentD();
		if (nowUserWaterRent.size() != 0) {
			System.out.println("您待还的清单为：");
			for (WaterInformation w : nowUserWaterRent) {
				System.out.println(w.toString());
			}
		}else {
			System.out.println("您没有需要归还的书籍");
		}
	}

	/*
	 * 根据书籍编号找到指定的流水单号
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
	 * 查询流水（租的流水或还的流水）
	 */
	public void look() {
		System.out.println("请输入您想查看的流水类型：1.租的流水   2：还的流水");
		Scanner sc = new Scanner(System.in);
		int choose = sc.nextInt();
		WaterInformationDao wid = new WaterInformationDao();
		switch (choose) {
		case 1:// 租的流水
			List<WaterInformation> rentls = wid.rentls();
			System.out.println("租的流水为：");
			for (WaterInformation w : rentls) {
				System.out.println(w.toString());
			}
			break;
		case 2:// 还的流水
			List<WaterInformation> returnls = wid.returnls();
			System.out.println("还的流水为：");
			for (WaterInformation w : returnls) {
				System.out.println(w.toString());
			}
			break;
		default:
			break;
		}
	}
}
