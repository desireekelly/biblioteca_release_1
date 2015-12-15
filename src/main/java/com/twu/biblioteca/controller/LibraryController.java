package com.twu.biblioteca.controller;

import com.twu.biblioteca.exceptions.BookNotBorrowable;
import com.twu.biblioteca.exceptions.BookNotReturnable;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;

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

    public List<Book> getAvailableBooks() {
        return library.getAvailableBooks();
    }

    public List<Book> getBorrowedBooks() {
        return library.getBorrowedBooks();
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

    public int getAvailableBooksSize() {
        return library.getAvailableBooks().size();
    }

    public int getBorrowedBooksSize() {
        return library.getBorrowedBooks().size();
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
}