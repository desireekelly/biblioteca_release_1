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

    BorrowableItem getBorrowableItem(String description);

    List<BorrowableItem> getBorrowedItems();

    List<BorrowableItem> getAvailableItems();

    boolean availableBooksIsEmpty();

    boolean borrowedBooksIsEmpty();

    boolean availableMoviesIsEmpty();

    boolean borrowedMoviesIsEmpty();

    /*
    List<Book> getBookList();

    List<Movie> getAvailableMovies();

    List<Movie> getBorrowedMovies();

    List<Movie> getMovieList();
    */
    Map<String, User> getUsers();

    User login(String libraryNumber, String password) throws IncorrectLogin;

    Map<BorrowableItem, User> getItemsCheckedOutByCustomers();

    void checkoutItem(BorrowableItem item, User user) throws ItemNotBorrowable;

    void returnItem(BorrowableItem item, User user) throws ItemNotReturnable;
}