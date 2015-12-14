package com.twu.biblioteca.menu;

import com.twu.biblioteca.utilities.Messages;

import java.io.PrintStream;

/**
 * Created by desiree on 10/12/2015.
 */
public class BorrowMenuImpl {

    private PrintStream outputStream;
    private Messages messages;

    public BorrowMenuImpl(PrintStream outputStream, Messages messages) {
        this.outputStream = outputStream;
        this.messages = messages;
    }
}
