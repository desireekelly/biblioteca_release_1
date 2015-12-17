package com.twu.biblioteca.view;

/**
 * ReturnMenu interface.
 * ReturnMenu is responsible for the ReturnMenu display.
 *
 * @author Desiree Kelly
 * @version 1.0
 */
public interface ReturnMenu {
    void displayReturnMenu();

    void displayBorrowedBookListing(String books);

    void displayIncorrectOptionMessage();

    void displayIncorrectReturnMessage();

    void displayInputMismatchExceptionMessage();

    void callReturnMenu();

    String getReturnThankYouMessage();
}