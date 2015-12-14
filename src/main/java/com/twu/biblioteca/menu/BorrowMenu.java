package com.twu.biblioteca.menu;

import com.twu.biblioteca.book.Book;

import java.util.List;

/**
 * Created by desiree on 15/12/2015.
 */
public interface BorrowMenu {
    void displayBorrowMenu();

    void displayAvailableBookListing(List<Book> books);

    void displayIncorrectInputMessage();

    void displayBorrowThankYouMessage();

    void displayBookToBorrow(String book);

    void displayIncorrectBorrowMessage();

    void displayBorrowExceptionMessage(String exception);

    void displayInputMismatchExceptionMessage();
}
