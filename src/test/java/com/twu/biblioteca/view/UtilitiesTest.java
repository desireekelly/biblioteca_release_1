package com.twu.biblioteca.view;


import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.BorrowableItem;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the Utilities class.
 *
 * @author Desiree Kelly
 * @version 1.0
 * @see Utilities
 */
public class UtilitiesTest {

    private List<BorrowableItem> items;

    @Before
    public void setUp() throws Exception {
        items = new ArrayList<BorrowableItem>();
    }

    @Test
    public void testFormatBooks() throws Exception {
        items.add(new Book("Java 101", "Joe Bloggs", 1990));
        items.add(new Book("PHP 101", "Mary Jane", 2005));
        assertEquals("0               Java 101        Joe Bloggs      1990           \n" +
                        "1               PHP 101         Mary Jane       2005           \n",
                Utilities.formatBooks(items).toString());
    }

    @Test
    public void testDisplayFormatMovies() throws Exception {
        items.add(new Movie("The Matrix", 1999, "The Wachowski Brothers", "10"));
        items.add(new Movie("Inception", 2010, "Christopher Nolan", "8"));
        assertEquals("0                    The Matrix                     1999                 The Wachowski Brothers              10                  \n" +
                        "1                    Inception                      2010                 Christopher Nolan                   8                   \n",
                Utilities.formatMovies(items).toString());
    }

    @Test
    public void testFormatGetItemsCheckedOutByCustomers() throws Exception {
        Map<BorrowableItem, User> itemsCheckedOutByCustomers = new HashMap<BorrowableItem, User>();
        Book book1 = new Book("Ruby 101", "Jenny Moore", 2013);
        User user1 = new User("Bob Kent", "bobkent@bobkent.com", "0400 575 838", "123-4570", "4jv03m20");
        itemsCheckedOutByCustomers.put(book1, user1);
        assertEquals("Ruby 101 is checked out by user: 123-4570\n", Utilities.formatGetItemsCheckedOutByCustomers(itemsCheckedOutByCustomers));
    }
}