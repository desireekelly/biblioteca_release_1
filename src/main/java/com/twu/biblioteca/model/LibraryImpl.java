package com.twu.biblioteca.model;

import com.twu.biblioteca.exceptions.IncorrectLogin;
import com.twu.biblioteca.exceptions.ItemNotBorrowable;
import com.twu.biblioteca.exceptions.ItemNotReturnable;

import java.util.*;

/**
 * Library implementation.
 * Library is responsible for holding the available and borrowed items.
 *
 * @author Desiree Kelly
 * @version 1.0
 */
public class LibraryImpl implements Library {

    private Map<String, User> users = new HashMap<String, User>();
    private List<BorrowableItem> items = new ArrayList<BorrowableItem>();
    private Set<BorrowableItem> borrowedItems = new HashSet<BorrowableItem>();
    private Map<BorrowableItem, User> itemsCheckedOutByCustomers = new HashMap<BorrowableItem, User>();

    public LibraryImpl() {
        this.createBookList();
        this.createMovieList();
        this.createUsers();
        this.createItemsCheckedOutByCustomers();
    }

    private void createBookList() {
        items.add(new Book("Java 101", "Joe Bloggs", 1990));
        items.add(new Book("PHP 101", "Mary Jane", 2005));
        items.add(new Book("C# 101", "John Smith", 2010));
        items.add(new Book("C++ 101", "Joyce Merry", 2001));
    }

    private void createMovieList() {
        items.add(new Movie("The Matrix", 1999, "The Wachowski Brothers", "10"));
        items.add(new Movie("Inception", 2010, "Christopher Nolan", "8"));
        items.add(new Movie("Divergent", 2014, "Neil Burger", "Unrated"));
        items.add(new Movie("The Bourne Identity", 2002, "Doug Liman", "10"));
    }

    private void createUsers() {
        User customer1 = new User("Joe Bloggs", "joebloggs@joebloggs.com", "0400 000 000", "123-4566", "password1");
        User customer2 = new User("Jane Smith", "janesmith@janesmith.com", "0400 123 888", "123-4567", "password2");
        User customer3 = new User("Bob Smith", "bobsmith@bobsmith.com", "0412 454 565", "123-4568", "password3");
        User librarian = new User("Jenny Bloggs", "jennybloggs@jennybloggs.com", "0435 567 040", "123-4569", "password4");

        users.put(customer1.getLibraryNumber(), customer1);
        users.put(customer2.getLibraryNumber(), customer2);
        users.put(customer3.getLibraryNumber(), customer3);
        users.put(librarian.getLibraryNumber(), librarian);

        librarian.setLibrarian(true);
    }

    private void createItemsCheckedOutByCustomers() {
        Book book1 = new Book("Ruby 101", "Jenny Moore", 2013);
        Book book2 = new Book("Web Development 101", "Mark Green", 2014);

        User customer1 = new User("Bob Kent", "bobkent@bobkent.com", "0400 575 838", "123-4570", "4jv03m20");
        User customer2 = new User("Mary Jane", "maryjane@maryjane.com", "0400 738 939", "123-4571", "3kv93m0c");

        users.put(customer1.getLibraryNumber(), customer1);
        users.put(customer2.getLibraryNumber(), customer2);

        borrowedItems.add(book1);
        borrowedItems.add(book2);

        itemsCheckedOutByCustomers.put(book1, customer1);
        itemsCheckedOutByCustomers.put(book2, customer2);
    }

    @Override
    public List<BorrowableItem> getAvailableItems() {
        List<BorrowableItem> results = new ArrayList<BorrowableItem>();
        for (BorrowableItem item : items) {
            if (!borrowedItems.contains(item)) {
                results.add(item);
            }
        }
        return results;
    }

    @Override
    public List<BorrowableItem> getBorrowedItems() {
        List<BorrowableItem> results = new ArrayList<BorrowableItem>();
        for (BorrowableItem item : items) {
            if (borrowedItems.contains(item)) {
                results.add(item);
            }
        }
        return results;
    }

    @Override
    public List<Book> getAvailableBooks() {
        List<Book> results = new ArrayList<Book>();
        for (BorrowableItem item : items) {
            if (!borrowedItems.contains(item) && item instanceof Book) {
                results.add((Book) item);
            }
        }
        return results;
    }

    @Override
    public List<Book> getBorrowedBooks() {
        List<Book> results = new ArrayList<Book>();
        for (BorrowableItem item : items) {
            if (borrowedItems.contains(item) && item instanceof Book) {
                results.add((Book) item);
            }
        }
        return results;
    }

    @Override
    public List<Book> getBookList() {
        List<Book> results = new ArrayList<Book>();
        for (BorrowableItem item : items) {
            if (item instanceof Book) {
                results.add((Book) item);
            }
        }
        return results;
    }

    @Override
    public void checkoutItem(BorrowableItem item, User user) throws ItemNotBorrowable {
        if (borrowedItems.contains(item))
            throw new ItemNotBorrowable("item is not available");
        borrowedItems.add(item);
        itemsCheckedOutByCustomers.put(item, user);
    }

    @Override
    public void returnItem(BorrowableItem item, User user) throws ItemNotReturnable {
        if (!borrowedItems.contains(item))
            throw new ItemNotReturnable("item is already returned");
        borrowedItems.remove(item);
        itemsCheckedOutByCustomers.remove(item);
    }

    @Override
    public List<Movie> getAvailableMovies() {
        List<Movie> results = new ArrayList<Movie>();
        for (BorrowableItem item : items) {
            if (!borrowedItems.contains(item) && item instanceof Movie) {
                results.add((Movie) item);
            }
        }
        return results;
    }

    @Override
    public List<Movie> getBorrowedMovies() {
        List<Movie> results = new ArrayList<Movie>();
        for (BorrowableItem item : items) {
            if (borrowedItems.contains(item) && item instanceof Movie) {
                results.add((Movie) item);
            }
        }
        return results;
    }

    @Override
    public List<Movie> getMovieList() {
        List<Movie> results = new ArrayList<Movie>();
        for (BorrowableItem item : items) {
            if (item instanceof Movie) {
                results.add((Movie) item);
            }
        }
        return results;
    }

    @Override
    public Map<BorrowableItem, User> getItemsCheckedOutByCustomers() {
        return Collections.unmodifiableMap(itemsCheckedOutByCustomers);
    }

    @Override
    public Map<String, User> getUsers() {
        return Collections.unmodifiableMap(users);
    }

    @Override
    public User login(String libraryNumber, String password) throws IncorrectLogin {
        if (users.containsKey(libraryNumber)) {
            if (users.get(libraryNumber).checkPassword(password)) {
                return users.get(libraryNumber);
            }
        }
        throw new IncorrectLogin("Incorrect login details. Please try again.");
    }
}