package com.woniu.tank.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池类
 * 
 * @author 小虫子的小日常
 *
 */
public class ThreadPoolUtil {
	//处理子单线程
	public static ExecutorService bulletPool = Executors.newCachedThreadPool();
	//处理npc线程,最多同时允许3个敌人出现
	public static ExecutorService npcPool = Executors.newFixedThreadPool(3);
}
