package com.twu.biblioteca.library;

import com.twu.biblioteca.book.Book;

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

    public boolean borrowBook(Book book) {


        return borrowService.borrowBook(book);
    }

    public boolean returnBook(Book book){
        return returnService.returnBook(book);
    }
}
