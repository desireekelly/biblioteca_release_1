package com.twu.biblioteca.controller;

import com.twu.biblioteca.exceptions.BookNotBorrowable;
import com.twu.biblioteca.exceptions.BookNotReturnable;
import com.twu.biblioteca.exceptions.MovieNotBorrowable;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Movie;

import java.util.List;

/**
 * LibraryController is responsible for updating the Library Model.
 *
 * @author Desiree Kelly
 * @version 1.0
 */
public class LibraryController {
    private BorrowService borrowService;
    private ReturnService returnService;
    private Library library;

    public LibraryController(Library library, BorrowService borrowService, ReturnService returnService) {
        this.borrowService = borrowService;
        this.returnService = returnService;
        this.library = library;
    }

    public boolean borrowBook(Book book) throws BookNotBorrowable {
        return borrowService.borrowBook(book);
    }

    public boolean returnBook(Book book) throws BookNotReturnable {
        return returnService.returnBook(book);
    }

    public boolean borrowMovie(Movie movie) throws MovieNotBorrowable{
        return borrowService.borrowMovie(movie);
    }

    public List<Book> getAvailableBooks() {
        return library.getAvailableBooks();
    }

    public List<Book> getBorrowedBooks() {
        return library.getBorrowedBooks();
    }

    public List<Movie> getAvailableMovies(){
        return library.getAvailableMovies();
    }

    public List<Movie> getBorrowedMovies(){
        return library.getBorrowedMovies();
    }

    public boolean availableBooksIsEmpty() {
        if (library.getAvailableBooks().isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean borrowedBooksIsEmpty() {
        if (library.getBorrowedBooks().isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean availableMoviesIsEmpty() {
        if (library.getAvailableMovies().isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean borrowedMoviesIsEmpty() {
        if (library.getBorrowedMovies().isEmpty()) {
            return true;
        }
        return false;
    }

    public int getAvailableBooksSize() {
        return library.getAvailableBooks().size();
    }

    public int getBorrowedBooksSize() {
        return library.getBorrowedBooks().size();
    }

    public int getAvailableMoviesSize() {
        return library.getAvailableMovies().size();
    }

    public int getBorrowedMoviesSize() {
        return library.getBorrowedMovies().size();
    }

    public String checkoutBook(int option) throws BookNotBorrowable {
            Book bookToBorrow = library.getAvailableBooks().get(option - 1);
            borrowBook(bookToBorrow);
        return bookToBorrow.getTitle().toString();
    }

    public String checkinBook(int option) throws BookNotReturnable {
            Book bookToReturn = library.getBorrowedBooks().get(option - 1);
            returnBook(bookToReturn);
        return bookToReturn.getTitle().toString();
    }

    public String checkoutMovie(int option) throws MovieNotBorrowable {
        Movie movieToBorrow = library.getAvailableMovies().get(option - 1);
        borrowMovie(movieToBorrow);
        return movieToBorrow.getName().toString();
    }
}