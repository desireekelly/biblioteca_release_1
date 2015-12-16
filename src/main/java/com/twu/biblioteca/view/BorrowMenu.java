package com.twu.biblioteca.view;

/**
 * BorrowMenu interface.
 * BorrowMenu is responsible for the BorrowMenu display.
 *
 * @author Desiree Kelly
 * @version 1.0
 */
public interface BorrowMenu {
    void displayBookBorrowMenu();

    void displayAvailableBookListing(String books);

    void displayIncorrectInputMessage();

    String getBookBorrowThankYouMessage();

    void displayIncorrectBookBorrowMessage();

    void displayInputMismatchExceptionMessage();

    void callBookBorrowMenu();

    void callMovieBorrowMenu();

    void displayMovieBorrowMenu();

    void displayAvailableMovieListing(String movies);

    String getMovieBorrowThankYouMessage();

    void displayIncorrectMovieBorrowMessage();
}