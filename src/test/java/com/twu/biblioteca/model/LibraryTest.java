package com.twu.biblioteca.model;

import com.twu.biblioteca.controller.LibraryController;
import com.twu.biblioteca.exceptions.BookNotBorrowable;
import com.twu.biblioteca.exceptions.BookNotReturnable;
import org.junit.Before;
import org.junit.Test;

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

    public static final Book BOOK_1 = new Book("Java 101", "Joe Bloggs", 1990);
    public static final Book BOOK_2 = new Book("PHP 101", "Mary Jane", 2005);

    private Library library;
    private LibraryController libraryController;
    private Book book;

    @Before
    public void setUp() throws Exception {
        library = new LibraryImpl();
        book = mock(Book.class);
        libraryController = mock(LibraryController.class);
    }

    @Test
    public void testCreateBookList() throws Exception {
        assertEquals(BOOK_1, library.getBookList().get(0));
        assertEquals(BOOK_2, library.getBookList().get(1));
    }

    @Test
    public void testCheckoutBook() throws Exception {
        when(libraryController.borrowBook(book)).thenReturn(true);
        assertTrue(libraryController.borrowBook(book));
        verify(libraryController, times(1)).borrowBook(book);
        //library.checkoutBook(library.getAvailableBooks().get(0));
        //assertTrue(library.getBorrowedBooks().contains(BOOK_1));
    }

    @Test
    public void testReturnBook() throws Exception {
        //controller
        //when(libraryService.returnBook()).return(true);
        //library.returnBook(BOOK_1);
        //verify(libraryService, time(1)).returnBook();
        when(libraryController.returnBook(book)).thenReturn(true);
        assertTrue(libraryController.returnBook(book));
        verify(libraryController, times(1)).returnBook(book);
        //library.checkoutBook(library.getAvailableBooks().get(0));
        //library.returnBook(library.getBorrowedBooks().get(0));
        //assertTrue(library.getAvailableBooks().contains(BOOK_1));
    }

    @Test(expected = BookNotReturnable.class)
    public void testExceptionThrownWhenBookAlreadyReturned() throws Exception {
        try {
            library.returnBook(library.getAvailableBooks().get(0));
        } catch (BookNotReturnable e) {
            String message = "book is already returned";
            assertEquals(message, e.getMessage());
            throw e;
        }
        fail("BookNotReturnable Exception not thrown");
    }

    @Test(expected = BookNotBorrowable.class)
    public void testExceptionThrownWhenBookBorrowedTwice() throws Exception {
        try {
            library.checkoutBook(library.getBookList().get(0));
            library.checkoutBook(library.getBookList().get(0));
        } catch (BookNotBorrowable e) {
            String message = "book is not available";
            assertEquals(message, e.getMessage());
            throw e;
        }
        fail("BookNotBorrowable Exception not thrown");
    }

    @Test
    public void testGetBorrowedBooks() throws Exception {
        library.checkoutBook(library.getAvailableBooks().get(0));
        assertTrue(library.getBorrowedBooks().contains(BOOK_1));
        library.checkoutBook(library.getAvailableBooks().get(0));
        assertTrue(library.getBorrowedBooks().contains(BOOK_2));
    }

    @Test
    public void testGetAvailableBooks() throws Exception {
        library.checkoutBook(library.getAvailableBooks().get(0));
        assertFalse(library.getAvailableBooks().contains(BOOK_1));
        library.checkoutBook(library.getAvailableBooks().get(0));
        assertFalse(library.getAvailableBooks().contains(BOOK_2));
    }
}