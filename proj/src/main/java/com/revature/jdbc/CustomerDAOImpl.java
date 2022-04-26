package com.revature.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDAOImpl implements CustomerDAO {
	public Customer getCustomer(Login login) {
		
		
		
		
		return new Customer(-1);
	}
	
	public void createCustomer(Customer cust) {
		try {
			String command = "INSERT INTO users " +
							 "VALUES (?, ?);";
			PreparedStatement st = ConnectionManager.getConnection()
													.prepareStatement(command);
			st.setInt(1, cust.getUserID());
			st.setString(2, "customer");
			st.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
