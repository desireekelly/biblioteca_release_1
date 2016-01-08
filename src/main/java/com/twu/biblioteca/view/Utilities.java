package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.BorrowableItem;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.User;

import java.util.List;
import java.util.Map;

/**
 * Utilities is responsible for formatting the list of books, movies and items checked out by customers.
 *
 * @author Desiree Kelly
 * @version 1.0
 */
public class Utilities {

    public static String formatGetItemsCheckedOutByCustomers(Map<BorrowableItem, User> items) {
        String formattedItems = "";
        for (Map.Entry<BorrowableItem, User> entry : items.entrySet()) {
            formattedItems += entry.getKey().getDescription() + " is checked out by user: " + entry.getValue().getLibraryNumber() + "\n";
        }
        return formattedItems;
    }

    public static String formatBooks(List<BorrowableItem> items) {
        String formattedBooks = "";
        for (BorrowableItem item : items) {
            if (item instanceof Book) {
                formattedBooks += String.format("%-15d %-15s %-15s %-15d\n", items.indexOf(item), ((Book) item).getTitle(), ((Book) item).getAuthor(), ((Book) item).getYearPublished());
            }
        }
        return formattedBooks;
    }

    public static String formatMovies(List<BorrowableItem> items) {
        String formattedMovies = "";
        for (BorrowableItem item : items) {
            if (item instanceof Movie) {
                formattedMovies += String.format("%-20d %-30s %-20d %-35s %-20s\n", items.indexOf(item), ((Movie) item).getName(), ((Movie) item).getYear(), ((Movie) item).getDirector(), ((Movie) item).getMovieRating());
            }
        }
        return formattedMovies;
    }
}