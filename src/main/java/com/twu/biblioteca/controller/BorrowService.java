package com.twu.biblioteca.controller;

import com.twu.biblioteca.exceptions.ItemNotBorrowable;
import com.twu.biblioteca.model.BorrowableItem;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.User;

/**
 * BorrowService is responsible for borrowing an item from the Library
 *
 * @author Desiree Kelly
 * @version 1.0
 */
public class BorrowService {

    private Library library;

    public BorrowService(Library library) {
        this.library = library;
    }

    public boolean borrowItem(BorrowableItem item, User user) throws ItemNotBorrowable {
        library.checkoutItem(item, user);
        return true;
    }
}