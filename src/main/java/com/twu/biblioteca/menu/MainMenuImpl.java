package com.twu.biblioteca.menu;

import com.twu.biblioteca.messages.Messages;

import java.io.PrintStream;

/**
 * Created by desiree on 10/12/2015.
 */
public class MainMenuImpl implements MainMenu {
    private PrintStream outputStream;
    private Messages messages;

    public MainMenuImpl(PrintStream outputStream, Messages messages) {
        this.outputStream = outputStream;
        this.messages = messages;
    }

    @Override
    public void displayWelcomeMessage() {
        outputStream.print(messages.welcomeMessage());
    }

    @Override
    public void displayMainMenu() {
        outputStream.print(messages.mainMenuMessage());
        outputStream.print(messages.optionMessage());
    }

    @Override
    public void displayAvailableBookListing(String books) {
        outputStream.print(messages.bookListingMessage());
        outputStream.print(books);
    }

    @Override
    public void displayExitMessage() {
        outputStream.print(messages.exitMessage());
    }

    @Override
    public void displayIncorrectInputMessage() {
        outputStream.print(messages.incorrectInputMessage());
    }

    @Override
    public void displayInputMismatchExceptionMessage() {
        displayIncorrectInputMessage();
    }
}


