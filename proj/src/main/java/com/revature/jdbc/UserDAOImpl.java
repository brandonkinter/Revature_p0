package com.revature.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl {
	
	
	
	public User getUser(String username) {
		try {
			String query = "SELECT * FROM users " +
						   "WHERE username = ?;";
			PreparedStatement st = ConnectionManager.getConnection()
												    .prepareStatement(query);
			st.setString(1, username);
			ResultSet rs = st.executeQuery();
			
			switch(rs.getString("user_role")) {
				case "customer":
					return new Customer(rs.getString("username"),
									    rs.getString("email"));
				case "employee":
					return new Employee(rs.getString("username"),
									    rs.getString("email"));
				case "admin":
					return new Admin(rs.getString("username"),
									 rs.getString("email"));
			} // end switch
			return null;
		} catch(SQLException e) {
			e.printStackTrace();
		} // end try-catch
		return null;
	} // end getUser()
	
	
}
