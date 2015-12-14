package com.twu.biblioteca.menu;

import com.twu.biblioteca.utilities.Messages;

import java.io.PrintStream;

/**
 * Created by desiree on 10/12/2015.
 */
public class MainMenuImpl {
    private PrintStream outputStream;
    private Messages messages;
    private BorrowMenuImpl borrowMenu;
    private ReturnMenuImpl returnMenu;

    /**
     * Construct a main menu with access to the library, input streams, output streams, borrow menu and return menu.
     */
    public MainMenuImpl(PrintStream outputStream, Messages messages, BorrowMenuImpl borrowMenu, ReturnMenuImpl returnMenu) {
        this.outputStream = outputStream;
        this.messages = messages;
        this.borrowMenu = borrowMenu;
        this.returnMenu = returnMenu;
    }

    /**
     * Display the main menu options.
     */
    public void displayWelcomeMessage() {
        outputStream.print(messages.welcomeMessage());
    }

    public void displayMainMenu() {
        outputStream.print(messages.mainMenuMessage());
        outputStream.print(messages.optionMessage());
    }

    public void mainMenuOptions(int option) {
        /*
        switch (option) {
            case 1:
                outputStream.print(messages.bookListingMessage());
                //outputStream.println(Utilities.displayFormattedBookList(library.getAvailableBooks()));
                break;
            case 2:
                if (library.getAvailableBooks().isEmpty()) {
                    outputStream.print(messages.incorrectBorrowMessage());
                    break;
                }
                borrowMenu.displayBorrowMenu();
                break;
            case 3:
                if (library.getBorrowedBooks().isEmpty()) {
                    outputStream.print(messages.incorrectReturnMessage());
                    break;
                }
                returnMenu.displayReturnMenu();
                break;
            case 4:
                outputStream.print(messages.exitMessage());
                exit = true;
                break;
            default:
                outputStream.print(messages.incorrectInputMessage());
                break;
        }
        */
    }
}


