import java.util.ArrayList;

public class BankAccountAdministrator extends BankAccountUser implements BankAccountAdministratorInterface {
	
	public ArrayList<BankAccountUser> BankAccountUsers;
	
	public BankAccountAdministrator (String username, String password) {
		super(username, password);
	}
	
	/**
     *  Method for an adminstrator to log by providing a password. It
     *  is checked whether the password provided is correct.
     *  @param password The password provided for the login; this is
     *  to be compared to the password stored on the system.
     */
	public void login(String password) {
		if (this.passwordCorrect(password)) {
			this.loggedIn = true;
		} else {
			this.loggedIn = false;
		}
	}
	
	
	/**
     *  Add a user to the list of all users who are in the
     *  responsibility of the administrator.
     *  @param user The user to be added to the responsibility of the
     *  adminstrator.
     */
    public void addUser(BankAccountUser user) {
    	if (loggedIn) {
    		BankAccountUsers = new ArrayList<BankAccountUser>();
        	BankAccountUsers.add(user);
    	}
    }

    /**
     *  If an account can no longer be used, since either the user has
     *  forgotten their password or in case of a standard user has
     *  entered the password incorrectly too often the administrator
     *  can reset the account by setting a new password and resetting
     *  the number of failed login attempts to zero.
     *  @param bankAccountUser The bank account user for whom the
     *  account is to be reset.
     *  @param password The new password for the account that is to be
     *  reset.
     */
    public void resetAccount(BankAccountUser bankAccountUser, String password) {
    	if (loggedIn) {
    		bankAccountUser.setPassword(password);
    	}
    }
	
}
