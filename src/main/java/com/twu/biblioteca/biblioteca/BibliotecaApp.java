package com.twu.biblioteca.biblioteca;

import com.twu.biblioteca.library.*;

class BibliotecaApp {
 public static void main(String[] args) {

     Library library = new LibraryImpl();
     BorrowService borrowService = new BorrowService(library);
     ReturnService returnService = new ReturnService(library);
     LibraryController libraryController = new LibraryController(borrowService, returnService);
 }
}
