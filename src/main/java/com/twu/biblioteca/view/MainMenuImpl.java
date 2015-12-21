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
    private UserMenu userMenu;
    private boolean exit;

    public MainMenuImpl(LibraryController libraryController, InputStream inputStream, PrintStream outputStream, BorrowMenu borrowMenu, ReturnMenu returnMenu, UserMenu userMenu, Messages messages) {
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

    private void callMainMenu() {
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
                userMenu.login();
                break;
            case 2:
                displayExitMessage();
                exit = true;
                break;
            default:
                displayIncorrectOptionMessage();
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
    public void displayExitMessage() {
        outputStream.print(messages.exitMessage());
    }

    @Override
    public void displayIncorrectOptionMessage() {
        outputStream.print(messages.incorrectOptionMessage());
    }

    @Override
    public void displayInputMismatchExceptionMessage() {
        outputStream.print(messages.incorrectInputMessage());
    }
}