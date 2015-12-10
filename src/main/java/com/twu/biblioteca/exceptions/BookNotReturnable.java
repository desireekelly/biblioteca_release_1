package com.twu.biblioteca.exceptions;

/**
 * BookNotReturnable is responsible for handling exceptions for books that are unavailable to return.
 *
 * @author Desiree Kelly
 * @version 1.0
 */
public class BookNotReturnable extends Exception {

    public BookNotReturnable(String msg) {
        super(msg);
    }
}