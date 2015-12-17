package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Tests for the LibraryController class.
 *
 * @author Desiree Kelly
 * @version 1.0
 * @see LibraryController
 */
public class LibraryControllerTest {

    private BorrowService borrowService;
    private ReturnService returnService;
    private LibraryController libraryController;
    private LibraryController libraryControllerMock;
    private Book book;
    private Movie movie;
    private User user;

    private Library library;

    private List<Book> bookList;
    private List<Movie> movieList;

    private static final String BOOK_TITLE = "Java 101";
    private static final String MOVIE_TITLE = "The Matrix";
    private static final User USER_1 = new User("Joe Bloggs", "joebloggs@joebloggs.com", "0400 000 000", "123-4566", "f8kf93jd");

    @Before
    public void setUp() throws Exception {
        borrowService = mock(BorrowService.class);
        returnService = mock(ReturnService.class);
        library = mock(Library.class);
        book = mock(Book.class);
        movie = mock(Movie.class);
        user = mock(User.class);
        libraryControllerMock = mock(LibraryController.class);

        libraryController = new LibraryController(library, borrowService, returnService);

        bookList = new ArrayList<Book>();
        bookList.add(new Book("Java 101", "Joe Bloggs", 1990));
        bookList.add(new Book("PHP 101", "Mary Jane", 2005));

        movieList = new ArrayList<Movie>();
        movieList.add(new Movie("The Matrix", 1999, "The Wachowski Brothers", "10"));
        movieList.add(new Movie("Inception", 2010, "Christopher Nolan", "8"));
    }

    @Test
    public void libraryShouldDelegateToBorrowServiceWhenBookBorrowed() throws Exception {
        when(borrowService.borrowBook(book, user)).thenReturn(true);
        assertTrue(libraryController.borrowBook(book, user));
        verify(borrowService, times(1)).borrowBook(book, user);
    }

    @Test
    public void libraryShouldDelegateToReturnServiceWhenBookReturned() throws Exception {
        when(returnService.returnBook(book, user)).thenReturn(true);
        assertTrue(libraryController.returnBook(book, user));
        verify(returnService, times(1)).returnBook(book, user);
    }

    @Test
    public void libraryShouldDelegateToBorrowServiceWhenMovieBorrowed() throws Exception {
        when(borrowService.borrowMovie(movie)).thenReturn(true);
        assertTrue(libraryController.borrowMovie(movie));
        verify(borrowService, times(1)).borrowMovie(movie);
    }

    @Test
    public void testBorrowBook() throws Exception {
        when(libraryControllerMock.borrowBook(book, user)).thenReturn(true);
        assertTrue(libraryControllerMock.borrowBook(book, user));
        verify(libraryControllerMock, times(1)).borrowBook(book, user);
    }

    @Test
    public void testReturnBook() throws Exception {
        when(libraryControllerMock.returnBook(book, user)).thenReturn(true);
        assertTrue(libraryControllerMock.returnBook(book, user));
        verify(libraryControllerMock, times(1)).returnBook(book, user);
    }

    @Test
    public void testGetAvailableBooks() throws Exception {
        when(libraryControllerMock.getAvailableBooks()).thenReturn(bookList);
        assertEquals(libraryControllerMock.getAvailableBooks(), bookList);
        verify(libraryControllerMock, times(1)).getAvailableBooks();
    }

    @Test
    public void testGetBorrowedBooks() throws Exception {
        when(libraryControllerMock.getBorrowedBooks()).thenReturn(bookList);
        assertEquals(libraryControllerMock.getBorrowedBooks(), bookList);
        verify(libraryControllerMock, times(1)).getBorrowedBooks();
    }

    @Test
    public void testAvailableBooksIsEmpty() throws Exception {
        when(libraryControllerMock.availableBooksIsEmpty()).thenReturn(true);
        assertTrue(libraryControllerMock.availableBooksIsEmpty());
        verify(libraryControllerMock, times(1)).availableBooksIsEmpty();
    }

    @Test
    public void testBorrowedBooksIsEmpty() throws Exception {
        when(libraryControllerMock.borrowedBooksIsEmpty()).thenReturn(true);
        assertTrue(libraryControllerMock.borrowedBooksIsEmpty());
        verify(libraryControllerMock, times(1)).borrowedBooksIsEmpty();
    }

    @Test
    public void testGetAvailableBooksSize() throws Exception {
        when(libraryControllerMock.getAvailableBooksSize()).thenReturn(4);
        assertEquals(libraryControllerMock.getAvailableBooksSize(), 4);
        verify(libraryControllerMock, times(1)).getAvailableBooksSize();
    }

    @Test
    public void testGetBorrowedBooksSize() throws Exception {
        when(libraryControllerMock.getBorrowedBooksSize()).thenReturn(4);
        assertEquals(libraryControllerMock.getBorrowedBooksSize(), 4);
        verify(libraryControllerMock, times(1)).getBorrowedBooksSize();
    }

    @Test
    public void testCheckoutBook() throws Exception {
        when(libraryControllerMock.checkoutBook(1)).thenReturn(BOOK_TITLE);
        assertEquals(libraryControllerMock.checkoutBook(1), BOOK_TITLE);
        verify(libraryControllerMock, times(1)).checkoutBook(1);
    }

