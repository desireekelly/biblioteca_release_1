package com.twu.biblioteca.model;

import com.twu.biblioteca.exceptions.BookNotBorrowable;
import com.twu.biblioteca.exceptions.BookNotReturnable;

import java.util.*;

/**
 * Library implementation.
 * Library is responsible for holding the available and borrowed books.
 *
 * @author Desiree Kelly
 * @version 1.0
 */
public class LibraryImpl implements Library {

    private List<Book> books = new ArrayList<Book>();
    private Set<Book> borrowedBooks = new HashSet<Book>();

    public LibraryImpl() {
        this.createBookList();
    }

    private void createBookList() {
        books.add(new Book("Java 101", "Joe Bloggs", 1990));
        books.add(new Book("PHP 101", "Mary Jane", 2005));
        books.add(new Book("C# 101", "John Smith", 2010));
        books.add(new Book("C++ 101", "Joyce Merry", 2001));
    }

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

    @Override
    public List<Book> getBookList() {
        return Collections.unmodifiableList(books);
    }

    @Override
    public void checkoutBook(Book book) throws BookNotBorrowable {
        if (borrowedBooks.contains(book))
            throw new BookNotBorrowable("book is not available");
        borrowedBooks.add(book);
    }

    @Override
    public void returnBook(Book book) throws BookNotReturnable {
        if (!borrowedBooks.contains(book))
            throw new BookNotReturnable("book is already returned");
        borrowedBooks.remove(book);
    }
}