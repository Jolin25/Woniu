package com.woniuxy.multithreading.basic;
//��վ
public class RailwayStationTest {
	public static void main(String[] args) {
		
		Ticket ticket = new Ticket();
		TicketWindow1 t1 = new TicketWindow1(ticket ,1);
		TicketWindow1 t2 = new TicketWindow1(ticket,1);
		TicketWindow1 t3 = new TicketWindow1(ticket,1);
		TicketWindow1 t4 = new TicketWindow1(ticket,1);
		Thread tt1 = new Thread(t1,"����1");
		Thread tt2 = new Thread(t2,"����2");
		Thread tt3 = new Thread(t3,"����3");
		Thread tt4 = new Thread(t4,"����4");
		tt1.start();
		tt2.start();
		tt3.start();
		tt4.start();
	}
}
