package com.woniuxy.exception.basic;
/*
 * ������
 */
public class Bank {
	double balance;
	double addMoney;
	public Bank() {
	}
	public Bank(double addMoney) {
		this.addMoney = addMoney;
		this.balance += addMoney;
	}
	public void withDraw(double dMount) {
		if (dMount < 0) {    
			try {
				throw new NagativeFoundsException();
			} catch (NagativeFoundsException e) {
			
				System.out.println(e.getMessage());
			}
			
		}
		if (dMount > this.balance) {
			try {
				throw new InsufficientFoundsException("����");
			} catch (InsufficientFoundsException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
