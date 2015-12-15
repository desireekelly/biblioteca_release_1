package com.twu.biblioteca.model;

import com.twu.biblioteca.exceptions.BookNotBorrowable;
import com.twu.biblioteca.exceptions.BookNotReturnable;
import com.twu.biblioteca.exceptions.MovieNotBorrowable;

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
    private List<Movie> movies = new ArrayList<Movie>();
    private Set<Movie> borrowedMovies = new HashSet<Movie>();
    private List<Customer> customers = new ArrayList<Customer>();

    public LibraryImpl() {
        this.createBookList();
        this.createMovieList();
        this.createCustomerList();
    }

    private void createBookList() {
        books.add(new Book("Java 101", "Joe Bloggs", 1990));
        books.add(new Book("PHP 101", "Mary Jane", 2005));
        books.add(new Book("C# 101", "John Smith", 2010));
        books.add(new Book("C++ 101", "Joyce Merry", 2001));
    }

    private void createMovieList() {
        movies.add(new Movie("The Matrix", 1999, "The Wachowski Brothers", "10"));
        movies.add(new Movie("Inception", 2010, "Christopher Nolan", "8"));
        movies.add(new Movie("Divergent", 2014, "Neil Burger", "Unrated"));
        movies.add(new Movie("The Bourne Identity", 2002, "Doug Liman", "10"));
    }

    private void createCustomerList() {
        customers.add(new Customer("Joe Bloggs", "joebloggs@joebloggs.com", "0400 000 000", "123-4566", "f8kf93jd"));
        customers.add(new Customer("Jane Smith", "janesmith@janesmith.com", "0400 123 888", "123-4567", "5jgfdkl5"));
        customers.add(new Customer("Bob Smith", "bobsmith@bobsmith.com", "0412 454 565", "123-4568", "4jg84jf8"));
        customers.add(new Customer("Jenny Bloggs", "jennybloggs@jennybloggs.com", "0435 567 040", "123-4569", "kb94kfm3"));
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

    @Override
    public List<Movie> getAvailableMovies() {
        List<Movie> results = new ArrayList<Movie>(movies.size());
        for (Movie movie : movies) {
            if (!borrowedMovies.contains(movie)) {
                results.add(movie);
            }
        }
        return results;
    }

    @Override
    public List<Movie> getBorrowedMovies() {
        List<Movie> results = new ArrayList<Movie>(movies.size());
        for (Movie movie : movies) {
            if (borrowedMovies.contains(movie)) {
                results.add(movie);
            }
        }
        return results;
    }

    @Override
    public List<Movie> getMovieList() {
        return Collections.unmodifiableList(movies);
    }

    @Override
    public void checkoutMovie(Movie movie) throws MovieNotBorrowable {
        if (borrowedMovies.contains(movie))
            throw new MovieNotBorrowable("movie is not available");
        borrowedMovies.add(movie);
    }

    @Override
    public List<Customer> getCustomerList() {
        return Collections.unmodifiableList(customers);
    }
}