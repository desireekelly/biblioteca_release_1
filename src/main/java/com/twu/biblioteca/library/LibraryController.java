package com.twu.biblioteca.library;

import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.exceptions.BookNotBorrowable;
import com.twu.biblioteca.exceptions.BookNotReturnable;
import com.twu.biblioteca.menu.BorrowMenuImpl;
import com.twu.biblioteca.menu.MainMenuImpl;
import com.twu.biblioteca.menu.ReturnMenuImpl;
import com.twu.biblioteca.utilities.Messages;
import com.twu.biblioteca.utilities.MessagesImpl;

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
    private boolean exit;

    public LibraryController(Library library, BorrowService borrowService, ReturnService returnService) {
        this.borrowService = borrowService;
        this.returnService = returnService;
        this.library = library;
        this.input = new Scanner(System.in);
        this.outputStream = new PrintStream(System.out);
        this.messages = new MessagesImpl();
        this.borrowMenu = new BorrowMenuImpl(System.out, messages);
        this.returnMenu = new ReturnMenuImpl(System.out, messages);
        this.mainMenu = new MainMenuImpl(System.out, messages);
        exit = false;
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
                outputStream.print(messages.incorrectInputMessage());
                input.nextLine();
            }
        }
    }

    private void callMainMenuOptions(int option) {
        switch (option) {
            case 1:
                mainMenu.displayAvailableBookListing(library.getAvailableBooks());
                break;
            case 2:
                if (library.getAvailableBooks().isEmpty()) {
                    borrowMenu.displayIncorrectBorrowMessage();
                break;
                }
                callBorrowMenu();
                break;
            case 3:
                if (library.getBorrowedBooks().isEmpty()) {
                    returnMenu.displayIncorrectReturnMessage();
                break;
                }
                callReturnMenu();
                break;
            case 4:
                mainMenu.displayExitMessage();
                System.exit(0);
                break;
            default:
                mainMenu.displayIncorrectInputMessage();
                break;
        }
    }

    private void callBorrowMenu() {
        borrowMenu.displayBorrowMenu();
        borrowMenu.displayAvailableBookListing(library.getAvailableBooks());
        do {
            try {
                if (input.hasNextLine()) {
                    callBorrowMenuOptions(input.nextInt(10));
                } else {
                    exit = true;
                }
            } catch (InputMismatchException e) {
                outputStream.print(messages.incorrectInputMessage());
                input.nextLine();
                exit = true;
            }
        } while (!exit);
    }

    private void callBorrowMenuOptions(int option) {
        if (option == 0) {
            exit = true;
            return;
        }
        if (option > 0 && option <= library.getAvailableBooks().size()) {
            try {
                Book bookToBorrow = library.getAvailableBooks().get(option - 1);
                borrowBook(bookToBorrow);
                borrowMenu.displayBorrowThankYouMessage();
                borrowMenu.displayBookToBorrow(bookToBorrow.getTitle().toString());
                exit = true;
            } catch (BookNotBorrowable e) {
                outputStream.println("\n" + e.getMessage() + "\n");
            }
        } else {
            borrowMenu.displayIncorrectInputMessage();
            exit = true;
        }
    }

    private void callReturnMenu() {
        returnMenu.displayReturnMenu();
        returnMenu.displayBorrowedBookListing(library.getBorrowedBooks());
        do {
            try {
                if (input.hasNextLine()) {
                    callReturnMenuOptions(input.nextInt(10));
                } else {
                    exit = true;
                }
            } catch (InputMismatchException e) {
                outputStream.print(messages.incorrectInputMessage());
                input.nextLine();
                exit = true;
            }
        } while (!exit);
    }

    private void callReturnMenuOptions(int option) {
        if (option == 0) {
            exit = true;
            return;
        }
        if (option > 0 && option <= library.getBorrowedBooks().size()) {
            try {
                Book bookToReturn = library.getBorrowedBooks().get(option - 1);
                returnBook(bookToReturn);
                returnMenu.displayReturnThankYouMessage();
                returnMenu.displayBookToReturn(bookToReturn.getTitle().toString());
                exit = true;
            } catch (BookNotReturnable e) {
                outputStream.println("\n" + e.getMessage() + "\n");
            }
        } else {
            returnMenu.displayIncorrectInputMessage();
            exit = true;
        }
    }
}