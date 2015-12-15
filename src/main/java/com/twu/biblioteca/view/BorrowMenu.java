package com.twu.biblioteca.view;

/**
 * BorrowMenu interface.
 * BorrowMenu is responsible for the BorrowMenu display.
 *
 * @author Desiree Kelly
 * @version 1.0
 */
public interface BorrowMenu {
    void displayBorrowMenu();

    void displayAvailableBookListing(String books);

    void displayIncorrectInputMessage();

    String getBorrowThankYouMessage();

    void displayIncorrectBorrowMessage();

    void displayInputMismatchExceptionMessage();

    void callBorrowMenu();
}