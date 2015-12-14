package com.twu.biblioteca.library;

import com.twu.biblioteca.book.Book;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Created by desiree on 10/12/2015.
 */
public class LibraryControllerTest {

    private BorrowService borrowService;
    private ReturnService returnService;
    private LibraryController libraryController;
    private Book book;
    private Library library;

    @Before
    public void setUp() throws Exception {
        borrowService = mock(BorrowService.class);
        returnService = mock(ReturnService.class);
        library = mock(Library.class);
        book = mock(Book.class);
        libraryController = new LibraryController(library, borrowService, returnService);
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
}