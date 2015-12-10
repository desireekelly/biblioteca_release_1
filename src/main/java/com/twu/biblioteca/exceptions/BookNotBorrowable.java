package com.twu.biblioteca.exceptions;

/**
 * BookNotBorrowable is responsible for handling exceptions for books that are unavailable to borrow.
 *
 * @author Desiree Kelly
 * @version 1.0
 */
public class BookNotBorrowable extends Exception {

    public BookNotBorrowable(String msg) {
        super(msg);
    }
}