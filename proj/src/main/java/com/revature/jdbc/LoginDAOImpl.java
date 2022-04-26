package com.revature.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAOImpl implements LoginDAO {

	public void createLogin(Login login) {
		try {
			String command = "INSERT INTO logins (username, passcode) " +
							 "VALUES (?, ?);";
			PreparedStatement st = ConnectionManager.getConnection()	
													.prepareStatement(command);
			st.setString(1, login.getUsername());
			st.setString(2, login.getPassword());
			st.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		} // end try-catch
		
	} // end createLogin()
	
	public int login(Login login) throws InvalidLoginException {
		try {
			String query = "SELECT user_id " +
						   "FROM logins " +
						   "WHERE username = ? " +
						   "AND passcode = ?;";
			PreparedStatement st = ConnectionManager.getConnection()
													.prepareStatement(query);
			st.setString(1, login.getUsername());
			st.setString(2, login.getPassword());
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				return rs.getInt("user_id");
			} // end if
			
			throw new InvalidLoginException();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} // end try-catch
		
		return -1;
	} // end checkValidLogin()
/*
	public void deleteLogin(Login login) {
		try {
			String command = "DELETE FROM logins " +
						     "WHERE username = ? " +
						     "AND passcode = ?;";
			PreparedStatement st = ConnectionManager.getConnection()
													.prepareStatement(command);
			st.setString(1, login.getUsername());
			st.setString(2, login.getPassword());
			st.execute();
			System.out.println("Just after execute");
		} catch(SQLException e) {
			e.printStackTrace();
		} // end try-catch
	} // end deleteLogin()

	// returns Login with given username if one exists
*/	// returns null otherwise
/*	public Login getLogin(String username) {
		try {
			String query = "SELECT * FROM logins " +
						   "WHERE username = ?;";
			
			PreparedStatement st = ConnectionManager.getConnection()
													.prepareStatement(query);
			st.setString(1, username);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				Login login = new Login();
				login.setUsername(rs.getString("username"));
				login.setPassword(rs.getString("passcode"));

				return login;
			} // end if
			
			return null;
			
		} catch(SQLException e) {
			e.printStackTrace();
		} // end try-catch
		
		return null;
	} // end getLogin() */
/*
	public void updatePassword(Login login, String newPassword) {
		try {
			try {
				login.checkValidPassword(newPassword);
				
			} catch(InvalidPasswordException e) {
				// IMPLEMENT HANDLING HERE
			} // end try-catch
			
			String command = "UPDATE logins " +
						     "SET passcode = ? " +
						     "WHERE username = ? " +
						     "AND passcode = ?;";
			PreparedStatement st = ConnectionManager.getConnection()
													.prepareStatement(command);
			st.setString(1, newPassword);
			st.setString(2, login.getUsername());
			st.setString(3, login.getPassword());
			st.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} // end try-catch
		
	} // end updatePassword()
*/	
	public void checkUsername(String username) throws UsernameTakenException {
		try {
			String query = "SELECT * FROM logins " +
						   "WHERE username = ?;";
			
			PreparedStatement st = ConnectionManager.getConnection()
													.prepareStatement(query);
			st.setString(1, username);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				throw new UsernameTakenException();
			} // end if
			
		} catch(SQLException e) {
			e.printStackTrace();
		} // end try-catch
	} // end checkUsername()

} // end LoginDAOImpl
