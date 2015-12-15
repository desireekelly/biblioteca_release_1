package com.twu.biblioteca.menu;

/**
 * Created by desiree on 15/12/2015.
 */
public interface BorrowMenu {
    void displayBorrowMenu();

    void displayAvailableBookListing(String books);

    void displayIncorrectInputMessage();

    void displayBorrowThankYouMessage();

    void displayBookToBorrow(String book);

    void displayIncorrectBorrowMessage();

    void displayBorrowExceptionMessage(String exception);

    void displayInputMismatchExceptionMessage();
}
