package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
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
    private Library library;

    @Before
    public void setUp() throws Exception {
        borrowService = mock(BorrowService.class);
        returnService = mock(ReturnService.class);
        library = mock(Library.class);
        book = mock(Book.class);
        libraryController = new LibraryController(library, borrowService, returnService);
        libraryControllerMock = mock(LibraryController.class);
    }

    @Test
    public void libraryShouldDelegateToBorrowServiceWhenBookBorrowed() throws Exception {
        when(borrowService.borrowBook(book)).thenReturn(true);
        assertTrue(libraryController.borrowBook(book));
        verify(borrowService, times(1)).borrowBook(book);
    }

    @Test
    public void libraryShouldDelegateToReturnServiceWhenBookReturned() throws Exception {
        when(returnService.returnBook(book)).thenReturn(true);
        assertTrue(libraryController.returnBook(book));
        verify(returnService, times(1)).returnBook(book);
    }

    @Test
    public void testBorrowBook() throws Exception {
        when(libraryControllerMock.borrowBook(book)).thenReturn(true);
        assertTrue(libraryControllerMock.borrowBook(book));
        verify(libraryControllerMock, times(1)).borrowBook(book);
    }

    @Test
    public void testReturnBook() throws Exception {
        when(libraryControllerMock.returnBook(book)).thenReturn(true);
        assertTrue(libraryControllerMock.returnBook(book));
        verify(libraryControllerMock, times(1)).returnBook(book);
    }

    @Test
    public void testGetAvailableBooks() throws Exception {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Java 101", "Joe Bloggs", 1990));
        books.add(new Book("PHP 101", "Mary Jane", 2005));
        when(libraryControllerMock.getAvailableBooks()).thenReturn(books);
        assertEquals(libraryControllerMock.getAvailableBooks(), books);
        verify(libraryControllerMock, times(1)).getAvailableBooks();
    }

    @Test
    public void testGetBorrowedBooks() throws Exception {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Java 101", "Joe Bloggs", 1990));
        books.add(new Book("PHP 101", "Mary Jane", 2005));
        when(libraryControllerMock.getBorrowedBooks()).thenReturn(books);
        assertEquals(libraryControllerMock.getBorrowedBooks(), books);
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
        when(libraryControllerMock.checkoutBook(1)).thenReturn("Book 1");
        assertEquals(libraryControllerMock.checkoutBook(1), "Book 1");
        verify(libraryControllerMock, times(1)).checkoutBook(1);
    }

    @Test
    public void testCheckinBook() throws Exception {
        when(libraryControllerMock.checkinBook(1)).thenReturn("Book 1");
        assertEquals(libraryControllerMock.checkinBook(1), "Book 1");
        verify(libraryControllerMock, times(1)).checkinBook(1);
    }
}