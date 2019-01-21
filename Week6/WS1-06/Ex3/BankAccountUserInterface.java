/**
 *  The BankAccountUserInterface describes a class that is a
 *  rudimentary class to provide internet banking. The class itself is
 *  to be abstract, that is, objects cannot directly be constructed,
 *  but only via its sub-classes (BankAccountStandardUser and
 *  BankAccountAdministrator). Users are characterized by three
 *  fields, their username, their password, and a boolean variable
 *  that holds whether a user is logged in.
 *
 *  @version 2018-11-04
 *  @author  Manfred Kerber
 */

public interface BankAccountUserInterface {

    /**
     *  We require in each sub-class the existence of a login method.
     *  @param password The password provided that will be compared to
     *  the password stored on the system, i.e., the value of the
     *  field variable.
     */
    public void login(String password);

    /**
     *  The internet user is no longer logged in, indicated by the
     *  loggedIn variable set to false.
     */
    public void logout();

    /**
     * We want to make use of a getter method to return the
     * password. However, as a minimal protection mechanism we want to
     * make the getter private. As such we cannot specify it in the
     * interface, since it will not be accessible from the outside.
     */

    /**
     * The method checks whether a provided password is correct.
     * @param password A password string that is to be compared to the
     * stored password.
     * @return true if the provided password is equal to the stored
     * password, false else.
     */
    public boolean passwordCorrect(String password);

    /**
     *  Setter for the password.
     *  @param password The new password.
     */
    public void setPassword(String password);

    /**
     *  Getter to check whether a user is logged in.
     *  @return true if the user is looged in, false else.
     */
    public boolean getLoggedIn();

    /**
     *  setter for loggedIn
     *  @param loggedIn New value for the variable loggedIn
     */
    public void setLoggedIn(boolean loggedIn);
}
