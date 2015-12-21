package com.twu.biblioteca.view;

/**
 * MainMenu interface.
 * MainMenu is responsible for the MainMenu display.
 *
 * @author Desiree Kelly
 * @version 1.0
 */
public interface MainMenu {

    void displayWelcomeMessage();

    void displayMainMenu();

    void displayExitMessage();

    void displayIncorrectOptionMessage();

    void displayInputMismatchExceptionMessage();

    void launch();
}