package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Book;

import java.util.List;

/**
 * utilities is responsible for formatting a list of books into columns.
 *
 * @author Desiree Kelly
 * @version 1.0
 */
public class Utilities {

    /**
     * Get a list of books.
     *
     * @return Returns a formatted list of books in columns.
     */
    public static String formatBookList(List<Book> bookList) {
        String formattedBookList = "";
        int index = 0;

        for (Book book : bookList) {
            index++;
            formattedBookList += String.format("%-15d %-15s %-15s %-15d\n", index, book.getTitle(), book.getAuthor(), book.getYearPublished());
        }
        return formattedBookList;
    }
}