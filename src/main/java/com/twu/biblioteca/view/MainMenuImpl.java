package com.twu.biblioteca.view;

import com.twu.biblioteca.controller.LibraryController;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * MainMenu implementation.
 * MainMenu is responsible for the MainMenu display.
 *
 * @author Desiree Kelly
 * @version 1.0
 */
public class MainMenuImpl implements MainMenu {
    private LibraryController libraryController;
    private Scanner input;
    private PrintStream outputStream;
    private Messages messages;
    private BorrowMenu borrowMenu;
    private ReturnMenu returnMenu;
    private UserMenuImpl userMenu;
    private boolean exit;

    public MainMenuImpl(LibraryController libraryController, InputStream inputStream, PrintStream outputStream, BorrowMenu borrowMenu, ReturnMenu returnMenu, UserMenuImpl userMenu, Messages messages) {
        this.libraryController = libraryController;
        this.input = new Scanner(inputStream);
        this.outputStream = outputStream;
        this.messages = messages;
        this.borrowMenu = borrowMenu;
        this.returnMenu = returnMenu;
        this.userMenu = userMenu;
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
                if (libraryController.availableBooksIsEmpty()) {
                    displayIncorrectAvailableBooksMessage();
                    break;
                }
                displayAvailableBookListing(Utilities.formatBookList(libraryController.getAvailableBooks()));
                break;
            case 2:
                userMenu.login();
                break;
            case 3:
                if (libraryController.availableMoviesIsEmpty()) {
                    displayIncorrectAvailableMoviesMessage();
                    break;
                }
                displayAvailableMovieListing(Utilities.formatMovieList(libraryController.getAvailableMovies()));
                break;
            case 4:
                if (libraryController.availableMoviesIsEmpty()) {
                    borrowMenu.displayIncorrectMovieBorrowMessage();
                    break;
                }
                borrowMenu.callMovieBorrowMenu();
                break;
            case 5:
                displayExitMessage();
                exit = true;
                break;
            default:
                displayIncorrectInputMessage();
                break;
        }
    }


    @Override
    public void displayAvailableMovieListing(String movies) {
        outputStream.print(messages.movieListingMessage());
        outputStream.print(movies);
    }

    @Override
    public void displayIncorrectAvailableMoviesMessage() {
        outputStream.print(messages.incorrectAvailableMoviesMessage());
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
    public void displayIncorrectAvailableBooksMessage() {
        outputStream.print(messages.incorrectAvailableBooksMessage());
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