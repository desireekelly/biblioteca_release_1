package com.twu.biblioteca.controller;

import com.twu.biblioteca.exceptions.ItemNotReturnable;
import com.twu.biblioteca.model.BorrowableItem;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.User;

/**
 * ReturnService is responsible for returning a book to the Library
 *
 * @author Desiree Kelly
 * @version 1.0
 */
public class ReturnService {

    private Library library;

    public ReturnService(Library library) {
        this.library = library;
    }

    public boolean returnItem(BorrowableItem item, User user) throws ItemNotReturnable {
        library.returnItem(item, user);
        return true;
    }
}