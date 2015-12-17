package com.twu.biblioteca.view;

import com.twu.biblioteca.controller.LibraryController;

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
        if (libraryController.login(libraryNumber, password) != null && !libraryController.isLibrarian()) {
            displayCorrectLoginMessage();
            displayUserName(libraryController.getUserName());
            customerLoggedIn = true;
            callCustomerMenu();
        } else if (libraryController.login(libraryNumber, password) != null && libraryController.isLibrarian()) {
            displayCorrectLoginMessage();
            displayUserName(libraryController.getUserName());
            librarianLoggedIn = true;
            callLibrarianMenu();

        } else {
            displayIncorrectLoginMessage();
            return;
        }
    }




    private void callCustomerMenuOptions(int option) {

        switch (option) {
            case 1:
                if (libraryController.availableBooksIsEmpty()) {
                    borrowMenu.displayIncorrectBookBorrowMessage();
                    break;
                }
                borrowMenu.callBookBorrowMenu();
                break;
            case 2:
                if (libraryController.borrowedBooksIsEmpty()) {
                    returnMenu.displayIncorrectBookReturnMessage();
                    break;
                }
                returnMenu.callBookReturnMenu();
                break;
            case 3:
                displayCustomerInformation(libraryController.getCustomerInformation());
                break;
            case 4:
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
                if (libraryController.booksCheckedOutByCustomersListIsEmpty()) {
                    displayIncorrectBooksCheckedOutByCustomersMessage();
                    break;
                }
                displayBooksCheckedOutByCustomers(libraryController.getBooksCheckedOutByCustomersList());
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
    public void displayIncorrectLoginMessage() {
        outputStream.print(messages.incorrectLoginMessage());
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
    public void displayBooksCheckedOutByCustomers(String list) {
        outputStream.print(messages.booksCheckedOutByCustomersMessage());
        outputStream.print(list);
    }

    @Override
    public void displayIncorrectBooksCheckedOutByCustomersMessage() {
        outputStream.print(messages.incorrectBooksCheckedOutByCustomersMessage());

    }


}