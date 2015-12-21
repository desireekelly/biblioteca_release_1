package com.twu.biblioteca.view;

import com.twu.biblioteca.controller.LibraryController;
import com.twu.biblioteca.exceptions.BookNotReturnable;
import com.twu.biblioteca.exceptions.MovieNotReturnable;

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
    public void callBookReturnMenu() {
        displayBookReturnMenu();
        displayBorrowedBookListing(Utilities.formatBookList(libraryController.getBorrowedBooks()));
        try {
            if (input.hasNextLine()) {
                callBookReturnMenuOptions(input.nextInt(10));
            } else {
                return;
            }
        } catch (InputMismatchException e) {
            displayInputMismatchExceptionMessage();
            input.nextLine();
            return;
        }
    }

    @Override
    public void callMovieReturnMenu() {
        displayMovieReturnMenu();
        displayBorrowedMovieListing(Utilities.formatMovieList(libraryController.getBorrowedMovies()));
        try {
            if (input.hasNextLine()) {
                callMovieReturnMenuOptions(input.nextInt(10));
            } else {
                return;
            }
        } catch (InputMismatchException e) {
            displayInputMismatchExceptionMessage();
            input.nextLine();
            return;
        }
    }

    private void callBookReturnMenuOptions(int option) {
        if (option == 0) {
            return;
        }
        if (option > 0 && option <= libraryController.getBorrowedBooksSize()) {
            try {
                outputStream.print(getReturnThankYouMessage() + libraryController.checkinBook(option) + "!\n");
                return;
            } catch (BookNotReturnable e) {
                outputStream.print("\n" + e.getMessage() + "\n");
            }
        } else {
            displayIncorrectOptionMessage();
            return;
        }
    }

    private void callMovieReturnMenuOptions(int option) {
        if (option == 0) {
            return;
        }
        if (option > 0 && option <= libraryController.getBorrowedMoviesSize()) {
            try {
                outputStream.print(getReturnThankYouMessage() + libraryController.checkinMovie(option) + "!\n");
                return;
            } catch (MovieNotReturnable e) {
                outputStream.print("\n" + e.getMessage() + "\n");
            }
        } else {
            displayIncorrectOptionMessage();
            return;
        }
    }

    @Override
    public void displayBookReturnMenu() {
        outputStream.print(messages.bookReturnMessage());
        outputStream.print(messages.bookListingMessage());
    }

    @Override
    public void displayMovieReturnMenu() {
        outputStream.print(messages.movieReturnMessage());
        outputStream.print(messages.movieListingMessage());
    }

    @Override
    public void displayBorrowedBookListing(String books) {
        outputStream.println(books);
        outputStream.print(messages.optionMessage());
    }

    @Override
    public void displayBorrowedMovieListing(String movies) {
        outputStream.println(movies);
        outputStream.print(messages.optionMessage());
    }

    @Override
    public void displayIncorrectOptionMessage() {
        outputStream.print(messages.incorrectOptionMessage());
    }

    @Override
    public void displayIncorrectBookReturnMessage() {
        outputStream.print(messages.incorrectBookReturnMessage());
    }

    @Override
    public void displayInputMismatchExceptionMessage() {
        outputStream.print(messages.incorrectInputMessage());
    }

    @Override
    public String getReturnThankYouMessage() {
        return messages.returnThankYouMessage();
    }

    @Override
    public void displayIncorrectMovieReturnMessage() {
        outputStream.print(messages.incorrectMovieReturnMessage());
    }
}