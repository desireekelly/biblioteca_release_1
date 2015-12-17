package com.twu.biblioteca.view;

/**
 * ReturnMenu interface.
 * ReturnMenu is responsible for the ReturnMenu display.
 *
 * @author Desiree Kelly
 * @version 1.0
 */
public interface ReturnMenu {

    void displayBorrowedBookListing(String books);

    void displayIncorrectOptionMessage();

    void displayIncorrectBookReturnMessage();

    void displayInputMismatchExceptionMessage();

    void displayIncorrectMovieReturnMessage();

    String getReturnThankYouMessage();

    void displayBookReturnMenu();

    void displayMovieReturnMenu();

    void displayBorrowedMovieListing(String movies);

    void callBookReturnMenu();

    void callMovieReturnMenu();
}