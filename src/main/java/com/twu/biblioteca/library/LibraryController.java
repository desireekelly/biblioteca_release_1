package com.twu.biblioteca.library;

import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.exceptions.BookNotBorrowable;
import com.twu.biblioteca.exceptions.BookNotReturnable;

import java.util.List;


/**
 * Created by desiree on 10/12/2015.
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


    public String checkoutBook(int option) {
        String bookTitle = "";
        try {
            Book bookToBorrow = library.getAvailableBooks().get(option - 1);
            borrowBook(bookToBorrow);
            bookTitle = bookToBorrow.getTitle().toString();

        } catch (BookNotBorrowable e) {
            System.out.println("\n" + e.getMessage() + "\n");
        }
        return bookTitle;
    }

    public String checkinBook(int option) {
        String bookTitle = "";
        try {
            Book bookToReturn = library.getBorrowedBooks().get(option - 1);
            returnBook(bookToReturn);
            bookTitle = bookToReturn.getTitle().toString();

        } catch (BookNotReturnable e) {
            System.out.println("\n" + e.getMessage() + "\n");
        }
        return bookTitle;
    }

}