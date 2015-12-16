package com.twu.biblioteca.biblioteca;

import com.twu.biblioteca.controller.BorrowService;
import com.twu.biblioteca.controller.LibraryController;
import com.twu.biblioteca.controller.ReturnService;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.LibraryImpl;
import com.twu.biblioteca.view.*;

/**
 * Run Biblioteca Library System
 *
 * @author Desiree Kelly
 * @version 1.0
 */
class BibliotecaApp {
    public static void main(String[] args) {
        //Setup Library
        Library library = new LibraryImpl();
        BorrowService borrowService = new BorrowService(library);
        ReturnService returnService = new ReturnService(library);
        LibraryController libraryController = new LibraryController(library, borrowService, returnService);

        //Setup UI
        Messages messages = new MessagesImpl();
        BorrowMenu borrowMenu = new BorrowMenuImpl(libraryController, System.in, System.out, messages);
        ReturnMenu returnMenu = new ReturnMenuImpl(libraryController, System.in, System.out, messages);
        UserMenu userMenu = new UserMenuImpl(libraryController, System.in, System.out, borrowMenu, returnMenu, messages);
        MainMenu mainMenu = new MainMenuImpl(libraryController, System.in, System.out, borrowMenu, userMenu, messages);
        mainMenu.launch();
    }
}