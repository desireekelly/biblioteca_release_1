package com.twu.biblioteca.menu;

import com.twu.biblioteca.Utilities.Utilities;
import com.twu.biblioteca.library.LibraryController;
import com.twu.biblioteca.messages.Messages;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by desiree on 10/12/2015.
 */
public class ReturnMenuImpl implements ReturnMenu {

    private LibraryController libraryController;
    private PrintStream outputStream;
    private Messages messages;
    private Scanner input;
    private boolean exit;

    public ReturnMenuImpl(LibraryController libraryController, InputStream inputStream, PrintStream outputStream, Messages messages) {
        this.libraryController = libraryController;
        this.outputStream = outputStream;
        this.messages = messages;
        this.input = new Scanner(inputStream);
        exit = false;
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
                    exit = true;
                }
            } catch (InputMismatchException e) {
                displayInputMismatchExceptionMessage();
                input.nextLine();
                exit = true;
            }
        } while (!exit);
    }

    private void callReturnMenuOptions(int option) {
        if (option == 0) {
            exit = true;
            return;
        }
        if (option > 0 && option <= libraryController.getBorrowedBooksSize()) {
            outputStream.print(getReturnThankYouMessage() + libraryController.checkinBook(option) + "!\n");
            exit = true;
            return;
        } else {
            displayIncorrectInputMessage();
            exit = true;
        }
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
