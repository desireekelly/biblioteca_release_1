package com.twu.biblioteca.menu;

/**
 * Created by desiree on 15/12/2015.
 */
public interface ReturnMenu {
    void displayReturnMenu();

    void displayBorrowedBookListing(String books);

    void displayIncorrectInputMessage();

    void displayReturnThankYouMessage();

    void displayBookToReturn(String book);

    void displayIncorrectReturnMessage();

    void displayReturnExceptionMessage(String exception);

    void displayInputMismatchExceptionMessage();
}
