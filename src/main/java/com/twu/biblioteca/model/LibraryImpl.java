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
    private Map<String, User> users = new HashMap<String, User>();
    private SortedMap<String, String> booksCheckedOutByCustomers = new TreeMap<String, String>();

    public LibraryImpl() {
        this.createBookList();
        this.createMovieList();
        this.createUsers();
        this.createBooksCheckedOutByCustomer();
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

    private void createUsers() {
        User customer1 = new User("Joe Bloggs", "joebloggs@joebloggs.com", "0400 000 000", "123-4566", "f8kf93jd");
        User customer2 = new User("Jane Smith", "janesmith@janesmith.com", "0400 123 888", "123-4567", "5jgfdkl5");
        User customer3 = new User("Bob Smith", "bobsmith@bobsmith.com", "0412 454 565", "123-4568", "4jg84jf8");
        User librarian = new User("Jenny Bloggs", "jennybloggs@jennybloggs.com", "0435 567 040", "123-4569", "kb94kfm3");

        users.put(customer1.getLibraryNumber(), customer1);
        users.put(customer2.getLibraryNumber(), customer2);
        users.put(customer3.getLibraryNumber(), customer3);
        users.put(librarian.getLibraryNumber(), librarian);

        librarian.setLibrarian(true);
    }

    private void createBooksCheckedOutByCustomer() {
        Book book = new Book("Ruby 101", "Jenny Moore", 2013);
        User customer = new User("Bob Kent", "bobkent@bobkent.com", "0400 575 838", "123-4570", "4jv03m20");
        users.put(customer.getLibraryNumber(), customer);
        borrowedBooks.add(book);
        booksCheckedOutByCustomers.put(book.getTitle(), customer.getLibraryNumber());
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
    public void checkoutBook(Book book, User user) throws BookNotBorrowable {
        if (borrowedBooks.contains(book))
            throw new BookNotBorrowable("book is not available");
        borrowedBooks.add(book);
        booksCheckedOutByCustomers.put(book.getTitle(), user.getLibraryNumber());
    }

    @Override
    public void returnBook(Book book, User user) throws BookNotReturnable {
        if (!borrowedBooks.contains(book))
            throw new BookNotReturnable("book is already returned");
        borrowedBooks.remove(book);
        booksCheckedOutByCustomers.remove(book.getTitle());
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
    public String getBooksCheckedOutByCustomersList() {

        String books = "";
        for (Map.Entry<String, String> entry : booksCheckedOutByCustomers.entrySet()) {

            books += entry.getKey() + " is checked out by user: " + entry.getValue() + "\n";
        }

        return books;

    }

    @Override
    public Map<String, User> getUsers() {
        return Collections.unmodifiableMap(users);
    }

    @Override
    public User login(String libraryNumber, String password) {
        if (users.containsKey(libraryNumber)) {
            if (users.get(libraryNumber).checkPassword(password)) {
                return users.get(libraryNumber);
            }
        }
        return null;
    }
}