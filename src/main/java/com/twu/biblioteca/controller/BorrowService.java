package com.twu.biblioteca.controller;

import com.twu.biblioteca.exceptions.BookNotBorrowable;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;

/**
 * BorrowService is responsible for borrowing a book from the Library
 *
 * @author Desiree Kelly
 * @version 1.0
 */
public class BorrowService {

    private Library library;

    public BorrowService(Library library) {
        this.library = library;
    }

    public boolean borrowBook(Book book) throws BookNotBorrowable {
        library.checkoutBook(book);
        return true;
    }
}