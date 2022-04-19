package com.revature.proj;

public class BankAccount {
	private static int uniqueInt = 0;
	private int acctNum;
	private double balance;
	
	public BankAccount() {
		acctNum = ++uniqueInt;
		this.balance = 0.0;
	}
	
	public BankAccount(double balance) {
		acctNum = ++uniqueInt;
		this.balance = balance;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public int getAcctNum() {
		return this.acctNum;
	}
	
	// returns true if withdraw was successful
	// returns false otherwise
	public boolean withdraw(double amount) {
		if(amount < balance) {
			balance -= amount;
			return true;
		}
		
		return false;
	}
	
	// returns true if deposit was successful
	// returns false otherwise
	public boolean deposit(double amount) {
		if(amount > 0) {
			balance += amount;
			return true;
		}
		
		return false;
	}
	
	// returns true if transfer was successful
	// returns false otherwise
	public boolean transfer(BankAccount other) {
		/* I don't actually know how I'm
		   going to code this */
		return false;
	}
	
	/* implement once we connect the database
	public void getStatement() {
		
	} */
}
