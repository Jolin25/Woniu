package com.woniuxy.multithreading.basic;
//火车站
public class RailwayStationTest {
	public static void main(String[] args) {
		
		Ticket ticket = new Ticket();
		TicketWindow1 t1 = new TicketWindow1(ticket ,1);
		TicketWindow1 t2 = new TicketWindow1(ticket,1);
		TicketWindow1 t3 = new TicketWindow1(ticket,1);
		TicketWindow1 t4 = new TicketWindow1(ticket,1);
		Thread tt1 = new Thread(t1,"窗口1");
		Thread tt2 = new Thread(t2,"窗口2");
		Thread tt3 = new Thread(t3,"窗口3");
		Thread tt4 = new Thread(t4,"窗口4");
		tt1.start();
		tt2.start();
		tt3.start();
		tt4.start();
	}
}
