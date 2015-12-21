package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Library;

/**
 * LoginService is responsible for user login to the Library System.
 *
 * @author Desiree Kelly
 * @version 2.0
 */
public class LoginService {

    private Library library;

    public LoginService(Library library) {
        this.library = library;
    }

    public boolean login(String libraryNumber, String password) {
        library.login(libraryNumber, password);
        return true;
    }
}