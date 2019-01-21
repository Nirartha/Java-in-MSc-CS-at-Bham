/**
 *  The interface is to a description of a class to deal with a
 *  standard user of internet banking. The class is to be a sub-class
 *  of the class BankAccountUser. It is to have the additional field
 *  variables bankAccount - in which the associated BankAccount can be
 *  found - and a counter that counts failed login attempts before one
 *  succeeds. Standard users have only a fixed number of login
 *  attempts. After more than that number (stored in the static final
 *  variable MAXIMAL_LOGIN_ATTEMPTS, set to be 3) the accounts needs
 *  to be reset before further login attempts can be successful.
 *
 *  @version 2018-11-04
 *  @author Manfred Kerber
 */

public interface BankAccountStandardUserInterface {

    /**
     *  Getter for the bankAccout.
     *  @return The bankAccount associated with the standard user.
     */
    public BankAccount getBankAccount();

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
    public void login(String password);

    /**
     *  Getter for the number of (failed) login attempts.
     *  @return The number of (failed) login attemps since last
     *  successful login or reset.
     */
    public int getLoginAttempts();

    /**
     *  setter for loginAttempts
     *  @param loginAttempts New value for the variable loginAttempts.
     */
    public void setLoginAttempts(int loginAttempts);

    /**
     *  The method resets the number of (failed) login attempts to zero.
     */
    public void resetLoginAttempts();

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
    public void transferMoney(BankAccount toAccount, long amount,
                              String password);

    /** 
     * The method prints the balance assumed that the user is logged in,
     * else a corresponding message.
     */
    public void printBalance();

    /** 
     * The method prints a statement if the user is logged in,
     * else a request to first log in is printed.
     */
    public void printStatement();
}
