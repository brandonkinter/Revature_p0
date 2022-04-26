package com.revature.jdbc;

import java.util.ArrayList;

public interface BankAccountDAO {
	public BankAccount getBankAccount(int acctNum);
	
	public ArrayList<BankAccount> getBankAccounts(int userID);
	
	public void updateBalance(long amount, int acctNum);
}
