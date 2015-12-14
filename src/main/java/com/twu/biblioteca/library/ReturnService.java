package com.twu.biblioteca.library;

import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.exceptions.BookNotReturnable;

/**
 * Created by desiree on 13/12/2015.
 */
public class ReturnService {

    private Library library;

    public ReturnService(Library library) {
        this.library = library;
    }

    public boolean returnBook(Book book) throws BookNotReturnable {
        library.returnBook(book);
        return true;
    }
}
