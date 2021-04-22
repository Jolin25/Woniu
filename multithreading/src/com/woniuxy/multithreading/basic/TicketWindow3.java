package com.woniuxy.multithreading.basic;
//ÊÛÆ±´°¿Ú
public class TicketWindow3 implements Runnable {
	Ticket ticket;
	int number;//¹ºÆ±Êý
	public TicketWindow3(Ticket ticket,int number) {
		this.ticket = ticket;
		this.number = number;
	}
	@Override
	public void run() {
		while (true) {
		boolean hasTicket = ticket.buy(number);
	
			if (!hasTicket) {
				break;
			}
		}
	}
}
