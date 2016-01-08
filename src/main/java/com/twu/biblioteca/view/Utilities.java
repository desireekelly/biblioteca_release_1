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

    public static String formatBookList(List<Book> bookList) {
        String formattedBookList = "";
        int index = 0;
        for (Book book : bookList) {
            index++;
            formattedBookList += String.format("%-15d %-15s %-15s %-15d\n", bookList.indexOf(book), book.getTitle(), book.getAuthor(), book.getYearPublished());
        }
        return formattedBookList;
    }

    public static String formatMovieList(List<Movie> movieList) {
        String formattedMovieList = "";
        for (Movie movie : movieList) {
            formattedMovieList += String.format("%-20d %-30s %-20d %-35s %-20s\n", movieList.indexOf(movie), movie.getName(), movie.getYear(), movie.getDirector(), movie.getMovieRating());
        }
        return formattedMovieList;
    }

    public static String formatGetItemsCheckedOutByCustomers(Map<BorrowableItem, User> items) {
        String formattedItems = "";
        for (Map.Entry<BorrowableItem, User> entry : items.entrySet()) {
            formattedItems += entry.getKey().getDescription() + " is checked out by user: " + entry.getValue().getLibraryNumber() + "\n";
        }
        return formattedItems;
    }
}