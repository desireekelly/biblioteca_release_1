package com.twu.biblioteca.menu;

import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.utilities.Messages;
import com.twu.biblioteca.utilities.Utilities;

import java.io.PrintStream;
import java.util.List;

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
    public void displayAvailableBookListing(List<Book> books) {
        outputStream.println(Utilities.displayFormattedBookList(books));
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
}
