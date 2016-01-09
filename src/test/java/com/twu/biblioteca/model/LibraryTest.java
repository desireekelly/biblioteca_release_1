package com.twu.biblioteca.model;

import com.twu.biblioteca.exceptions.IncorrectLogin;
import com.twu.biblioteca.exceptions.ItemNotBorrowable;
import com.twu.biblioteca.exceptions.ItemNotReturnable;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Tests for the Library class.
 *
 * @author Desiree Kelly
 * @version 1.0
 * @see Library
 */
public class LibraryTest {

    private Library library;
    private BorrowableItem item;
    private User user;
    private Map<BorrowableItem, User> itemsCheckedOutByCustomers;
    private Library libraryMock;

    private static final Book BOOK_1 = new Book("Java 101", "Joe Bloggs", 1990);
    private static final Book BOOK_2 = new Book("PHP 101", "Mary Jane", 2005);
    private static final Book BOOK_3 = new Book("C# 101", "John Smith", 2010);
    private static final Book BOOK_4 = new Book("C++ 101", "Joyce Merry", 2001);

    private static final Movie MOVIE_1 = new Movie("The Matrix", 1999, "The Wachowski Brothers", "10");
    private static final Movie MOVIE_2 = new Movie("Inception", 2010, "Christopher Nolan", "8");
    private static final Movie MOVIE_3 = new Movie("Divergent", 2014, "Neil Burger", "Unrated");
    private static final Movie MOVIE_4 = new Movie("The Bourne Identity", 2002, "Doug Liman", "10");


    private static final User USER_1 = new User("Joe Bloggs", "joebloggs@joebloggs.com", "0400 000 000", "123-4566", "password1");
    private static final User USER_2 = new User("Jane Smith", "janesmith@janesmith.com", "0400 123 888", "123-4567", "password2");

    @Before
    public void setUp() throws Exception {
        library = new LibraryImpl();
        item = mock(BorrowableItem.class);
        user = mock(User.class);
        itemsCheckedOutByCustomers = mock(Map.class);
        libraryMock = mock(LibraryImpl.class);
    }

    @Test
    public void testAvailableBooksIsEmpty() throws Exception {
        assertFalse(library.availableBooksIsEmpty());
        library.checkoutItem(BOOK_1, USER_1);
        library.checkoutItem(BOOK_2, USER_2);
        library.checkoutItem(BOOK_3, USER_1);
        library.checkoutItem(BOOK_4, USER_2);
        assertTrue(library.availableBooksIsEmpty());
    }

    @Test
    public void testBorrowedBooksIsEmpty() throws Exception {
        assertTrue(library.borrowedBooksIsEmpty());
        library.checkoutItem(BOOK_1, USER_1);
        assertFalse(library.borrowedBooksIsEmpty());
    }

    @Test
    public void testAvailableMoviesIsEmpty() throws Exception {
        assertFalse(library.availableMoviesIsEmpty());
        library.checkoutItem(MOVIE_1, USER_1);
        library.checkoutItem(MOVIE_2, USER_2);
        library.checkoutItem(MOVIE_3, USER_1);
        library.checkoutItem(MOVIE_4, USER_2);
        assertTrue(library.availableMoviesIsEmpty());
    }

    @Test
    public void testBorrowedMoviesIsEmpty() throws Exception {
        assertTrue(library.borrowedMoviesIsEmpty());
        library.checkoutItem(MOVIE_1, USER_1);
        assertFalse(library.borrowedMoviesIsEmpty());
    }

    @Test
    public void testGetBorrowableItem() throws Exception {
        String description = "Java 101";
        assertTrue(library.getBorrowableItem(description) != null);
    }

    @Test
    public void testGetAvailableItems() throws Exception {
        assertTrue(library.getAvailableItems().contains(BOOK_1));
        library.checkoutItem(BOOK_2, USER_2);
        assertFalse(library.getAvailableItems().contains(BOOK_2));
    }

    @Test
    public void testGetBorrowedItems() throws Exception {
        library.checkoutItem(BOOK_1, USER_1);
        assertTrue(library.getBorrowedItems().contains(BOOK_1));
        library.returnItem(BOOK_1, USER_1);
        assertFalse(library.getBorrowedItems().contains(BOOK_1));
    }

    @Test
    public void testGetItemsCheckedOutByCustomers() throws Exception {
        when(libraryMock.getItemsCheckedOutByCustomers()).thenReturn(itemsCheckedOutByCustomers);
        assertEquals(libraryMock.getItemsCheckedOutByCustomers(), itemsCheckedOutByCustomers);
    }

    @Test
    public void testLogin() throws Exception {
        assertEquals(library.login("123-4566", "password1"), USER_1);
    }

    @Test
    public void testCheckoutItem() throws Exception {
        libraryMock.checkoutItem(item, user);
        verify(libraryMock, times(1)).checkoutItem(item, user);
    }

    @Test
    public void testReturnItem() throws Exception {
        libraryMock.returnItem(item, user);
        verify(libraryMock, times(1)).returnItem(item, user);
    }

    @Test(expected = ItemNotReturnable.class)
    public void testExceptionThrownWhenItemAlreadyReturned() throws Exception {
        library.returnItem(MOVIE_1, USER_1);
    }

    @Test(expected = ItemNotBorrowable.class)
    public void testExceptionThrownWhenItemBorrowedTwice() throws Exception {
        library.checkoutItem(MOVIE_2, USER_2);
        library.checkoutItem(MOVIE_2, USER_2);
    }

    @Test(expected = IncorrectLogin.class)
    public void testExceptionThrownWhenIncorrectLogin() throws Exception {
        library.login("jfsl", "fjlk");
    }
}