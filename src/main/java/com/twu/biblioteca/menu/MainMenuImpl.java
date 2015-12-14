package com.twu.biblioteca.menu;


import com.twu.biblioteca.utilities.Messages;

import java.io.PrintStream;


/**
 * Created by desiree on 10/12/2015.
 */
public class MainMenuImpl {
    private PrintStream outputStream;
    private Messages messages;
    private BorrowMenuImpl borrowMenu;
    private ReturnMenuImpl returnMenu;

    /**
     * Construct a main menu with access to the library, input streams, output streams, borrow menu and return menu.
     */
    public MainMenuImpl(PrintStream outputStream, Messages messages, BorrowMenuImpl borrowMenu, ReturnMenuImpl returnMenu) {
        this.outputStream = outputStream;
        this.messages = messages;
        this.borrowMenu = borrowMenu;
        this.returnMenu = returnMenu;
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

    public void displayBookListing(String books) {
        outputStream.print(messages.bookListingMessage());
        outputStream.print(books);
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


