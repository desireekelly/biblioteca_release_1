package com.twu.biblioteca.controller;

import com.twu.biblioteca.exceptions.BookNotBorrowable;
import com.twu.biblioteca.exceptions.BookNotReturnable;
import com.twu.biblioteca.exceptions.MovieNotBorrowable;
import com.twu.biblioteca.exceptions.MovieNotReturnable;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.User;

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
    private User user;

    public LibraryController(Library library, BorrowService borrowService, ReturnService returnService) {
        this.borrowService = borrowService;
        this.returnService = returnService;
        this.library = library;
    }

    public boolean borrowBook(Book book, User user) throws BookNotBorrowable {
        return borrowService.borrowBook(book, user);
    }

    public boolean returnBook(Book book, User user) throws BookNotReturnable {
        return returnService.returnBook(book, user);
    }

    public boolean borrowMovie(Movie movie) throws MovieNotBorrowable{
        return borrowService.borrowMovie(movie);
    }

    public boolean returnMovie(Movie movie) throws MovieNotReturnable {
        return returnService.returnMovie(movie);
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
        borrowBook(bookToBorrow, user);
        return bookToBorrow.getTitle().toString();
    }

    public String checkinBook(int option) throws BookNotReturnable {
        Book bookToReturn = library.getBorrowedBooks().get(option - 1);
        returnBook(bookToReturn, user);
        return bookToReturn.getTitle().toString();
    }

    public String checkoutMovie(int option) throws MovieNotBorrowable {
        Movie movieToBorrow = library.getAvailableMovies().get(option - 1);
        borrowMovie(movieToBorrow);
        return movieToBorrow.getName().toString();
    }

    public String checkinMovie(int option) throws MovieNotReturnable {
        Movie movieToReturn = library.getBorrowedMovies().get(option - 1);
        returnMovie(movieToReturn);
        return movieToReturn.getName().toString();
    }

    public User login(String libraryNumber, String password) {
        user = library.login(libraryNumber, password);
        return user;
    }

    public String getCustomerInformation() {
        return user.getCustomerInformation();
    }

    public String getUserName() {
        return user.getName();
    }

    public boolean isLibrarian() {
        return user.isLibrarian();
    }

    public boolean booksCheckedOutByCustomersListIsEmpty() {
        if (library.getBooksCheckedOutByCustomersList() == null) {
            return true;
        }
        return false;
    }

    public String getBooksCheckedOutByCustomersList() {
        return library.getBooksCheckedOutByCustomersList();
    }
}