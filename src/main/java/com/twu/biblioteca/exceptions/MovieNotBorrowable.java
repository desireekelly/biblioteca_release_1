package com.twu.biblioteca.exceptions;

/**
 * MovieNotBorrowable is responsible for handling exceptions for movies that are unavailable to borrow.
 *
 * @author Desiree Kelly
 * @version 2.0
 */
public class MovieNotBorrowable extends Exception {

    public MovieNotBorrowable(String msg) {
        super(msg);
    }
}