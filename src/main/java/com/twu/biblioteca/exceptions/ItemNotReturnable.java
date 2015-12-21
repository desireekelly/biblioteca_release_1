package com.twu.biblioteca.exceptions;

/**
 * ItemNotReturnable is responsible for handling exceptions for items that are unavailable to return.
 *
 * @author Desiree Kelly
 * @version 2.0
 */
public class ItemNotReturnable extends Exception {

    public ItemNotReturnable(String msg) {
        super(msg);
    }
}