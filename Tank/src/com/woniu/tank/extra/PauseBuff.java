package com.woniu.tank.extra;

import java.util.Calendar;
import java.util.Date;

import com.woniu.tank.map.Npc;
import com.woniu.tank.ui.GamePanel;

/**
 * ��ͣbuff���Ե��Ժ�з�̹��ȫ����ͣ5�룬��������������~~~~~ �̳�buff���࣬ʵ��buffЧ������
 * ʵ�ֹ��̣����ҷ�̹�˵�move�����м�⵽λ����buff�ϣ�������buffЧ�����������з�̹��
 * ����ͣ״̬��Ϊtrue��ʹ��������run�����в�������move��attack��ͬʱ��¼��ʱ�䡣�ڵз�̹������
 * ��̹�˱���ͣ�ˣ���������buff��������ʱ5��󣬸��ĵз�̹�˵���ͣ״̬��
 * 
 * 
 * @author С���ӵ�С�ճ�
 *
 */
public class PauseBuff extends Buff {

	public PauseBuff(int x, int y, String type) {
		super(x, y, "pauseBuff");
	}

	public static int buffOn;// buff��ʼ��ʱ��
	/*
	 * buffЧ��
	 */

	@Override
	public void buffEffects() {
		for (int i = 0; i < GamePanel.npcs.size(); i++) {
			Npc npc = GamePanel.npcs.get(i);
			npc.isPauseed = true;// ���ĵз�̹�˵�״̬
			// ��¼����ͣʱ��ʱ��
			Calendar ca = Calendar.getInstance();
			buffOn = ca.get(Calendar.SECOND);
			// System.out.println(buffOn);// Ϊʲô�ᱻ���3�أ�����

		}
	}

}
