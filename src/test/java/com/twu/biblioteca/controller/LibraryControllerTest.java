package com.twu.biblioteca.controller;

import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.library.BorrowService;
import com.twu.biblioteca.library.LibraryController;
import com.twu.biblioteca.library.ReturnService;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.mockito.Matchers.any;

/**
 * Created by desiree on 10/12/2015.
 */
public class LibraryControllerTest {

    private BorrowService borrowService;
    private ReturnService returnService;
    private LibraryController libraryController;
    private Book book;


    @Before
    public void setUp() {
        borrowService = mock(BorrowService.class);
        returnService = mock(ReturnService.class);
        libraryController = new LibraryController(borrowService, returnService);
        book = new Book("Java 101", "Joe Bloggs", 1990);

    }

    @Test
    public void libraryShouldDelegateToBorrowServiceWhenBookBorrowed() {
        when(borrowService.borrowBook(any())).thenReturn(true);

        libraryController.borrowBook(book);

        verify(borrowService, times(1)).borrowBook(any());
    }

    @Test
    public void libraryShouldDelegateToReturnServiceWhenBookReturned(){
        when(returnService.returnBook(any())).thenReturn(true);

        libraryController.returnBook(book);

        verify(returnService, times(1)).returnBook(any());

    }

}