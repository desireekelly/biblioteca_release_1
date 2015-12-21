package com.twu.biblioteca.exceptions;

/**
 * ItemNotBorrowable is responsible for handling exceptions for items that are unavailable to borrow.
 *
 * @author Desiree Kelly
 * @version 2.0
 */
public class ItemNotBorrowable extends Exception {

    public ItemNotBorrowable(String msg) {
        super(msg);
    }
}