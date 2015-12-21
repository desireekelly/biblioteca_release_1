package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.BorrowableItem;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.User;
import org.junit.Before;
import org.junit.Test;

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

    private Library library;
    private BorrowService borrowService;
    private ReturnService returnService;
    private LoginService loginService;
    private LibraryController libraryController;

    private User user;
    private LibraryController libraryControllerMock;
    private BorrowableItem item;
    private static final String BOOK_TITLE = "Java 101";
    private static final String MOVIE_TITLE = "The Matrix";

    @Before
    public void setUp() throws Exception {
        library = mock(Library.class);
        borrowService = mock(BorrowService.class);
        returnService = mock(ReturnService.class);
        loginService = mock(LoginService.class);
        libraryController = new LibraryController(library, borrowService, returnService, loginService);
        item = mock(BorrowableItem.class);
        user = mock(User.class);
        libraryControllerMock = mock(LibraryController.class);
    }

    @Test
    public void libraryShouldDelegateToBorrowServiceWhenItemBorrowed() throws Exception {
        when(borrowService.borrowItem(item, user)).thenReturn(true);
        assertTrue(libraryController.borrowItem(item, user));
        verify(borrowService, times(1)).borrowItem(item, user);
    }

    @Test
    public void libraryShouldDelegateToReturnServiceWhenItemReturned() throws Exception {
        when(returnService.returnItem(item, user)).thenReturn(true);
        assertTrue(libraryController.returnItem(item, user));
        verify(returnService, times(1)).returnItem(item, user);
    }

    @Test
    public void libraryShouldDelegateToLoginServiceWhenUserLoginCalled() throws Exception {
        when(loginService.loginUser("123-4566", "f8kf93jd")).thenReturn(user);
        assertEquals(libraryController.loginUser("123-4566", "f8kf93jd"), user);
        verify(loginService, times(1)).loginUser("123-4566", "f8kf93jd");
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
    public void testCheckoutBookReturnsTitle() throws Exception {
        when(libraryControllerMock.checkoutBook(1)).thenReturn(BOOK_TITLE);
        assertEquals(libraryControllerMock.checkoutBook(1), BOOK_TITLE);
        verify(libraryControllerMock, times(1)).checkoutBook(1);
    }

    @Test
    public void testCheckoutMovieReturnsName() throws Exception {
        when(libraryControllerMock.checkoutMovie(1)).thenReturn(MOVIE_TITLE);
        assertEquals(libraryControllerMock.checkoutMovie(1), MOVIE_TITLE);
        verify(libraryControllerMock, times(1)).checkoutMovie(1);
    }

    @Test
    public void testCheckinBookReturnsTitle() throws Exception {
        when(libraryControllerMock.checkinBook(1)).thenReturn(BOOK_TITLE);
        assertEquals(libraryControllerMock.checkinBook(1), BOOK_TITLE);
        verify(libraryControllerMock, times(1)).checkinBook(1);
    }

    @Test
    public void testCheckinMovieReturnsName() throws Exception {
        when(libraryControllerMock.checkinMovie(1)).thenReturn(MOVIE_TITLE);
        assertEquals(libraryControllerMock.checkinMovie(1), MOVIE_TITLE);
        verify(libraryControllerMock, times(1)).checkinMovie(1);
    }

    @Test
    public void testBooksCheckedOutByCustomersListIsEmpty() throws Exception {
        when(libraryControllerMock.booksCheckedOutByCustomersListIsEmpty()).thenReturn(true);
        assertTrue(libraryControllerMock.booksCheckedOutByCustomersListIsEmpty());
        verify(libraryControllerMock, times(1)).booksCheckedOutByCustomersListIsEmpty();
    }
}