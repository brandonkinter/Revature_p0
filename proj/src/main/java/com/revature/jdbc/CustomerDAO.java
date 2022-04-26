package com.revature.jdbc;

public interface CustomerDAO {
	public Customer getCustomer(Login login);
	
	public void createCustomer(Customer cust);
}
