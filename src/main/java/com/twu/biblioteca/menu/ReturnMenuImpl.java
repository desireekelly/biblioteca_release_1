package com.twu.biblioteca.menu;

import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.utilities.Messages;
import com.twu.biblioteca.utilities.Utilities;

import java.io.PrintStream;
import java.util.List;

/**
 * Created by desiree on 10/12/2015.
 */
public class ReturnMenuImpl {

    private PrintStream outputStream;
    private Messages messages;

    public ReturnMenuImpl(PrintStream outputStream, Messages messages) {
        this.outputStream = outputStream;
        this.messages = messages;
    }

    public void displayReturnMenu() {
        outputStream.print(messages.returnMessage());
        outputStream.print(messages.bookListingMessage());
    }

    public void displayBorrowedBookListing(List<Book> books) {
        outputStream.println(Utilities.displayFormattedBookList(books));
        outputStream.print(messages.optionMessage());
    }

    public void displayIncorrectInputMessage() {
        outputStream.print(messages.incorrectInputMessage());
    }

    public void displayReturnThankYouMessage() {
        outputStream.print(messages.returnThankYouMessage());
    }

    public void displayBookToReturn(String book) {
        outputStream.print(book + "!\n");
    }
}
