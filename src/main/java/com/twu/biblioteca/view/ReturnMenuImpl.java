package com.twu.biblioteca.view;

import com.twu.biblioteca.controller.LibraryController;
import com.twu.biblioteca.exceptions.BookNotReturnable;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ReturnMenu implementation.
 * ReturnMenu is responsible for the ReturnMenu display.
 *
 * @author Desiree Kelly
 * @version 1.0
 */
public class ReturnMenuImpl implements ReturnMenu {

    private LibraryController libraryController;
    private PrintStream outputStream;
    private Messages messages;
    private Scanner input;

    public ReturnMenuImpl(LibraryController libraryController, InputStream inputStream, PrintStream outputStream, Messages messages) {
        this.libraryController = libraryController;
        this.outputStream = outputStream;
        this.messages = messages;
        this.input = new Scanner(inputStream);
    }

    @Override
    public void callReturnMenu() {
        displayReturnMenu();
        displayBorrowedBookListing(Utilities.formatBookList(libraryController.getBorrowedBooks()));
        do {
            try {
                if (input.hasNextLine()) {
                    callReturnMenuOptions(input.nextInt(10));
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

    private void callReturnMenuOptions(int option) {
        if (option == 0) {
            exit();
            return;
        }
        if (option > 0 && option <= libraryController.getBorrowedBooksSize()) {
            try {
                outputStream.print(getReturnThankYouMessage() + libraryController.checkinBook(option) + "!\n");
                exit();
            } catch (BookNotReturnable e) {
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
    public void displayIncorrectReturnMessage() {
        outputStream.print(messages.incorrectReturnMessage());
    }

    @Override
    public void displayInputMismatchExceptionMessage() {
        displayIncorrectInputMessage();
    }

    @Override
    public String getReturnThankYouMessage() {
        return messages.returnThankYouMessage();
    }
}
