package com.twu.biblioteca.menu;

import com.twu.biblioteca.library.LibraryController;
import com.twu.biblioteca.library.Utilities;
import com.twu.biblioteca.messages.Messages;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by desiree on 10/12/2015.
 */
public class BorrowMenuImpl implements BorrowMenu {

    private LibraryController libraryController;
    private PrintStream outputStream;
    private Messages messages;
    private Scanner input;
    private boolean exit;

    public BorrowMenuImpl(LibraryController libraryController, InputStream inputStream, PrintStream outputStream, Messages messages) {
        this.libraryController = libraryController;
        this.outputStream = outputStream;
        this.messages = messages;
        this.input = new Scanner(inputStream);
        exit = false;
    }

    @Override
    public void callBorrowMenu() {
        displayBorrowMenu();
        displayAvailableBookListing(Utilities.formatBookList(libraryController.getAvailableBooks()));

        do {
            try {
                if (input.hasNextLine()) {
                    callBorrowMenuOptions(input.nextInt(10));
                } else {
                    exit = true;
                }
            } catch (InputMismatchException e) {
                displayInputMismatchExceptionMessage();
                input.nextLine();
                exit = true;
            }
        } while (!exit);
    }

    private void callBorrowMenuOptions(int option) {
        if (option == 0) {
            exit = true;
            return;
        }
        if (option > 0 && option <= libraryController.getAvailableBooksSize()) {
            outputStream.print(getBorrowThankYouMessage() + libraryController.checkoutBook(option) + "!\n");
            exit = true;
            return;
        } else {
            displayIncorrectInputMessage();
            exit = true;
        }
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
    public String getBorrowThankYouMessage() {
        return messages.borrowThankYouMessage();
    }

    @Override
    public void displayIncorrectBorrowMessage() {
        outputStream.print(messages.incorrectBorrowMessage());
    }

    @Override
    public void displayInputMismatchExceptionMessage() {
        displayIncorrectInputMessage();
    }
}
