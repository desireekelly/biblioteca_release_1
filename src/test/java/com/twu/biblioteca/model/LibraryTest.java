package com.twu.biblioteca.model;

import com.twu.biblioteca.exceptions.BookNotReturnable;
import com.twu.biblioteca.exceptions.IncorrectLogin;
import com.twu.biblioteca.exceptions.ItemNotBorrowable;
import com.twu.biblioteca.exceptions.MovieNotReturnable;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;

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
    private Book book;
    private Movie movie;
    private User user;
    private Library libraryMock;

    private static final Book BOOK_1 = new Book("Java 101", "Joe Bloggs", 1990);
    private static final Book BOOK_2 = new Book("PHP 101", "Mary Jane", 2005);

    private static final Movie MOVIE_1 = new Movie("The Matrix", 1999, "The Wachowski Brothers", "10");
    private static final Movie MOVIE_2 = new Movie("Inception", 2010, "Christopher Nolan", "8");

    private static final User USER_1 = new User("Joe Bloggs", "joebloggs@joebloggs.com", "0400 000 000", "123-4566", "f8kf93jd");
    private static final User USER_2 = new User("Jane Smith", "janesmith@janesmith.com", "0400 123 888", "123-4567", "5jgfdkl5");

    @Before
    public void setUp() throws Exception {
        library = new LibraryImpl();
        book = mock(Book.class);
        movie = mock(Movie.class);
        user = mock(User.class);
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
        assertTrue(library.getUsers().containsKey("123-4566"));
        assertTrue(library.getUsers().containsKey("123-4567"));
    }

    @Test
    public void testGetBooksCheckedOutByCustomersList() throws Exception {
        assertTrue(library.getBooksCheckedOutByCustomersList().contains("Ruby 101 is checked out by user: 123-4570\n"));
    }

    @Test
    public void testLogin() throws Exception {
        assertTrue(USER_1.equals(library.login("123-4566", "f8kf93jd")));
        assertTrue(USER_2.equals(library.login("123-4567", "5jgfdkl5")));
    }

    @Test
    public void testCheckoutBook() throws Exception {
        libraryMock.checkoutBook(book, user);
        verify(libraryMock, times(1)).checkoutBook(book, user);
    }

    @Test
    public void testReturnBook() throws Exception {
        libraryMock.returnBook(book, user);
        verify(libraryMock, times(1)).returnBook(book, user);
    }

    @Test
    public void testReturnMovie() throws Exception {
        libraryMock.returnMovie(movie);
        verify(libraryMock, times(1)).returnMovie(movie);
    }

    @Test(expected = BookNotReturnable.class)
    public void testExceptionThrownWhenBookAlreadyReturned() throws Exception {
        library.returnBook(library.getAvailableBooks().get(0), USER_1);
    }

    @Test(expected = ItemNotBorrowable.class)
    public void testExceptionThrownWhenBookBorrowedTwice() throws Exception {
        library.checkoutBook(library.getBookList().get(0), USER_1);
        library.checkoutBook(library.getBookList().get(0), USER_1);
    }

    @Test
    public void testGetBorrowedBooks() throws Exception {
        library.checkoutBook(library.getAvailableBooks().get(0), USER_1);
        assertTrue(library.getBorrowedBooks().contains(BOOK_1));
        library.checkoutBook(library.getAvailableBooks().get(0), USER_2);
        assertTrue(library.getBorrowedBooks().contains(BOOK_2));
    }

    @Test
    public void testGetAvailableBooks() throws Exception {
        library.checkoutBook(library.getAvailableBooks().get(0), USER_1);
        assertFalse(library.getAvailableBooks().contains(BOOK_1));
        library.checkoutBook(library.getAvailableBooks().get(0), USER_2);
        assertFalse(library.getAvailableBooks().contains(BOOK_2));
    }

    @Test
    public void testCheckoutMovie() throws Exception {
        libraryMock.checkoutMovie(movie);
        verify(libraryMock).checkoutMovie(Matchers.eq(movie));
        verify(libraryMock, times(1)).checkoutMovie(movie);
    }

    @Test
    public void testGetAvailableMovies() throws Exception {
        library.checkoutMovie(library.getAvailableMovies().get(0));
        assertFalse(library.getAvailableMovies().contains(MOVIE_1));
        library.checkoutMovie(library.getAvailableMovies().get(0));
        assertFalse(library.getAvailableMovies().contains(MOVIE_2));
    }

    @Test
    public void testGetBorrowedMovies() throws Exception {
        library.checkoutMovie(library.getAvailableMovies().get(0));
        assertTrue(library.getBorrowedMovies().contains(MOVIE_1));
        library.checkoutMovie(library.getAvailableMovies().get(0));
        assertTrue(library.getBorrowedMovies().contains(MOVIE_2));
    }

    @Test(expected = ItemNotBorrowable.class)
    public void testExceptionThrownWhenMovieBorrowedTwice() throws Exception {
        library.checkoutMovie(library.getMovieList().get(0));
        library.checkoutMovie(library.getMovieList().get(0));
    }

    @Test(expected = MovieNotReturnable.class)
    public void testExceptionThrownWhenMovieAlreadyReturned() throws Exception {
        library.returnMovie(library.getAvailableMovies().get(0));
    }

    @Test(expected = IncorrectLogin.class)
    public void testExceptionThrownWhenIncorrectLogin() throws Exception {
        library.login("jfsl", "fjlk");
    }
}