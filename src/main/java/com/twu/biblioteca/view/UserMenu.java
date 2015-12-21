package com.twu.biblioteca.view;

/**
 * UserMenu interface.
 * UserMenu is responsible for the UserMenu display.
 *
 * @author Desiree Kelly
 * @version 2.0
 */
public interface UserMenu {

    void login();

    void displayCustomerMenu();

    void displayLibrarianMenu();

    void displayIncorrectOptionMessage();

    void displayInputMismatchExceptionMessage();

    void displayLibraryNumberMessage();

    void displayPasswordMessage();

    void displayLoginMessage();

    void displayIncorrectLoginMessage();

    void displayCorrectLoginMessage();

    void displayLogoutMessage();

    void displayCustomerInformation(String user);

    void displayUserName(String user);

    void displayIncorrectBooksCheckedOutByCustomersMessage();

    void displayBooksCheckedOutByCustomers(String list);
}