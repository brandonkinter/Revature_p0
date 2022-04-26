package com.revature.jdbc;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Login login;
		Customer cust = null;
		
		display();
		String loginBranch = scan.next().toLowerCase();
		String username, password;
		boolean noAccount = true;
			switch(loginBranch) {
				case "login":
					while(noAccount) {
						System.out.print("Please enter your username: ");
						username = scan.next();
						System.out.print("Please enter your password: ");
						password = scan.next();
						login = new Login(username, password);
						try {
							cust = new Customer(login.login());
							noAccount = false;
						} catch (InvalidLoginException e) {
							System.out.println("Invalid login! Try again. \n");
						}
					}
					break;
				case "signup":
					while(noAccount) {
						System.out.print("Please pick a username. (Note: username " +
										 "must be at least 6 characters): ");
						username = scan.next();
						System.out.print("\nPlease pick a password. (Note: password " +
										 "must be at least 8 characters and \n must " +
										 "contain a number, lowercase letter,  " +
										 "uppercase letter, and a special \n " +
										 "character in the following list: " +
										 "!, ?, #, $, %, &, ^,* , @, +): ");
						password = scan.next();
						login = new Login(username, password);
						try {
							login.signUp();
							cust = new Customer(login.login());
							cust.createCustomer();
							noAccount = false;
						} catch(InvalidUsernameException e) {
							System.out.println("Invalid username! Try again.\n");
						} catch(UsernameTakenException e) {
							System.out.println("Username taken! Try again. \n");
						} catch(InvalidPasswordException e) {
							System.out.println("Invalid password! Try again. \n");
						} catch(InvalidLoginException e) {}
					}
					
					System.out.println("Profile successfully created! ");// +
									   //"Please log in with your credentials.");
					break;				
				case "employee":
					break;
				default:
			}
		System.out.println("CUSTOMER: " + cust);
		scan.close();
	}
	
	private static void display() {
		System.out.println("Welcome to Kitty Bank!\n");
		System.out.println("If you already have an account " +
						   "with us, please enter 'login'.");
		System.out.println("If you haven't yet started an account " +
						   "with us, please enter 'signup'.");
		System.out.println("If you're an employee, please enter 'employee'.");
	}
}
