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
    private boolean exit;
    private Messages messages;
    BorrowMenuImpl borrowMenu;
    ReturnMenuImpl returnMenu;
    MainMenuImpl mainMenu;

    public LibraryController(BorrowService borrowService, ReturnService returnService) {
        this.borrowService = borrowService;
        this.returnService = returnService;
        this.input = new Scanner(System.in);
        this.outputStream = new PrintStream(System.out);
        exit = false;
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
        do {
            try {
                mainMenu.displayMainMenu();
                if (input.hasNextLine()) {
                    mainMenu.mainMenuOptions(input.nextInt());
                } else {
                    exit = true;
                }

            } catch (InputMismatchException e) {
                outputStream.print(messages.incorrectInputMessage());
                input.nextLine();
            }
        } while (!exit);
    }
}