package com.twu.biblioteca.exceptions;

/**
 * MovieNotReturnable is responsible for handling exceptions for movies that are unavailable to return.
 *
 * @author Desiree Kelly
 * @version 2.0
 */
public class MovieNotReturnable extends Exception {

    public MovieNotReturnable(String msg) {
        super(msg);
    }
}