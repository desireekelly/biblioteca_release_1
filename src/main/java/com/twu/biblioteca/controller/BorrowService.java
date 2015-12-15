package com.twu.biblioteca.controller;

import com.twu.biblioteca.exceptions.BookNotBorrowable;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;

/**
 * Created by desiree on 13/12/2015.
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
