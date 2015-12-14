package com.twu.biblioteca.menu;

import com.twu.biblioteca.book.Book;

import java.util.List;

/**
 * Created by desiree on 15/12/2015.
 */
public interface MainMenu {
    void displayWelcomeMessage();

    void displayMainMenu();

    void displayAvailableBookListing(List<Book> books);

    void displayExitMessage();

    void displayIncorrectInputMessage();

    void displayInputMismatchExceptionMessage();
}
