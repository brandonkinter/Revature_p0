package com.revature.jdbc;

public interface LoginDAO {
	public void createLogin(Login login);
	
	//public Login getLogin(String username);
	
	//public int getUserID(Login login);
	
	public int login(Login login) throws InvalidLoginException;
	
	//public void deleteLogin(Login login);
	
	//public void updatePassword(Login login, String newPassword);
	
	public void checkUsername(String username) throws UsernameTakenException;
}
