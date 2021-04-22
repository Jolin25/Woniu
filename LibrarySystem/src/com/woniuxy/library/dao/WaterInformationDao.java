package com.woniuxy.library.dao;

import java.util.ArrayList;
import java.util.List;

import com.woniuxy.library.dao.po.WaterInformation;
import com.woniuxy.library.database.Database;

/**
 * ��ˮ���ݽ����㣺���ڴ������ˮ�йص����ݽ���
 * @author С���ӵ�С�ճ�
 *
 */
public class WaterInformationDao {
	/*
	 * չʾ��ǰ�û�����ˮ�嵥
	 */
	public List<WaterInformation> showNowUserWaterInformationD() {
		List<WaterInformation> nowUserWater = new ArrayList<WaterInformation>();
		for(int i =0;i<Database.waterInfomations.size();i++) {
			WaterInformation w = Database.waterInfomations.get(i);
			if(Database.nowUser.getName().equals(w.getUserName())) {
				nowUserWater.add(w);//���ҵ���ǰ�û�����ˮ�嵥����ӵ��ü�����
			}
		}
		return nowUserWater;

	}
	/*
	 * չʾ��ǰ�û��������嵥
	 */
	public List<WaterInformation> showNowUserWaterRentD() {
		List<WaterInformation> nowUserWaterRent = new ArrayList<WaterInformation>();
		for(int i =0;i<Database.waterInfomations.size();i++) {
			WaterInformation w = Database.waterInfomations.get(i);
			if(Database.nowUser.getName().equals(w.getUserName())&&w.getIn()==null) {
				nowUserWaterRent.add(w);//���ҵ���ǰ�û������ˮ�嵥����ӵ��ü�����
			}
		}
		return nowUserWaterRent;

	}
	/*
	 * չʾ�����ˮ
	 */
	public List<WaterInformation> rentls() {
		List<WaterInformation> rentls = new ArrayList<WaterInformation>();
		for(int i =0;i<Database.waterInfomations.size();i++) {
			WaterInformation w = Database.waterInfomations.get(i);
			if(w.getIn()==null) {
				rentls.add(w);//���ҵ������ˮ�嵥����ӵ��ü�����
			}
		}
		return rentls;
	}
	/*
	 * չʾ������ˮ
	 */
	public List<WaterInformation> returnls() {
		List<WaterInformation> returnls = new ArrayList<WaterInformation>();
		for(int i =0;i<Database.waterInfomations.size();i++) {
			WaterInformation w = Database.waterInfomations.get(i);
			if(w.getIn()!=null) {
				returnls.add(w);//���ҵ�������ˮ�嵥����ӵ��ü�����
			}
		}
		return returnls;
	}
}
