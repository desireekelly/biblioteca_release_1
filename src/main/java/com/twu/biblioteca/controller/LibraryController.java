package com.twu.biblioteca.controller;

import com.twu.biblioteca.exceptions.IncorrectLogin;
import com.twu.biblioteca.exceptions.ItemNotBorrowable;
import com.twu.biblioteca.exceptions.ItemNotReturnable;
import com.twu.biblioteca.model.BorrowableItem;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.User;

import java.util.List;
import java.util.Map;

/**
 * LibraryController is responsible for updating the Library Model.
 *
 * @author Desiree Kelly
 * @version 1.0
 */
public class LibraryController {

    private BorrowService borrowService;
    private ReturnService returnService;
    private LoginService loginService;
    private Library library;
    private User user;

    public LibraryController(Library library, BorrowService borrowService, ReturnService returnService, LoginService loginService) {
        this.borrowService = borrowService;
        this.returnService = returnService;
        this.loginService = loginService;
        this.library = library;
    }

    public boolean borrowItem(BorrowableItem item, User user) throws ItemNotBorrowable {
        return borrowService.borrowItem(item, user);
    }

    public boolean returnItem(BorrowableItem item, User user) throws ItemNotReturnable {
        return returnService.returnItem(item, user);
    }

    public User loginUser(String libraryNumber, String password) throws IncorrectLogin {
        return loginService.loginUser(libraryNumber, password);
    }

    public List<BorrowableItem> getAvailableItems() {
        return library.getAvailableItems();
    }

    public List<BorrowableItem> getBorrowedItems() {
        return library.getBorrowedItems();
    }

    public boolean availableBooksIsEmpty() {
        return library.availableBooksIsEmpty();
    }

    public boolean borrowedBooksIsEmpty() {
        return library.borrowedBooksIsEmpty();
    }

    public boolean availableMoviesIsEmpty() {
        return library.availableMoviesIsEmpty();
    }

    public boolean borrowedMoviesIsEmpty() {
        return library.borrowedMoviesIsEmpty();
    }

    public String checkinItem(String description) throws ItemNotReturnable {
        BorrowableItem itemToReturn = library.getBorrowableItem(description);
        returnItem(itemToReturn, user);
        return itemToReturn.getDescription().toString();
    }

    public String checkoutItem(String description) throws ItemNotBorrowable {
        BorrowableItem itemToBorrow = library.getBorrowableItem(description);
        borrowItem(itemToBorrow, user);
        return itemToBorrow.getDescription().toString();
    }

    public BorrowableItem getBorrowableItem(String description) {
        return library.getBorrowableItem(description);
    }

    public User login(String libraryNumber, String password) throws IncorrectLogin {
        user = loginUser(libraryNumber, password);
        return user;
    }

    public String getCustomerInformation() {
        return user.getCustomerInformation();
    }

    public String getUserName() {
        return user.getName();
    }

    public boolean isLibrarian() {
        return user.isLibrarian();
    }

    public boolean itemsCheckedOutByCustomersIsEmpty() {
        if (library.getItemsCheckedOutByCustomers().isEmpty()) {
            return true;
        }
        return false;
    }

    public Map<BorrowableItem, User> getItemsCheckedOutByCustomers() {
        return library.getItemsCheckedOutByCustomers();
    }
}