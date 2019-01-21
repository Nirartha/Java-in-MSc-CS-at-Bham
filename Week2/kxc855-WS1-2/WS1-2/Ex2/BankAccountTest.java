import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {

	private BankAccount Case1;
	private BankAccount Case2;
	
	@Before
	public void setup() {
		
		Case1 = new BankAccount(54, 100, 20);
		Case2 = new BankAccount(40, 568, 98);
		
	}
	
	@Test
	public void test1_getAccountno() {
		int expected = 54;
		int actual = Case1.getAccountNumber();
		assertEquals(expected, actual);
	}

	@Test
	public void test2_getBalance1() {
		int expected = 80;
		int actual = Case1.getBalance();
		assertEquals(expected, actual);
	}
	
	@Test
	public void test3_getBalance2() {
		int expected = 470;
		int actual = Case2.getBalance();
		assertEquals(expected, actual);
	}

	@Test
	public void test4_selfsetBalance1() {
		Case2.setBalance(1593);
		int expected = 1593;
		int actual = Case2.getBalance();
		assertEquals(expected, actual);
	}

	@Test
	public void test5_selfsetBalance() {
		Case1 = new BankAccount(1, 0, 50);
		Case1.setBalance(1500);
		int expected = 1500;
		int actual = Case1.getBalance();
		assertEquals(expected, actual);
	}

}
