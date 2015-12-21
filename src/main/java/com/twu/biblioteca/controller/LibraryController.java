package com.twu.biblioteca.controller;

import com.twu.biblioteca.exceptions.IncorrectLogin;
import com.twu.biblioteca.exceptions.ItemNotBorrowable;
import com.twu.biblioteca.exceptions.ItemNotReturnable;
import com.twu.biblioteca.model.*;

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

    public boolean borrowItem(BorrowableItem item, User user) throws ItemNotBorrowable {
        return borrowService.borrowItem(item, user);
    }

    public boolean returnItem(BorrowableItem item, User user) throws ItemNotReturnable {
        return returnService.returnItem(item, user);
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
        borrowItem(bookToBorrow, user);
        return bookToBorrow.getTitle().toString();
    }

    public String checkinBook(int option) throws ItemNotReturnable {
        Book bookToReturn = library.getBorrowedBooks().get(option - 1);
        returnItem(bookToReturn, user);
        return bookToReturn.getTitle().toString();
    }

    public String checkoutMovie(int option) throws ItemNotBorrowable {
        Movie movieToBorrow = library.getAvailableMovies().get(option - 1);
        borrowItem(movieToBorrow, user);
        return movieToBorrow.getName().toString();
    }

    public String checkinMovie(int option) throws ItemNotReturnable {
        Movie movieToReturn = library.getBorrowedMovies().get(option - 1);
        returnItem(movieToReturn, user);
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