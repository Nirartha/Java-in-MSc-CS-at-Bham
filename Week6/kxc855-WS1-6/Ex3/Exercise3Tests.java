import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class Exercise3Tests {

	private BankAccountAdministrator boss, chrips;
	private Customer customerDennis, customerIris, customerToby;
	private BankAccount bankAccountDennis, bankAccountIris, bankAccountToby;
	private BankAccountStandardUser Dennis, Iris, Toby;

	@Before
	public void setUp() {
		boss = new BankAccountAdministrator("Sam", "sesameUser");
		chrips = new BankAccountAdministrator("Tim", "poppyUser");
		customerDennis = new Customer("Dennis", "m", "Bham", "0121");
		customerIris = new Customer("Iris", "f", "Bham", "0121");
		customerToby = new Customer("Toby", "x", "Bham", "0121");
		bankAccountDennis = new BankAccount(customerDennis, "test");
		bankAccountIris = new BankAccount(customerIris, "linseed");
		bankAccountToby = new BankAccount(customerToby, "tree");
		Dennis = new BankAccountStandardUser("Dennis", "testUser", bankAccountDennis);
		Iris = new BankAccountStandardUser("Iris", "linseedUser", bankAccountIris);
		Toby = new BankAccountStandardUser("Toby", "treeUser", bankAccountToby);
	}

	// Dennis logs in successfully and transfers some money to Iris's bank account.
	@Test
	public void SuccessfulTransfers() {
		Dennis.login("testUser");

		// expected number of failed login attempts is 0
		int expectedLoginAttempts = 0;
		int actualLoginAttempts = Dennis.getLoginAttempts();

		assertEquals(expectedLoginAttempts, actualLoginAttempts);
		assertTrue(Dennis.getLoggedIn());

                // transfer fails because of insufficient funds
		Dennis.transferMoney(bankAccountIris, 199, "test");

		double expectedBalance = 100;
		double actualBalance = Iris.getBankAccount().getBalance();

		assertEquals(expectedBalance, actualBalance, 0.00001);

                // transfer succeeds
		Dennis.transferMoney(bankAccountIris, 20, "test");
		double expectedBalanceDennis = 80;
		double actualBalanceDennis = Dennis.getBankAccount().getBalance();
		assertEquals(expectedBalanceDennis, actualBalanceDennis, 0.00001);
		double expectedBalanceIris = 120;
		double actualBalanceIris = Iris.getBankAccount().getBalance();
		assertEquals(expectedBalanceIris, actualBalanceIris, 0.00001);
	}

	// Iris makes 1 failed login attempt,
	// logs in using the correct password
	// and logs out. Then Iris tries to transfer some
	// money to Toby's bank account but forgets the password
	@Test
	public void LogoutAndForgetPW() {
		Iris.login("linseeduser");

		int expectedLoginAttempts = 1;
		int actualLoginAttempts = Iris.getLoginAttempts();

		assertEquals(expectedLoginAttempts, actualLoginAttempts);

		assertFalse(Iris.getLoggedIn());

		Iris.login("linseedUser");
		expectedLoginAttempts = 0;
		actualLoginAttempts = Iris.getLoginAttempts();
		assertEquals(expectedLoginAttempts, actualLoginAttempts);
		assertTrue(Iris.getLoggedIn());

		Iris.logout();
		assertFalse(Iris.getLoggedIn());

		Iris.setPassword("linseeedUser");
		Iris.transferMoney(bankAccountToby, 50, "linseed");

		double expectedBalance = 100;
		double actualBalance = Toby.getBankAccount().getBalance();

		assertEquals(expectedBalance, actualBalance, 0.00001);

	}

	// Toby makes 2 failed login attempts and
	// then logs in using the correct password
	@Test
	public void SecondFailedAndLoginCorrectPW() {

		// First failed login attempt
		Toby.login("TREEUser");

		int expectedLoginAttempts = 1;
		int actualLoginAttempts = Toby.getLoginAttempts();

		assertEquals(expectedLoginAttempts, actualLoginAttempts);

		assertFalse(Toby.getLoggedIn());

		// Second failed login attempt
		Toby.login("TReeUser");
		expectedLoginAttempts = 2;
		actualLoginAttempts = Toby.getLoginAttempts();

		assertEquals(expectedLoginAttempts, actualLoginAttempts);
		assertFalse(Toby.getLoggedIn());

		// Third attempt is successful
		Toby.login("treeUser");
		expectedLoginAttempts = 0;
		actualLoginAttempts = Toby.getLoginAttempts();
		assertEquals(expectedLoginAttempts, actualLoginAttempts);
		assertTrue(Toby.getLoggedIn());

	}

	// Dennis makes 4 failed login attempts
	// admin chrips, with login and without login, to reset Dennis's password
	// and Dennis's login attempts to 0.
    	@Test
	public void FourthFailedAndResetPW() {

		// First failed login attempt
		Dennis.login("wehatUser");

		// Second failed login attempt
		Dennis.login("wehatUserS");

		// Third failed login attempt
		Dennis.login("wehatUsers");

		// Fourth failed login attempt
		Dennis.login("weehatUser");
		// Failed login attempts remain 3
		int expectedLoginAttempts = 3;
		int actualLoginAttempts = Dennis.getLoginAttempts();

		assertEquals(expectedLoginAttempts, actualLoginAttempts);
		assertFalse(Dennis.getLoggedIn());
		
		// Administrator tries to reset Dennis's password without logging in
		boss.addUser(Dennis);
		boss.resetAccount(Dennis, "testUser1");

		// Dennis tries to log in again
		Dennis.login("testUser1");

		// login attempts still 3
		expectedLoginAttempts = 3;
		actualLoginAttempts = Dennis.getLoginAttempts();

		assertEquals(expectedLoginAttempts, actualLoginAttempts);
		assertFalse(Dennis.getLoggedIn());
		
		// Administrator resets Dennis's password
		chrips.login("poppyUser");
		chrips.addUser(Dennis);
		chrips.resetAccount(Dennis, "testUser1");

		// Dennis logs in successfully using the new password
		Dennis.login("testUser1");

		expectedLoginAttempts = 0;
		actualLoginAttempts = Dennis.getLoginAttempts();

		assertEquals(expectedLoginAttempts, actualLoginAttempts);
		assertTrue(Dennis.getLoggedIn());

		Dennis.logout();
		assertFalse(Dennis.getLoggedIn());
	}

}
