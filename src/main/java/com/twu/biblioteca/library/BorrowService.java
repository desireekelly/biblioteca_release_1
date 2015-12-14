package com.twu.biblioteca.library;

import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.exceptions.BookNotBorrowable;

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
