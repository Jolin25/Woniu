package com.woniuxy.multithreading.basic;
//��Ʊ����
public class TicketWindow2 implements Runnable {
	Ticket ticket;
	int number;//��Ʊ��
	public TicketWindow2(Ticket ticket,int number) {
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
