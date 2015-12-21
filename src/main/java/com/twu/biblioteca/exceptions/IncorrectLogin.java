package com.twu.biblioteca.exceptions;

/**
 * IncorrectLogin is responsible for handling exceptions for user login to the Library System.
 *
 * @author Desiree Kelly
 * @version 2.0
 */
public class IncorrectLogin extends Exception {

    public IncorrectLogin(String msg) {
        super(msg);
    }
}