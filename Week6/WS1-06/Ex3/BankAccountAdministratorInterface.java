/**
 *  The interface describes a class that is to represent an
 *  administrator user of internet banking and is to be a sub-class of
 *  the class BankAccountUser. It has to have the additional field
 *  variable bankAccountUsers in which the bank account users are
 *  stored who are in the responsibility of the administrator.
 *
 *  @version 2018-11-04
 *  @author Manfred Kerber
 */

public interface BankAccountAdministratorInterface {

    /**
     *  Method for an adminstrator to log by providing a password. It
     *  is checked whether the password provided is correct.
     *  @param password The password provided for the login; this is
     *  to be compared to the password stored on the system.
     */
    public void login(String password);

    /**
     *  Add a user to the list of all users who are in the
     *  responsibility of the administrator.
     *  @param user The user to be added to the responsibility of the
     *  adminstrator.
     */
    public void addUser(BankAccountUser user);

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
    public void resetAccount(BankAccountUser bankAccountUser, String password);
}
