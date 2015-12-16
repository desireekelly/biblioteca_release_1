package com.twu.biblioteca.model;

import com.twu.biblioteca.exceptions.BookNotBorrowable;
import com.twu.biblioteca.exceptions.BookNotReturnable;
import com.twu.biblioteca.exceptions.MovieNotBorrowable;

import java.util.List;

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

    void checkoutBook(Book book) throws BookNotBorrowable;

    void returnBook(Book book) throws BookNotReturnable;

    List<Movie> getAvailableMovies();

    List<Movie> getBorrowedMovies();

    List<Movie> getMovieList();

    void checkoutMovie(Movie movie) throws MovieNotBorrowable;

    List<User> getUserList();

    String getBooksCheckedOutByCustomer(String bookTitle);
}