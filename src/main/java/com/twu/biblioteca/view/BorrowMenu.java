package com.twu.biblioteca.view;

/**
 * Created by desiree on 15/12/2015.
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
