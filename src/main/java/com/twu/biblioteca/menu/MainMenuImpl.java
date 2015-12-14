package com.twu.biblioteca.menu;

import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.utilities.Messages;
import com.twu.biblioteca.utilities.Utilities;

import java.io.PrintStream;
import java.util.List;


/**
 * Created by desiree on 10/12/2015.
 */
public class MainMenuImpl {
    private PrintStream outputStream;
    private Messages messages;

    /**
     * Construct a main menu with access to the library, input streams, output streams, borrow menu and return menu.
     */
    public MainMenuImpl(PrintStream outputStream, Messages messages) {
        this.outputStream = outputStream;
        this.messages = messages;
    }

    /**
     * Display the main menu options.
     */
    public void displayWelcomeMessage() {
        outputStream.print(messages.welcomeMessage());
    }

    public void displayMainMenu() {
        outputStream.print(messages.mainMenuMessage());
        outputStream.print(messages.optionMessage());
    }

    public void displayAvailableBookListing(List<Book> books) {
        outputStream.print(messages.bookListingMessage());
        outputStream.print(Utilities.displayFormattedBookList(books));
    }

    public void displayIncorrectBorrowMessage() {
        outputStream.print(messages.incorrectBorrowMessage());
    }

    public void displayIncorrectReturnMessage() {
        outputStream.print(messages.incorrectReturnMessage());
    }

    public void displayExitMessage() {
        outputStream.print(messages.exitMessage());
    }

    public void displayIncorrectInputMessage() {
        outputStream.print(messages.incorrectInputMessage());
    }
}


