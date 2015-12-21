package com.twu.biblioteca.model;

import com.twu.biblioteca.exceptions.IncorrectLogin;
import com.twu.biblioteca.exceptions.ItemNotBorrowable;
import com.twu.biblioteca.exceptions.ItemNotReturnable;

import java.util.List;
import java.util.Map;

/**
 * Library interface.
 * Library is responsible for holding the available and borrowed books.
 *
 * @author Desiree Kelly
 * @version 1.0
 */
public interface Library {

    List<Book> getAvailableBooks();

    List<Book> getBorrowedBooks();

    List<Book> getBookList();

    List<Movie> getAvailableMovies();

    List<Movie> getBorrowedMovies();

    List<Movie> getMovieList();

    Map<String, User> getUsers();

    User login(String libraryNumber, String password) throws IncorrectLogin;

    String getBooksCheckedOutByCustomersList();

    void checkoutItem(BorrowableItem item, User user) throws ItemNotBorrowable;

    void returnItem(BorrowableItem item, User user) throws ItemNotReturnable;
}