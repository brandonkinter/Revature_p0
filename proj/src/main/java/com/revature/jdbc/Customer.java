package com.revature.jdbc;

import java.util.ArrayList;

public class Customer extends User {
	
	private static CustomerDAO customerDAO = new CustomerDAOImpl();
	private static BankAccountDAO accountDAO = new BankAccountDAOImpl();
	
	private ArrayList<BankAccount> accounts;
	
	public Customer(int userID) {
		this.userID = userID;
		accounts = accountDAO.getBankAccounts(this.userID);
	}
	
	public void createCustomer() {
		customerDAO.createCustomer(this);
	}
	
	public int getUserID() {
		return this.userID;
	}
	
	public ArrayList<BankAccount> getAccounts() {
		return this.accounts;
	}
	
	public BankAccount getAccount(int acctNum) {
		for(BankAccount i : accounts) {
			if(i.getAcctNum() == acctNum)
				return i;
		}
		return null;
	}
	
	public void displayMenu() {
		System.out.println("Welcome, " );//+ this.username + "!\n");
		System.out.println("      SELECT AN OPTION");
		System.out.println("----------------------------\n");
		System.out.println("1. Deposit to an account\n");
		System.out.println("2. Withdraw from an account\n");
		System.out.println("3. Transfer between accounts\n");
		System.out.println("4. Apply for a new account\n");
	}

	@Override
	public String toString() {
		return "" + this.getUserID() + accounts;
	}
	
	
}
