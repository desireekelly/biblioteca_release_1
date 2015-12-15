package com.twu.biblioteca.menu;

import com.twu.biblioteca.messages.Messages;

import java.io.PrintStream;

/**
 * Created by desiree on 10/12/2015.
 */
public class BorrowMenuImpl implements BorrowMenu {

    private PrintStream outputStream;
    private Messages messages;

    public BorrowMenuImpl(PrintStream outputStream, Messages messages) {
        this.outputStream = outputStream;
        this.messages = messages;
    }

    @Override
    public void displayBorrowMenu() {
        outputStream.print(messages.borrowMessage());
        outputStream.print(messages.bookListingMessage());
    }

    @Override
    public void displayAvailableBookListing(String books) {
        outputStream.println(books);
        outputStream.print(messages.optionMessage());
    }

    @Override
    public void displayIncorrectInputMessage() {
        outputStream.print(messages.incorrectInputMessage());
    }

    @Override
    public void displayBorrowThankYouMessage() {
        outputStream.print(messages.borrowThankYouMessage());
    }

    @Override
    public void displayBookToBorrow(String book) {
        outputStream.print(book + "!\n");
    }

    @Override
    public void displayIncorrectBorrowMessage() {
        outputStream.print(messages.incorrectBorrowMessage());
    }

    @Override
    public void displayBorrowExceptionMessage(String exception) {
        outputStream.print("\n" + exception + "\n");
    }

    @Override
    public void displayInputMismatchExceptionMessage() {
        displayIncorrectInputMessage();
    }
}
