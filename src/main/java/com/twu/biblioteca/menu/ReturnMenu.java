package com.twu.biblioteca.menu;

/**
 * Created by desiree on 15/12/2015.
 */
public interface ReturnMenu {
    void displayReturnMenu();

    void displayBorrowedBookListing(String books);

    void displayIncorrectInputMessage();

    void displayIncorrectReturnMessage();

    void displayInputMismatchExceptionMessage();

    void callReturnMenu();

    String getReturnThankYouMessage();
}
