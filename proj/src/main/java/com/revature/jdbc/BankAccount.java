package com.revature.jdbc;

public class BankAccount {
	
	private int acctNum;
	private long balance;
	private static BankAccountDAO bankAccountDAO = new BankAccountDAOImpl();
	
	@Override
	public String toString() {
		return "BankAccount [acctNum=" + acctNum + ", balance=" + balance + "]";
	}

	public BankAccount(int acctNum, long balance) {
		this.acctNum = acctNum;
		this.balance = balance;
	}
	
	// Getter methods
	public int getAcctNum() {
		return this.acctNum;
	}
	
	public long getBalance() {
		return this.balance;
	}
	
	public void deposit(long amount) {
		bankAccountDAO.updateBalance(amount, this.acctNum);
		balance += amount;
	}
	
	public void withdraw(long amount) {
		bankAccountDAO.updateBalance(-amount, this.acctNum);
		balance -= amount;
	}
	
	public void transfer(long amount, BankAccount target) {
		
	}
	
}
