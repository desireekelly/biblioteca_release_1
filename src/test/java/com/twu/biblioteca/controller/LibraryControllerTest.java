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
    private BorrowableItem item;

    @Before
    public void setUp() throws Exception {
        library = mock(Library.class);
        borrowService = mock(BorrowService.class);
        returnService = mock(ReturnService.class);
        loginService = mock(LoginService.class);
        libraryController = new LibraryController(library, borrowService, returnService, loginService);
        user = mock(User.class);
        item = mock(BorrowableItem.class);
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
}