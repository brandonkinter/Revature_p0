package com.revature.jdbc;

public abstract class User {
	protected int userID;
	
	public abstract void displayMenu();
	
	public void displayPersonalInfo() {
		System.out.println("username: " + this.userID + "\n");
	}
	
	/*	protected void updatePassword(String newPassword) {
		LoginDAO loginDAO = new LoginDAOImpl();
		Login login = loginDAO.getLogin(this.username);
		login.checkValidPassword(newPassword);
		
	} */
}