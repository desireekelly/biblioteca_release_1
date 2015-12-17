package com.twu.biblioteca.view;

import com.twu.biblioteca.controller.LibraryController;
import com.twu.biblioteca.exceptions.BookNotBorrowable;
import com.twu.biblioteca.exceptions.MovieNotBorrowable;

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
    public void callBookBorrowMenu() {
        displayBookBorrowMenu();
        displayAvailableBookListing(Utilities.formatBookList(libraryController.getAvailableBooks()));
            try {
                if (input.hasNextLine()) {
                    callBookBorrowMenuOptions(input.nextInt(10));
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
    public void callMovieBorrowMenu() {
        displayMovieBorrowMenu();
        displayAvailableMovieListing(Utilities.formatMovieList(libraryController.getAvailableMovies()));
        try {
            if (input.hasNextLine()) {
                callMovieBorrowMenuOptions(input.nextInt(10));
            } else {
                return;
            }
        } catch (InputMismatchException e) {
            displayInputMismatchExceptionMessage();
            input.nextLine();
            return;
        }

    }

    private void callBookBorrowMenuOptions(int option) {

        if (option == 0) {
            return;
        }
        if (option > 0 && option <= libraryController.getAvailableBooksSize()) {
            try {
                outputStream.print(getBookBorrowThankYouMessage() + libraryController.checkoutBook(option) + "!\n");
                return;
            } catch (BookNotBorrowable e) {
                outputStream.println("\n" + e.getMessage() + "\n");
            }
        } else {
            displayIncorrectInputMessage();
            return;
        }

    }

    private void callMovieBorrowMenuOptions(int option) {
        if (option == 0) {
            return;
        }
        if (option > 0 && option <= libraryController.getAvailableMoviesSize()) {
            try {
                outputStream.print(getMovieBorrowThankYouMessage() + libraryController.checkoutMovie(option) + "!\n");
                return;
            } catch (MovieNotBorrowable e) {
                outputStream.println("\n" + e.getMessage() + "\n");
            }
        } else {
            displayIncorrectInputMessage();
            return;
        }
    }

    @Override
    public void displayBookBorrowMenu() {
        outputStream.print(messages.bookBorrowMessage());
        outputStream.print(messages.bookListingMessage());
    }

    @Override
    public void displayMovieBorrowMenu() {
        outputStream.print(messages.movieBorrowMessage());
        outputStream.print(messages.movieListingMessage());
    }

    @Override
    public void displayAvailableBookListing(String books) {
        outputStream.println(books);
        outputStream.print(messages.optionMessage());
    }

    @Override
    public void displayAvailableMovieListing(String movies) {
        outputStream.println(movies);
        outputStream.print(messages.optionMessage());
    }

    @Override
    public void displayIncorrectInputMessage() {
        outputStream.print(messages.incorrectOptionMessage());
    }

    @Override
    public String getBookBorrowThankYouMessage() {
        return messages.bookBorrowThankYouMessage();
    }

    @Override
    public String getMovieBorrowThankYouMessage() {
        return messages.movieBorrowThankYouMessage();
    }

    @Override
    public void displayIncorrectBookBorrowMessage() {
        outputStream.print(messages.incorrectBookBorrowMessage());
    }

    @Override
    public void displayIncorrectMovieBorrowMessage() {
        outputStream.print(messages.incorrectMovieBorrowMessage());
    }

    @Override
    public void displayInputMismatchExceptionMessage() {
        displayIncorrectInputMessage();
    }
}