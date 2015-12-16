package com.twu.biblioteca.view;

import com.twu.biblioteca.controller.LibraryController;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by desiree on 16/12/2015.
 */
public class UserMenuImpl {

    private LibraryController libraryController;
    private PrintStream outputStream;
    private Messages messages;
    private Scanner input;
    private BorrowMenu borrowMenu;
    private ReturnMenu returnMenu;
    private Boolean exit;

    public UserMenuImpl(LibraryController libraryController, InputStream inputStream, PrintStream outputStream, BorrowMenu borrowMenu, ReturnMenu returnMenu, Messages messages) {
        this.libraryController = libraryController;
        this.outputStream = outputStream;
        this.messages = messages;
        this.input = new Scanner(inputStream);
        this.borrowMenu = borrowMenu;
        this.returnMenu = returnMenu;
        exit = false;
    }

    public void callUserMenu() {
        displayUserMenu();
        try {
            if (input.hasNextLine()) {
                callUserMenuOptions(input.nextInt(10));
            } else {
                return;
            }
        } catch (InputMismatchException e) {
            displayInputMismatchExceptionMessage();
            input.nextLine();
            return;
        }

    }

    private void callUserMenuOptions(int option) {

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
                    returnMenu.displayIncorrectReturnMessage();
                    break;
                }
                returnMenu.callReturnMenu();
                break;
            case 3:
                //libraryController.getCustomerInformation();
                break;
            case 4:
                displayExitMessage();
                exit = true;
                break;
            default:
                displayIncorrectInputMessage();
                break;
        }
    }

    public void displayUserMenu() {
        outputStream.print(messages.userMenuMessage());
        outputStream.print(messages.optionMessage());
    }

    public void displayIncorrectInputMessage() {
        outputStream.print(messages.incorrectInputMessage());
    }

    public void displayInputMismatchExceptionMessage() {
        displayIncorrectInputMessage();
    }

    public void displayExitMessage() {
        outputStream.print(messages.exitMessage());
    }
}