package com.woniuxy.basic.abstract1;
/*
 * 6、根据如下设计接口，设计实现类：
    1）银行标准（余额，存钱，取钱）
    2）工商银行执行银行标准；
    3）建筑标准（开门、关门）
    4）中国银行执行银行标准、建筑标准；
 */
public interface Building {
	void close();
	void open();
}
