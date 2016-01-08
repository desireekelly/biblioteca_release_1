package com.twu.biblioteca.view;

import com.twu.biblioteca.controller.LibraryController;
import com.twu.biblioteca.exceptions.IncorrectLogin;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * UserMenu implementation.
 * UserMenu is responsible for the UserMenu display.
 *
 * @author Desiree Kelly
 * @version 2.0
 */
public class UserMenuImpl implements UserMenu {

    private LibraryController libraryController;
    private PrintStream outputStream;
    private Messages messages;
    private Scanner input;
    private BorrowMenu borrowMenu;
    private ReturnMenu returnMenu;
    private Boolean librarianLoggedIn;
    private Boolean customerLoggedIn;

    public UserMenuImpl(LibraryController libraryController, InputStream inputStream, PrintStream outputStream, BorrowMenu borrowMenu, ReturnMenu returnMenu, Messages messages) {
        this.libraryController = libraryController;
        this.outputStream = outputStream;
        this.messages = messages;
        this.input = new Scanner(inputStream);
        this.borrowMenu = borrowMenu;
        this.returnMenu = returnMenu;
        librarianLoggedIn = false;
        customerLoggedIn = false;
    }

    private void callCustomerMenu() {
        while (customerLoggedIn) {
            displayCustomerMenu();
            try {
                if (input.hasNextLine()) {
                    callCustomerMenuOptions(input.nextInt(10));
                } else {
                    return;
                }
            } catch (InputMismatchException e) {
                displayInputMismatchExceptionMessage();
                input.nextLine();
            }
        }
    }

    private void callLibrarianMenu() {
        while (librarianLoggedIn) {
            displayLibrarianMenu();
            try {
                if (input.hasNextLine()) {
                    callLibrarianMenuOptions(input.nextInt(10));
                } else {
                    return;
                }
            } catch (InputMismatchException e) {
                displayInputMismatchExceptionMessage();
                input.nextLine();
            }
        }
    }

    @Override
    public void login() {
        displayLoginMessage();
        displayLibraryNumberMessage();
        String libraryNumber = input.next();
        displayPasswordMessage();
        String password = input.next();
        try {
            libraryController.login(libraryNumber, password);
            if (!libraryController.isLibrarian()) {
                displayCorrectLoginMessage();
                displayUserName(libraryController.getUserName());
                customerLoggedIn = true;
                callCustomerMenu();
            } else if (libraryController.isLibrarian()) {
                displayCorrectLoginMessage();
                displayUserName(libraryController.getUserName());
                librarianLoggedIn = true;
                callLibrarianMenu();
            } else {
                return;
            }
        } catch (IncorrectLogin e) {
            outputStream.print("\n" + e.getMessage() + "\n");
            input.nextLine();
        }
    }

    private void callCustomerMenuOptions(int option) {
        switch (option) {
            case 1:
                if (libraryController.availableBooksIsEmpty()) {
                    displayIncorrectAvailableBooksMessage();
                    break;
                }
                displayAvailableBookListing(Utilities.formatBooks(libraryController.getAvailableItems()));
                break;
            case 2:
                if (libraryController.availableBooksIsEmpty()) {
                    borrowMenu.displayIncorrectBookBorrowMessage();
                    break;
                }
                borrowMenu.callBookBorrowMenu();
                break;
            case 3:
                if (libraryController.borrowedBooksIsEmpty()) {
                    returnMenu.displayIncorrectBookReturnMessage();
                    break;
                }
                returnMenu.callBookReturnMenu();
                break;
            case 4:
                if (libraryController.availableMoviesIsEmpty()) {
                    displayIncorrectAvailableMoviesMessage();
                    break;
                }
                displayAvailableMovieListing(Utilities.formatMovies(libraryController.getAvailableItems()));
                break;
            case 5:
                if (libraryController.availableMoviesIsEmpty()) {
                    borrowMenu.displayIncorrectMovieBorrowMessage();
                    break;
                }
                borrowMenu.callMovieBorrowMenu();
                break;
            case 6:
                if (libraryController.borrowedMoviesIsEmpty()) {
                    returnMenu.displayIncorrectMovieReturnMessage();
                    break;
                }
                returnMenu.callMovieReturnMenu();
                break;
            case 7:
                displayCustomerInformation(libraryController.getCustomerInformation());
                break;
            case 8:
                displayLogoutMessage();
                customerLoggedIn = false;
                break;
            default:
                displayIncorrectOptionMessage();
                break;
        }
    }

    private void callLibrarianMenuOptions(int option) {
        switch (option) {
            case 1:
                if (libraryController.itemsCheckedOutByCustomersIsEmpty()) {
                    displayIncorrectItemsCheckedOutByCustomersMessage();
                    break;
                }
                displayItemsCheckedOutByCustomers(Utilities.formatGetItemsCheckedOutByCustomers(libraryController.getItemsCheckedOutByCustomers()));
                break;
            case 2:
                displayLogoutMessage();
                librarianLoggedIn = false;
                break;
            default:
                displayIncorrectOptionMessage();
                break;
        }
    }

    @Override
    public void displayCustomerMenu() {
        outputStream.print(messages.customerMenuMessage());
        outputStream.print(messages.optionMessage());
    }

    @Override
    public void displayLibrarianMenu() {
        outputStream.print(messages.librarianMenuMessage());
        outputStream.print(messages.optionMessage());
    }

    @Override
    public void displayIncorrectAvailableBooksMessage() {
        outputStream.print(messages.incorrectAvailableBooksMessage());
    }

    @Override
    public void displayAvailableBookListing(String books) {
        outputStream.print(messages.bookListingMessage());
        outputStream.print(books);
    }

    @Override
    public void displayIncorrectAvailableMoviesMessage() {
        outputStream.print(messages.incorrectAvailableMoviesMessage());
    }

    @Override
    public void displayAvailableMovieListing(String movies) {
        outputStream.print(messages.movieListingMessage());
        outputStream.print(movies);
    }

    @Override
    public void displayIncorrectOptionMessage() {
        outputStream.print(messages.incorrectOptionMessage());
    }

    @Override
    public void displayInputMismatchExceptionMessage() {
        outputStream.print(messages.incorrectInputMessage());
    }

    @Override
    public void displayLibraryNumberMessage() {
        outputStream.print(messages.libraryNumberMessage());
    }

    @Override
    public void displayPasswordMessage() {
        outputStream.print(messages.passwordMessage());
    }

    @Override
    public void displayLoginMessage() {
        outputStream.print(messages.loginMessage());
    }

    @Override
    public void displayCorrectLoginMessage() {
        outputStream.print(messages.correctLoginMessage());
    }

    @Override
    public void displayLogoutMessage() {
        outputStream.print(messages.logoutMessage());
    }

    @Override
    public void displayCustomerInformation(String user) {
        outputStream.print(user);
    }

    @Override
    public void displayUserName(String user) {
        outputStream.print(user + "\n");
    }

    @Override
    public void displayItemsCheckedOutByCustomers(String list) {
        outputStream.print(messages.itemsCheckedOutByCustomersMessage());
        outputStream.print(list);
    }

    @Override
    public void displayIncorrectItemsCheckedOutByCustomersMessage() {
        outputStream.print(messages.incorrectItemsCheckedOutByCustomersMessage());
    }
}