package com.twu.biblioteca.menu;

import com.twu.biblioteca.book.Book;

import java.util.List;

/**
 * Created by desiree on 15/12/2015.
 */
public interface ReturnMenu {
    void displayReturnMenu();

    void displayBorrowedBookListing(List<Book> books);

    void displayIncorrectInputMessage();

    void displayReturnThankYouMessage();

    void displayBookToReturn(String book);

    void displayIncorrectReturnMessage();

    void displayReturnExceptionMessage(String exception);

    void displayInputMismatchExceptionMessage();
}
