package com.twu.biblioteca.controller;

import com.twu.biblioteca.exceptions.IncorrectLogin;
import com.twu.biblioteca.exceptions.ItemNotBorrowable;
import com.twu.biblioteca.exceptions.ItemNotReturnable;
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
    private LoginService loginService;
    private Library library;
    private User user;

    public LibraryController(Library library, BorrowService borrowService, ReturnService returnService, LoginService loginService) {
        this.borrowService = borrowService;
        this.returnService = returnService;
        this.loginService = loginService;
        this.library = library;
    }

    public boolean borrowBook(Book book, User user) throws ItemNotBorrowable {
        return borrowService.borrowBook(book, user);
    }

    public boolean returnBook(Book book, User user) throws ItemNotReturnable {
        return returnService.returnBook(book, user);
    }

    public boolean borrowMovie(Movie movie) throws ItemNotBorrowable {
        return borrowService.borrowMovie(movie);
    }

    public boolean returnMovie(Movie movie) throws ItemNotReturnable {
        return returnService.returnMovie(movie);
    }

    public User loginUser(String libraryNumber, String password) throws IncorrectLogin {
        return loginService.loginUser(libraryNumber, password);
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

    public String checkoutBook(int option) throws ItemNotBorrowable {
        Book bookToBorrow = library.getAvailableBooks().get(option - 1);
        borrowBook(bookToBorrow, user);
        return bookToBorrow.getTitle().toString();
    }

    public String checkinBook(int option) throws ItemNotReturnable {
        Book bookToReturn = library.getBorrowedBooks().get(option - 1);
        returnBook(bookToReturn, user);
        return bookToReturn.getTitle().toString();
    }

    public String checkoutMovie(int option) throws ItemNotBorrowable {
        Movie movieToBorrow = library.getAvailableMovies().get(option - 1);
        borrowMovie(movieToBorrow);
        return movieToBorrow.getName().toString();
    }

    public String checkinMovie(int option) throws ItemNotReturnable {
        Movie movieToReturn = library.getBorrowedMovies().get(option - 1);
        returnMovie(movieToReturn);
        return movieToReturn.getName().toString();
    }

    public User login(String libraryNumber, String password) throws IncorrectLogin {
        user = loginUser(libraryNumber, password);
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