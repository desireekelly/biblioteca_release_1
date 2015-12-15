package com.twu.biblioteca.menu;

/**
 * Created by desiree on 15/12/2015.
 */
public interface MainMenu {
    void displayWelcomeMessage();

    void displayMainMenu();

    void displayAvailableBookListing(String books);

    void displayExitMessage();

    void displayIncorrectInputMessage();

    void displayInputMismatchExceptionMessage();

    void launch();

    void callMainMenu();

}
