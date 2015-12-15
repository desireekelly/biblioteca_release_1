package com.twu.biblioteca.view;

import com.twu.biblioteca.controller.LibraryController;
import com.twu.biblioteca.exceptions.BookNotBorrowable;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * BorrowMenu implementation.
 * BorrowMenu is responsible for the BorrowMenu display.
 *
 * @author Desiree Kelly
 * @version 1.0
 */
public class BorrowMenuImpl implements BorrowMenu {

    private LibraryController libraryController;
    private PrintStream outputStream;
    private Messages messages;
    private Scanner input;

    public BorrowMenuImpl(LibraryController libraryController, InputStream inputStream, PrintStream outputStream, Messages messages) {
        this.libraryController = libraryController;
        this.outputStream = outputStream;
        this.messages = messages;
        this.input = new Scanner(inputStream);
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
                    exit();
                }
            } catch (InputMismatchException e) {
                displayInputMismatchExceptionMessage();
                input.nextLine();
                exit();
            }
        } while (!exit());
    }

    private void callBorrowMenuOptions(int option) {
        if (option == 0) {
            exit();
            return;
        }
        if (option > 0 && option <= libraryController.getAvailableBooksSize()) {
            try {
                outputStream.print(getBorrowThankYouMessage() + libraryController.checkoutBook(option) + "!\n");
                exit();
            } catch (BookNotBorrowable e) {
                outputStream.println("\n" + e.getMessage() + "\n");
            }
        } else {
            displayIncorrectInputMessage();
            exit();
        }
    }

    private boolean exit() {
        return true;
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