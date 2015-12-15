package com.twu.biblioteca.model;

import com.twu.biblioteca.exceptions.BookNotBorrowable;
import com.twu.biblioteca.exceptions.BookNotReturnable;
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

    private static final Book BOOK_1 = new Book("Java 101", "Joe Bloggs", 1990);
    private static final Book BOOK_2 = new Book("PHP 101", "Mary Jane", 2005);

    private Library library;
    private Library libraryMock;
    private Book book;

    @Before
    public void setUp() throws Exception {
        library = new LibraryImpl();
        book = mock(Book.class);
        libraryMock = mock(LibraryImpl.class);
    }

    @Test
    public void testCreateBookList() throws Exception {
        assertEquals(BOOK_1, library.getBookList().get(0));
        assertEquals(BOOK_2, library.getBookList().get(1));
    }

    @Test
    public void testCheckoutBook() throws Exception {
        libraryMock.checkoutBook(book);
        verify(libraryMock).checkoutBook(Matchers.eq(book));
        verify(libraryMock, times(1)).checkoutBook(book);
    }

    @Test
    public void testReturnBook() throws Exception {
        libraryMock.returnBook(book);
        verify(libraryMock).returnBook(Matchers.eq(book));
        verify(libraryMock, times(1)).returnBook(book);
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