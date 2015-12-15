package com.twu.biblioteca.library;

import com.twu.biblioteca.book.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by desiree on 15/12/2015.
 */
public class UtilitiesTest {

    private List<Book> books;

    @Before
    public void setUp() throws Exception {
        books = new ArrayList<Book>();
    }

    @Test
    public void testFormatBookList() throws Exception {
        books.add(new Book("Java 101", "Joe Bloggs", 1990));
        books.add(new Book("PHP 101", "Mary Jane", 2005));
        assertEquals("1               Java 101        Joe Bloggs      1990           \n" +
                        "2               PHP 101         Mary Jane       2005           \n",
                Utilities.formatBookList(books).toString());
    }
}