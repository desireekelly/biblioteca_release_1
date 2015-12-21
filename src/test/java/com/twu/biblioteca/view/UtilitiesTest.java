package com.twu.biblioteca.view;


import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.BorrowableItem;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.User;
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

    @Test
    public void testFormatBookList() throws Exception {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Java 101", "Joe Bloggs", 1990));
        books.add(new Book("PHP 101", "Mary Jane", 2005));
        assertEquals("1               Java 101        Joe Bloggs      1990           \n" +
                        "2               PHP 101         Mary Jane       2005           \n",
                Utilities.formatBookList(books).toString());
    }

    @Test
    public void testDisplayFormatMovieList() throws Exception {
        List<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("The Matrix", 1999, "The Wachowski Brothers", "10"));
        movies.add(new Movie("Inception", 2010, "Christopher Nolan", "8"));
        assertEquals("1                    The Matrix                     1999                 The Wachowski Brothers              10                  \n" +
                        "2                    Inception                      2010                 Christopher Nolan                   8                   \n",
                Utilities.formatMovieList(movies).toString());
    }

    @Test
    public void testFormatGetItemsCheckedOutByCustomers() throws Exception {
        Map<BorrowableItem, User> itemsCheckedOutByCustomers = new HashMap<BorrowableItem, User>();
        Book book1 = new Book("Ruby 101", "Jenny Moore", 2013);
        User user1 = new User("Bob Kent", "bobkent@bobkent.com", "0400 575 838", "123-4570", "4jv03m20");
        Book book2 = new Book("Web Development 101", "Mark Green", 2014);
        User user2 = new User("Mary Jane", "maryjane@maryjane.com", "0400 738 939", "123-4571", "3kv93m0c");
        itemsCheckedOutByCustomers.put(book1, user1);
        itemsCheckedOutByCustomers.put(book2, user2);
        assertEquals("Ruby 101 is checked out by user: 123-4570\n" +
                "Web Development 101 is checked out by user: 123-4571\n", Utilities.formatGetItemsCheckedOutByCustomers(itemsCheckedOutByCustomers));
    }
}