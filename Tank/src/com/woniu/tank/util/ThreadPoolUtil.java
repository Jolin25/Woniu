package com.woniu.tank.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * �̳߳���
 * 
 * @author С���ӵ�С�ճ�
 *
 */
public class ThreadPoolUtil {
	//�����ӵ��߳�
	public static ExecutorService bulletPool = Executors.newCachedThreadPool();
	//����npc�߳�,���ͬʱ����3�����˳���
	public static ExecutorService npcPool = Executors.newFixedThreadPool(3);
}
