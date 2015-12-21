package com.twu.biblioteca.controller;

import com.twu.biblioteca.exceptions.ItemNotBorrowable;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.User;

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

    public boolean borrowBook(Book book, User user) throws ItemNotBorrowable {
        library.checkoutBook(book, user);
        return true;
    }

    public boolean borrowMovie(Movie movie) throws ItemNotBorrowable {
        library.checkoutMovie(movie);
        return true;
    }
}