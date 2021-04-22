package com.woniu.tank.extra;

import java.util.Calendar;
import java.util.Date;

import com.woniu.tank.map.Npc;
import com.woniu.tank.ui.GamePanel;

/**
 * 暂停buff，吃到以后敌方坦克全部暂停5秒，啊哈哈哈哈哈哈~~~~~ 继承buff父类，实现buff效果方法
 * 实现过程：当我方坦克的move方法中检测到位置在buff上，即调用buff效果方法：将敌方坦克
 * 的暂停状态改为true，使其在它的run方法中不被调用move和attack，同时记录下时间。在敌方坦克类中
 * 当坦克被暂停了，则调用清除buff方法，计时5秒后，更改敌方坦克的暂停状态。
 * 
 * 
 * @author 小虫子的小日常
 *
 */
public class PauseBuff extends Buff {

	public PauseBuff(int x, int y, String type) {
		super(x, y, "pauseBuff");
	}

	public static int buffOn;// buff开始的时间
	/*
	 * buff效果
	 */

	@Override
	public void buffEffects() {
		for (int i = 0; i < GamePanel.npcs.size(); i++) {
			Npc npc = GamePanel.npcs.get(i);
			npc.isPauseed = true;// 更改敌方坦克的状态
			// 记录被暂停时的时间
			Calendar ca = Calendar.getInstance();
			buffOn = ca.get(Calendar.SECOND);
			// System.out.println(buffOn);// 为什么会被输出3回？？？

		}
	}

}
