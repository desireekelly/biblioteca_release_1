package com.twu.biblioteca.library;

import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.exceptions.BookNotBorrowable;
import com.twu.biblioteca.exceptions.BookNotReturnable;
import com.twu.biblioteca.menu.BorrowMenuImpl;
import com.twu.biblioteca.menu.MainMenuImpl;
import com.twu.biblioteca.menu.ReturnMenuImpl;
import com.twu.biblioteca.utilities.Messages;
import com.twu.biblioteca.utilities.MessagesImpl;
import com.twu.biblioteca.utilities.Utilities;

import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by desiree on 10/12/2015.
 */
public class LibraryController {
    private BorrowService borrowService;
    private ReturnService returnService;
    private Scanner input;
    private PrintStream outputStream;
    private Messages messages;
    private BorrowMenuImpl borrowMenu;
    private ReturnMenuImpl returnMenu;
    private MainMenuImpl mainMenu;
    private Library library;

    public LibraryController(Library library, BorrowService borrowService, ReturnService returnService) {
        this.borrowService = borrowService;
        this.returnService = returnService;
        this.library = library;
        this.input = new Scanner(System.in);
        this.outputStream = new PrintStream(System.out);
        this.messages = new MessagesImpl();
        this.borrowMenu = new BorrowMenuImpl(System.out, messages);
        this.returnMenu = new ReturnMenuImpl(System.out, messages);
        this.mainMenu = new MainMenuImpl(System.out, messages, borrowMenu, returnMenu);
    }

    public boolean borrowBook(Book book) throws BookNotBorrowable {
        return borrowService.borrowBook(book);
    }

    public boolean returnBook(Book book) throws BookNotReturnable {
        return returnService.returnBook(book);
    }

    public void launch() {
        callMainMenu();
    }

    private void callMainMenu() {
        mainMenu.displayWelcomeMessage();
        while (true) {
            try {
                mainMenu.displayMainMenu();
                if (input.hasNextLine()) {
                    callMainMenuOptions(input.nextInt());
                }
            } catch (InputMismatchException e) {
                //outputStream.print(messages.incorrectInputMessage());
                mainMenu.displayIncorrectInputMessage();
                input.nextLine();
            }
        }
    }

    private void callMainMenuOptions(int option) {
        switch (option) {
            case 1:
                mainMenu.displayBookListing(Utilities.displayFormattedBookList(library.getAvailableBooks()));
                break;
            case 2:
                if (library.getAvailableBooks().isEmpty()) {
                mainMenu.displayIncorrectBorrowMessage();
                break;
                }
            //borrowMenu.displayBorrowMenu();
            //break;
            case 3:
                if (library.getBorrowedBooks().isEmpty()) {
                mainMenu.displayIncorrectReturnMessage();
                break;
                }
            //returnMenu.displayReturnMenu();
            //break;
            case 4:
                mainMenu.displayExitMessage();
                System.exit(0);
            default:
                mainMenu.displayIncorrectInputMessage();
                break;
        }
    }
}