package com.twu.biblioteca.controller;

import com.twu.biblioteca.exceptions.IncorrectLogin;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.User;

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

    public User loginUser(String libraryNumber, String password) throws IncorrectLogin {
        User user = library.login(libraryNumber, password);
        return user;
    }
}