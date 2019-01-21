public class BankAccountUser implements BankAccountUserInterface{
	
	String username;
	String password;
	boolean loggedIn;
	
	public BankAccountUser(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	/**
     *  We require in each sub-class the existence of a login method.
     *  @param password The password provided that will be compared to
     *  the password stored on the system, i.e., the value of the
     *  field variable.
     */
    public void login(String password) {
    	if (this.passwordCorrect(password)) {
    		this.loggedIn = true;
    	} else {
    		this.loggedIn = false;
    		printWrongPassword();
    	}
    }
    
    /**
     *  In order to print message when happen wrong password
     */
    public void printWrongPassword() {
		System.out.println("The password you entered was not recognized.\n");
	}

    /**
     *  The internet user is no longer logged in, indicated by the
     *  loggedIn variable set to false.
     */
    public void logout() {
    	this.loggedIn = false;
    }
    
    /**
     * The method checks whether a provided password is correct.
     * @param password A password string that is to be compared to the
     * stored password.
     * @return true if the provided password is equal to the stored
     * password, false else.
     */
    public boolean passwordCorrect(String password) {
    	return this.password == password ? true : false;
    }

    /**
     *  Setter for the password.
     *  @param password The new password.
     */
    public void setPassword(String password) {
    	this.password = password;
    }

    /**
     *  Getter to check whether a user is logged in.
     *  @return true if the user is looged in, false else.
     */
    public boolean getLoggedIn() {
    	return (loggedIn) ? true : false;
    }

    /**
     *  setter for loggedIn
     *  @param loggedIn New value for the variable loggedIn
     */
    public void setLoggedIn(boolean loggedIn) {
    	this.loggedIn = loggedIn;
    }
	
}

