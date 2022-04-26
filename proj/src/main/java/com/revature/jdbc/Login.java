package com.revature.jdbc;

public class Login {
	private String username;
	private String password;
	private static LoginDAO loginDAO = new LoginDAOImpl();
	
	public Login() {
		this.username = "";
		this.password = "";
	}
	
	public Login(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	private void checkValidUsername(String username) 
								throws InvalidUsernameException, 
								       UsernameTakenException {		
		// if username is too short
		if(username.length() < 6)
			throw new InvalidUsernameException();
		loginDAO.checkUsername(username);
	}
	
	protected void checkValidPassword(String password) 
								throws InvalidPasswordException {
		// strings to check against
		String special = "!?#$%&^*@+",
				  nums = "0123456789",
			   letters = "abcdefghijklmnopqrstuvwxyz",
			capLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		// initialize necessary containers to false
		boolean hasSpecial, hasNum, hasLetter, hasCapLetter;
		hasSpecial = hasNum = hasLetter = hasCapLetter = false;
		
		int length = password.length();
		
		// if password too short
		if(length < 8) 
			throw new InvalidPasswordException();
		
		// check password for necessary characters
		for(int i = 0; i < length; ++i) {
			char ch = password.charAt(i);
			
			if(special.indexOf(ch) > -1) // if password contains special char
				hasSpecial = true;
			else if(nums.indexOf(ch) > -1) // if it contains number
				hasNum = true;
			else if(letters.indexOf(ch) > -1) // if it contains letter
				hasLetter = true;
			else if(capLetters.indexOf(ch) > -1) // if it contains capital
				hasCapLetter = true;
		} // end for
		
		// if password is missing a necessary character
		if(!(hasSpecial && hasNum && hasLetter && hasCapLetter))
			throw new InvalidPasswordException();
	}
	
	public int login() throws InvalidLoginException {
		return loginDAO.login(this);
	}

	public void signUp() throws InvalidUsernameException,
								UsernameTakenException,
								InvalidPasswordException {
		this.checkValidUsername(this.username);
		this.checkValidPassword(this.password);
		loginDAO.createLogin(this);
	}
	
	@Override
	public String toString() {
		return "username = " + username + "\n" + "password = " + password;
	}
	
}
