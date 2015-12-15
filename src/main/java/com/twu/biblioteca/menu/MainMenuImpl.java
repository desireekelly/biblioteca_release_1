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
public class MainMenuImpl implements MainMenu {
    private LibraryController libraryController;
    private Scanner input;
    private PrintStream outputStream;
    private Messages messages;
    private BorrowMenu borrowMenu;
    private ReturnMenu returnMenu;
    private boolean exit;

    public MainMenuImpl(LibraryController libraryController, InputStream inputStream, PrintStream outputStream, BorrowMenu borrowMenu, ReturnMenu returnMenu, Messages messages) {
        this.libraryController = libraryController;
        this.input = new Scanner(inputStream);
        this.outputStream = outputStream;
        this.messages = messages;
        this.borrowMenu = borrowMenu;
        this.returnMenu = returnMenu;
        exit = false;
    }

    @Override
    public void launch() {
        callMainMenu();
    }

    @Override
    public void callMainMenu() {
        displayWelcomeMessage();
        do {
            try {
                displayMainMenu();
                if (input.hasNextLine()) {
                    callMainMenuOptions(input.nextInt());
                } else {
                    exit = true;
                }
            } catch (InputMismatchException e) {
                displayInputMismatchExceptionMessage();
                input.nextLine();
            }
        } while (!exit);
    }


    private void callMainMenuOptions(int option) {

        switch (option) {
            case 1:
                displayAvailableBookListing(Utilities.formatBookList(libraryController.getAvailableBooks()));
                break;
            case 2:
                if (libraryController.availableBooksIsEmpty()) {
                    borrowMenu.displayIncorrectBorrowMessage();
                    break;
                }
                borrowMenu.callBorrowMenu();
                break;
            case 3:
                if (libraryController.borrowedBooksIsEmpty()) {
                    returnMenu.displayIncorrectReturnMessage();
                    break;
                }
                //callReturnMenu();
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









    @Override
    public void displayWelcomeMessage() {
        outputStream.print(messages.welcomeMessage());
    }

    @Override
    public void displayMainMenu() {
        outputStream.print(messages.mainMenuMessage());
        outputStream.print(messages.optionMessage());
    }

    @Override
    public void displayAvailableBookListing(String books) {
        outputStream.print(messages.bookListingMessage());
        outputStream.print(books);
    }

    @Override
    public void displayExitMessage() {
        outputStream.print(messages.exitMessage());
    }

    @Override
    public void displayIncorrectInputMessage() {
        outputStream.print(messages.incorrectInputMessage());
    }

    @Override
    public void displayInputMismatchExceptionMessage() {
        displayIncorrectInputMessage();
    }
}


