package com.woniuxy.library.dao;

import java.util.ArrayList;
import java.util.List;

import com.woniuxy.library.dao.po.WaterInformation;
import com.woniuxy.library.database.Database;

/**
 * 流水数据交互层：用于处理和流水有关的数据交互
 * @author 小虫子的小日常
 *
 */
public class WaterInformationDao {
	/*
	 * 展示当前用户的流水清单
	 */
	public List<WaterInformation> showNowUserWaterInformationD() {
		List<WaterInformation> nowUserWater = new ArrayList<WaterInformation>();
		for(int i =0;i<Database.waterInfomations.size();i++) {
			WaterInformation w = Database.waterInfomations.get(i);
			if(Database.nowUser.getName().equals(w.getUserName())) {
				nowUserWater.add(w);//查找到当前用户的流水清单后，添加到该集合中
			}
		}
		return nowUserWater;

	}
	/*
	 * 展示当前用户待还的清单
	 */
	public List<WaterInformation> showNowUserWaterRentD() {
		List<WaterInformation> nowUserWaterRent = new ArrayList<WaterInformation>();
		for(int i =0;i<Database.waterInfomations.size();i++) {
			WaterInformation w = Database.waterInfomations.get(i);
			if(Database.nowUser.getName().equals(w.getUserName())&&w.getIn()==null) {
				nowUserWaterRent.add(w);//查找到当前用户租的流水清单后，添加到该集合中
			}
		}
		return nowUserWaterRent;

	}
	/*
	 * 展示租的流水
	 */
	public List<WaterInformation> rentls() {
		List<WaterInformation> rentls = new ArrayList<WaterInformation>();
		for(int i =0;i<Database.waterInfomations.size();i++) {
			WaterInformation w = Database.waterInfomations.get(i);
			if(w.getIn()==null) {
				rentls.add(w);//查找到租的流水清单后，添加到该集合中
			}
		}
		return rentls;
	}
	/*
	 * 展示还的流水
	 */
	public List<WaterInformation> returnls() {
		List<WaterInformation> returnls = new ArrayList<WaterInformation>();
		for(int i =0;i<Database.waterInfomations.size();i++) {
			WaterInformation w = Database.waterInfomations.get(i);
			if(w.getIn()!=null) {
				returnls.add(w);//查找到还的流水清单后，添加到该集合中
			}
		}
		return returnls;
	}
}
