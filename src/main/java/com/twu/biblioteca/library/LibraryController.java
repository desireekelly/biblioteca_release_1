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
    private boolean exit;

    public LibraryController(Library library, BorrowService borrowService, ReturnService returnService) {
        this.borrowService = borrowService;
        this.returnService = returnService;
        this.library = library;
        exit = false;
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



/*


    private void callReturnMenu() {
        returnMenu.displayReturnMenu();
        returnMenu.displayBorrowedBookListing(Utilities.formatBookList(library.getBorrowedBooks()));
            try {
                if (input.hasNextLine()) {
                    callReturnMenuOptions(input.nextInt(10));
                }
            } catch (InputMismatchException e) {
                returnMenu.displayInputMismatchExceptionMessage();
                input.nextLine();
            }
    }

    private void callReturnMenuOptions(int option) {
        if (option == 0) {
            return;
        }
        if (option > 0 && option <= library.getBorrowedBooks().size()) {
            try {
                Book bookToReturn = library.getBorrowedBooks().get(option - 1);
                returnBook(bookToReturn);
                returnMenu.displayReturnThankYouMessage();
                returnMenu.displayBookToReturn(bookToReturn.getTitle().toString());
            } catch (BookNotReturnable e) {
                returnMenu.displayReturnExceptionMessage(e.getMessage());
            }
        } else {
            returnMenu.displayIncorrectInputMessage();
        }
    }
    */
}