package com.revature.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BankAccountDAOImpl implements BankAccountDAO {
	public BankAccount getBankAccount(int acctNum) {
		try {
			String query = "SELECT * " +
					       "FROM accounts " +
					       "WHERE acct_num = ?;";
			PreparedStatement st = ConnectionManager.getConnection()
													.prepareStatement(query);	
			st.setInt(1, acctNum);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				return new BankAccount(rs.getInt("acct_num"), rs.getLong("balance"));
			} // end if
			
			return null;
		} catch(SQLException e) {
			e.printStackTrace();
		}  // end try-catch
		
		return null;
	} // end getBankAccount()
	
	public ArrayList<BankAccount> getBankAccounts(int userID) {
		try {
			String query = "SELECT accounts.acct_num, accounts.balance " + 
						   "FROM accounts " +
						   "INNER JOIN user_acct_bridge " +
						   "AS uab " +
						   "ON accounts.acct_num = uab.acct_num " +
						   "INNER JOIN users " +
						   "ON users.user_id = uab.user_id " +
						   "WHERE users.user_id = ?;";
			PreparedStatement st = ConnectionManager.getConnection()
													.prepareStatement(query);
			st.setInt(1, userID);
			ResultSet rs = st.executeQuery();
			ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
			
			while(rs.next()) {
				accounts.add(new BankAccount(rs.getInt("acct_num"),
										     rs.getLong("balance")));
			} // end while
			
			return accounts;
		} catch(SQLException e) {
			e.printStackTrace();
		} // end try-catch
		
		return null;		   		
	} // end getBankAccounts()
	
	public void updateBalance(long amount, int acctNum) {
		try {
			String command = "UPDATE accounts " +
							 "SET balance = (" +
							 	"SELECT balance " +
							 	"FROM accounts " +
							 	"WHERE acct_num = ?) + ? " +
							 "WHERE acct_num = ?;";
			PreparedStatement st = ConnectionManager.getConnection()
													.prepareStatement(command);
			st.setInt(1, acctNum);
			st.setLong(2, amount);
			st.setInt(3, acctNum);
			st.execute();
					
		} catch(SQLException e) {
			e.printStackTrace();
		} // end try-catch
		
	} // end updateBalance()
}
