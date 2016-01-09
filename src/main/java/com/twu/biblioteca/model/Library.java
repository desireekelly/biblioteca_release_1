package com.twu.biblioteca.model;

import com.twu.biblioteca.exceptions.IncorrectLogin;
import com.twu.biblioteca.exceptions.ItemNotBorrowable;
import com.twu.biblioteca.exceptions.ItemNotReturnable;

import java.util.List;
import java.util.Map;

/**
 * Library interface.
 * Library is responsible for holding the available and borrowed items.
 *
 * @author Desiree Kelly
 * @version 1.0
 */
public interface Library {

    BorrowableItem getBorrowableItem(String description, String type);

    BorrowableItem getBookItem(String description);

    BorrowableItem getMovieItem(String description);

    List<BorrowableItem> getAvailableItems();

    List<BorrowableItem> getBorrowedItems();

    boolean availableBooksIsEmpty();

    boolean borrowedBooksIsEmpty();

    boolean availableMoviesIsEmpty();

    boolean borrowedMoviesIsEmpty();

    boolean itemsCheckedOutByCustomersIsEmpty();

    Map<BorrowableItem, User> getItemsCheckedOutByCustomers();

    User login(String libraryNumber, String password) throws IncorrectLogin;

    void checkoutItem(BorrowableItem item, User user) throws ItemNotBorrowable;

    void returnItem(BorrowableItem item, User user) throws ItemNotReturnable;
}