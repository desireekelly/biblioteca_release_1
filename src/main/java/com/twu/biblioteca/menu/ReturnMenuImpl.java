package com.twu.biblioteca.menu;

import com.twu.biblioteca.messages.Messages;

import java.io.PrintStream;

/**
 * Created by desiree on 10/12/2015.
 */
public class ReturnMenuImpl implements ReturnMenu {

    private PrintStream outputStream;
    private Messages messages;

    public ReturnMenuImpl(PrintStream outputStream, Messages messages) {
        this.outputStream = outputStream;
        this.messages = messages;
    }

    @Override
    public void displayReturnMenu() {
        outputStream.print(messages.returnMessage());
        outputStream.print(messages.bookListingMessage());
    }

    @Override
    public void displayBorrowedBookListing(String books) {
        outputStream.println(books);
        outputStream.print(messages.optionMessage());
    }

    @Override
    public void displayIncorrectInputMessage() {
        outputStream.print(messages.incorrectInputMessage());
    }

    @Override
    public void displayReturnThankYouMessage() {
        outputStream.print(messages.returnThankYouMessage());
    }

    @Override
    public void displayBookToReturn(String book) {
        outputStream.print(book + "!\n");
    }

    @Override
    public void displayIncorrectReturnMessage() {
        outputStream.print(messages.incorrectReturnMessage());
    }

    @Override
    public void displayReturnExceptionMessage(String exception) {
        outputStream.print("\n" + exception + "\n");
    }

    @Override
    public void displayInputMismatchExceptionMessage() {
        displayIncorrectInputMessage();
    }
}