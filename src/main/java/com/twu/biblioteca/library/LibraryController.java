package com.twu.biblioteca.library;

import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.exceptions.BookNotBorrowable;
import com.twu.biblioteca.exceptions.BookNotReturnable;

/**
 * Created by desiree on 10/12/2015.
 */
public class LibraryController {
    private BorrowService borrowService;
    private ReturnService returnService;

    public LibraryController(BorrowService borrowService, ReturnService returnService) {
        this.borrowService = borrowService;
        this.returnService = returnService;
    }

    public boolean borrowBook(Book book) throws BookNotBorrowable {
        return borrowService.borrowBook(book);
    }

    public boolean returnBook(Book book) throws BookNotReturnable {
        return returnService.returnBook(book);
    }
}
