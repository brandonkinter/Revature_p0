package com.revature.proj;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class DriverTest {

		BankAccount acct = new BankAccount(100.00), acctTwo = new BankAccount();
		
		@Test
		public void testDeposit() {
			acct.deposit(50.50);
			assertEquals(150.50, acct.getBalance());
			assertFalse(acct.deposit(-10.00));
		}
		
		@Test
		public void testWithdraw() {
			acct.withdraw(99.00);
			assertEquals(1.00, acct.getBalance());
			assertFalse(acct.withdraw(100.00));
		}
		
		@Test
		public void testAcctNum() {
			assertEquals(1, acct.getAcctNum());
			assertEquals(2, acctTwo.getAcctNum());
		}
		
}
