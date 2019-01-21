/**
 *  Kuanyow Chen
 *  1756755
 */

public class BankAccount {

	private int accountNumber;
	private int balance;
	private int setupFee;

	/**
     *  Getter for the accountNumber.
     *  @return The accountNumber of the bank account is returned.
     */
	public int getAccountNumber(){
		return accountNumber;
	}

	/**
     *  Getter for the setupFee.
     *  @return The setupFee of the bank account is returned.
     */
	public int getSetupFee() {
		return setupFee;
	}

	/**
     *  Getter for the balance.
     *  @return The balance of the bank account is returned.
     */ 
	public int getBalance() {
		return balance;
	}

	/**
     *  Setter for the balance. The balance of the bank account is updated.
     *  @param balance The new balance of the updated bank account.
     */ 
	public void setBalance(int balance) {
		this.balance = balance;
	}

	/**
     * @return A human readable description of the bank account in form
     *     of the three field variables specifying it.
     */ 
	public String toString() {
		return "Your account number is \u00a3" + Integer.toString(getAccountNumber()) + ", balance is \u00a3" + Integer.toString(getBalance()) + " and be charged \u00a3" + Integer.toString(getSetupFee());
	}

	/**
     *  @param accountNumber The accountNumber of the bank account.
     *  @param initialDeposit The initialDeposit of the bank account.
     *  @param setupFee The setupFee of the bank account.
     */
	public BankAccount(int accountNumber, int initialDeposit, int setupFee) {
		this.accountNumber = accountNumber;
		this.setupFee = setupFee;
		setBalance(initialDeposit);
		this.balance = initialDeposit - this.setupFee;
	}

	/*
     *  main method with a test of the create the new BankAccount and
     *  toString method.
     */
	public static void main(String[] args) {
		BankAccount maryBankAccount = new BankAccount(54, 100, 20);
		System.out.println(maryBankAccount);
	}
	
}