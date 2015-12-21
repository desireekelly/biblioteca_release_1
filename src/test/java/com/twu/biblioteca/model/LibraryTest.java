package com.twu.biblioteca.model;

import com.twu.biblioteca.exceptions.IncorrectLogin;
import com.twu.biblioteca.exceptions.ItemNotBorrowable;
import com.twu.biblioteca.exceptions.ItemNotReturnable;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
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
    private List<User> users;
    private Library libraryMock;

    private static final Book BOOK_1 = new Book("Java 101", "Joe Bloggs", 1990);
    private static final Book BOOK_2 = new Book("PHP 101", "Mary Jane", 2005);

    private static final Movie MOVIE_1 = new Movie("The Matrix", 1999, "The Wachowski Brothers", "10");
    private static final Movie MOVIE_2 = new Movie("Inception", 2010, "Christopher Nolan", "8");

    private static final User USER_1 = new User("Joe Bloggs", "joebloggs@joebloggs.com", "0400 000 000", "123-4566", "password1");
    private static final User USER_2 = new User("Jane Smith", "janesmith@janesmith.com", "0400 123 888", "123-4567", "password2");

    @Before
    public void setUp() throws Exception {
        library = new LibraryImpl();
        item = mock(BorrowableItem.class);
        user = mock(User.class);
        itemsCheckedOutByCustomers = mock(Map.class);
        users = mock(List.class);
        libraryMock = mock(LibraryImpl.class);
    }

    @Test
    public void testCreateBookList() throws Exception {
        assertEquals(BOOK_1, library.getBookList().get(0));
        assertEquals(BOOK_2, library.getBookList().get(1));
    }

    @Test
    public void testCreateMovieList() throws Exception {
        assertEquals(MOVIE_1, library.getMovieList().get(0));
        assertEquals(MOVIE_2, library.getMovieList().get(1));
    }

    @Test
    public void testCreateUsers() throws Exception {
        when(libraryMock.getUsers()).thenReturn(users);
        assertEquals(libraryMock.getUsers(), users);
    }

    @Test
    public void testGetItemsCheckedOutByCustomers() throws Exception {
        when(libraryMock.getItemsCheckedOutByCustomers()).thenReturn(itemsCheckedOutByCustomers);
        assertEquals(libraryMock.getItemsCheckedOutByCustomers(), itemsCheckedOutByCustomers);
    }

    @Test
    public void testLogin() throws Exception {
        when(libraryMock.login("123-4566", "f8kf93jd")).thenReturn(user);
        assertEquals(libraryMock.login("123-4566", "f8kf93jd"), user);
        verify(libraryMock, times(1)).login("123-4566", "f8kf93jd");
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
        library.returnItem(library.getAvailableBooks().get(0), USER_1);
    }

    @Test(expected = ItemNotBorrowable.class)
    public void testExceptionThrownWhenItemBorrowedTwice() throws Exception {
        library.checkoutItem(library.getBookList().get(0), USER_1);
        library.checkoutItem(library.getBookList().get(0), USER_1);
    }

    @Test
    public void testGetBorrowedBooks() throws Exception {
        library.checkoutItem(library.getAvailableBooks().get(0), USER_1);
        assertTrue(library.getBorrowedBooks().contains(BOOK_1));
        library.checkoutItem(library.getAvailableBooks().get(0), USER_2);
        assertTrue(library.getBorrowedBooks().contains(BOOK_2));
    }

    @Test
    public void testGetAvailableBooks() throws Exception {
        library.checkoutItem(library.getAvailableBooks().get(0), USER_1);
        assertFalse(library.getAvailableBooks().contains(BOOK_1));
        library.checkoutItem(library.getAvailableBooks().get(0), USER_2);
        assertFalse(library.getAvailableBooks().contains(BOOK_2));
    }

    @Test
    public void testGetAvailableMovies() throws Exception {
        library.checkoutItem(library.getAvailableMovies().get(0), USER_1);
        assertFalse(library.getAvailableMovies().contains(MOVIE_1));
        library.checkoutItem(library.getAvailableMovies().get(0), USER_1);
        assertFalse(library.getAvailableMovies().contains(MOVIE_2));
    }

    @Test
    public void testGetBorrowedMovies() throws Exception {
        library.checkoutItem(library.getAvailableMovies().get(0), USER_1);
        assertTrue(library.getBorrowedMovies().contains(MOVIE_1));
        library.checkoutItem(library.getAvailableMovies().get(0), USER_1);
        assertTrue(library.getBorrowedMovies().contains(MOVIE_2));
    }

    @Test(expected = IncorrectLogin.class)
    public void testExceptionThrownWhenIncorrectLogin() throws Exception {
        library.login("jfsl", "fjlk");
    }
}