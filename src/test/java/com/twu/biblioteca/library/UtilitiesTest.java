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

    public static final Book BOOK_1 = new Book("Java 101", "Joe Bloggs", 1990);
    public static final Book BOOK_2 = new Book("PHP 101", "Mary Jane", 2005);

    private List<Book> books;

    @Before
    public void setUp() throws Exception {
        books = new ArrayList<Book>();
    }

    @Test
    public void testDisplayFormattedBookList() throws Exception {
        books.add(BOOK_1);
        books.add(BOOK_2);
        assertEquals("1               Java 101        Joe Bloggs      1990           \n" +
                        "2               PHP 101         Mary Jane       2005           \n",
                Utilities.formatBookList(books).toString());
    }
}