public class BankAccountStandardUser extends BankAccountUser implements BankAccountStandardUserInterface  {
	
	BankAccount bankAccount;
	int loginAttempts;
	
	public BankAccountStandardUser(String username, String password, BankAccount bankAccount) {
		super(username, password);
		this.bankAccount = bankAccount;
	}

	/**
     *  Getter for the bankAccout.
     *  @return The bankAccount associated with the standard user.
     */
    public BankAccount getBankAccount() {
    	return bankAccount;
    }

    /**
     *  Method for a user to log in to internet banking by providing a
     *  password. It is first checked whether the account is still
     *  active (that is, not too many failed login attempts were made
     *  in the past) and secondly whether the password provided is
     *  correct. In case of a correct login the number of login
     *  attempts is reset to 0, else increased by 1.
     *  @param password The password provided for the login; this is
     *  to be compared to the password stored on the system.
     */
    public void login(String password) {
    	if (this.password.equals(password)) {
    		this.resetLoginAttempts();
    		this.loggedIn = true;
    	} else {
    		if (this.loginAttempts < 3) {
    			this.loginAttempts ++;
    		}
    		this.loggedIn = false;
    	}
    }

    /**
     *  Getter for the number of (failed) login attempts.
     *  @return The number of (failed) login attemps since last
     *  successful login or reset.
     */
    public int getLoginAttempts() {
    	return loginAttempts;
    }

    /**
     *  setter for loginAttempts
     *  @param loginAttempts New value for the variable loginAttempts.
     */
    public void setLoginAttempts(int loginAttempts) {
    	this.loginAttempts = loginAttempts;
    }

    /**
     *  The method resets the number of (failed) login attempts to zero.
     */
    public void resetLoginAttempts() {
    	this.loginAttempts = 0;
    }

    /** 
     * The method transfers an amount of money from the this account
     * to the toAccount assumed that the user in logged in, the
     * password is correct (and that the account has sufficient
     * money), else an error message is printed. This is done by
     * calling the corresponding method in the BankAccount class
     * assumed the user is logged in.
     * @param toAccount The account to which the money is to be transferred.
     * @param amount The amount of money to be transferred.
     * @param password The password of the this account.
     */
    public void transferMoney(BankAccount toAccount, long amount, String password) {
    	if (this.bankAccount.checkPassword(password) && (this.loggedIn)) {
    		this.bankAccount.transferMoney(toAccount, amount, password);
    	} else {
    		this.bankAccount.printInsufficientFunds(amount);
    	}
    }

    /** 
     * The method prints the balance assumed that the user is logged in,
     * else a corresponding message.
     */
    public void printBalance() {
    	this.printBalance();
    }

    /** 
     * The method prints a statement if the user is logged in,
     * else a request to first log in is printed.
     */
    public void printStatement() {
    	this.printStatement();
    }

	public boolean getLoggedIn() {
		// TODO Auto-generated method stub
		if (this.loginAttempts == 0 && (this.loggedIn)) {
			return true;
    	} else {
    		return false;
    	}
	}
	
}
