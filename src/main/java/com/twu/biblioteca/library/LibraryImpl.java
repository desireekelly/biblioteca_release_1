package com.twu.biblioteca.library;

import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.exceptions.BookNotBorrowable;
import com.twu.biblioteca.exceptions.BookNotReturnable;

import java.util.*;

/**
 * library implementation.
 * library is responsible for holding the available and borrowed books.
 *
 * @author Desiree Kelly
 * @version 1.0
 */
public class LibraryImpl implements Library {

    private List<Book> books = new ArrayList<Book>();
    private Set<Book> borrowedBooks = new HashSet<Book>();

    /**
     * Construct a library with a fixed set of books.
     */
    public LibraryImpl() {
        this.createBookList();
    }

    private void createBookList() {
        books.add(new Book("Java 101", "Joe Bloggs", 1990));
        books.add(new Book("PHP 101", "Mary Jane", 2005));
        books.add(new Book("C# 101", "John Smith", 2010));
        books.add(new Book("C++ 101", "Joyce Merry", 2001));
    }

    /**
     * Get the list of available books.
     *
     * @return Returns a list of books that are available to be borrowed.
     */
    @Override
    public List<Book> getAvailableBooks() {
        List<Book> results = new ArrayList<Book>(books.size());
        for (Book book : books) {
            if (!borrowedBooks.contains(book)) {
                results.add(book);
            }
        }
        return results;
    }

    /**
     * Get the list of borrowed books.
     *
     * @return Returns a list of books that are out for loan.
     */
    @Override
    public List<Book> getBorrowedBooks() {
        List<Book> results = new ArrayList<Book>(books.size());
        for (Book book : books) {
            if (borrowedBooks.contains(book)) {
                results.add(book);
            }
        }
        return results;
    }

    /**
     * Get the list of all books this library has.
     *
     * @return Returns the book catalog.
     */
    @Override
    public List<Book> getBookList() {
        return Collections.unmodifiableList(books);
    }

    /**
     * Check out a book.
     *
     * @param book The book to check out.
     * @throws BookNotBorrowable Thrown if book is not available to check out.
     */
    @Override
    public void checkoutBook(Book book) throws BookNotBorrowable {
        if (borrowedBooks.contains(book))
            throw new BookNotBorrowable("book is not available");
        borrowedBooks.add(book);
    }

    /**
     * Return a checked out book.
     *
     * @param book The book to return.
     * @throws BookNotReturnable Thrown if book is not currently checked out.
     */
    @Override
    public void returnBook(Book book) throws BookNotReturnable {
        if (!borrowedBooks.contains(book))
            throw new BookNotReturnable("book is already returned");
        borrowedBooks.remove(book);
    }
}