    @Test
    public void testCheckinBook() throws Exception {
        when(libraryControllerMock.checkinBook(1)).thenReturn(BOOK_TITLE);
        assertEquals(libraryControllerMock.checkinBook(1), BOOK_TITLE);
        verify(libraryControllerMock, times(1)).checkinBook(1);
    }

    @Test
    public void testBorrowMovie() throws Exception {
        when(libraryControllerMock.borrowMovie(movie)).thenReturn(true);
        assertTrue(libraryControllerMock.borrowMovie(movie));
        verify(libraryControllerMock, times(1)).borrowMovie(movie);
    }

    @Test
    public void testGetAvailableMovies() throws Exception {
        when(libraryControllerMock.getAvailableMovies()).thenReturn(movieList);
        assertEquals(libraryControllerMock.getAvailableMovies(), movieList);
        verify(libraryControllerMock, times(1)).getAvailableMovies();
    }

    @Test
    public void testGetBorrowedMovies() throws Exception {
        when(libraryControllerMock.getBorrowedMovies()).thenReturn(movieList);
        assertEquals(libraryControllerMock.getBorrowedMovies(), movieList);
        verify(libraryControllerMock, times(1)).getBorrowedMovies();
    }

    @Test
    public void testAvailableMoviesIsEmpty() throws Exception {
        when(libraryControllerMock.availableMoviesIsEmpty()).thenReturn(true);
        assertTrue(libraryControllerMock.availableMoviesIsEmpty());
        verify(libraryControllerMock, times(1)).availableMoviesIsEmpty();
    }

    @Test
    public void testBorrowedMoviesIsEmpty() throws Exception {
        when(libraryControllerMock.borrowedMoviesIsEmpty()).thenReturn(true);
        assertTrue(libraryControllerMock.borrowedMoviesIsEmpty());
        verify(libraryControllerMock, times(1)).borrowedMoviesIsEmpty();
    }

    @Test
    public void testGetAvailableMoviesSize() throws Exception {
        when(libraryControllerMock.getAvailableMoviesSize()).thenReturn(4);
        assertEquals(libraryControllerMock.getAvailableMoviesSize(), 4);
        verify(libraryControllerMock, times(1)).getAvailableMoviesSize();
    }

    @Test
    public void testGetBorrowedMoviesSize() throws Exception {
        when(libraryControllerMock.getBorrowedMoviesSize()).thenReturn(4);
        assertEquals(libraryControllerMock.getBorrowedMoviesSize(), 4);
        verify(libraryControllerMock, times(1)).getBorrowedMoviesSize();
    }

    @Test
    public void testCheckoutMovie() throws Exception {
        when(libraryControllerMock.checkoutMovie(1)).thenReturn(MOVIE_TITLE);
        assertEquals(libraryControllerMock.checkoutMovie(1), MOVIE_TITLE);
        verify(libraryControllerMock, times(1)).checkoutMovie(1);
    }

    @Test
    public void testLogin() throws Exception {
        when(libraryControllerMock.login("123-4566", "f8kf93jd")).thenReturn(USER_1);
        assertTrue(USER_1.equals(libraryControllerMock.login("123-4566", "f8kf93jd")));
        verify(libraryControllerMock, times(1)).login("123-4566", "f8kf93jd");
    }

    @Test
    public void testGetCustomerInformation() throws Exception {
        when(libraryControllerMock.getCustomerInformation()).thenReturn("Name: Joe Bloggs\nEmail: joebloggs@joebloggs.com\nPhone Number: 0400 000 000");
        assertEquals(libraryControllerMock.getCustomerInformation(), "Name: Joe Bloggs\nEmail: joebloggs@joebloggs.com\nPhone Number: 0400 000 000");
        verify(libraryControllerMock, times(1)).getCustomerInformation();
    }

    @Test
    public void testGetCustomerName() throws Exception {
        when(libraryControllerMock.getUserName()).thenReturn("Joe Bloggs");
        assertEquals(libraryControllerMock.getUserName(), "Joe Bloggs");
    }

    @Test
    public void testIsCustomer() throws Exception {
        when(libraryControllerMock.isCustomer()).thenReturn(true);
        assertTrue(libraryControllerMock.isCustomer());
    }

    @Test
    public void testIsLibrarian() throws Exception {
        when(libraryControllerMock.isLibrarian()).thenReturn(true);
        assertTrue(libraryControllerMock.isLibrarian());
    }

    @Test
    public void testBooksCheckedOutByCustomersListIsEmpty() throws Exception {
        when(libraryControllerMock.booksCheckedOutByCustomersListIsEmpty()).thenReturn(true);
        assertTrue(libraryControllerMock.booksCheckedOutByCustomersListIsEmpty());
        verify(libraryControllerMock, times(1)).booksCheckedOutByCustomersListIsEmpty();
    }


    @Test
    public void testGetBooksCheckedOutByCustomersList() throws Exception {
        when(libraryControllerMock.getBooksCheckedOutByCustomersList()).thenReturn("Ruby 101 is checked out by user: 123-4570\n");
        assertEquals(libraryControllerMock.getBooksCheckedOutByCustomersList(), "Ruby 101 is checked out by user: 123-4570\n");
        verify(libraryControllerMock, times(1)).getBooksCheckedOutByCustomersList();
    }

}