package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;

import java.util.List;

/**
 * Utilities is responsible for formatting a list of books into columns.
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
            formattedBookList += String.format("%-15d %-15s %-15s %-15d\n", index, book.getTitle(), book.getAuthor(), book.getYearPublished());
        }
        return formattedBookList;
    }

    public static String formatMovieList(List<Movie> movieList) {
        String formattedMovieList = "";
        int index = 0;
        for (Movie movie : movieList) {
            index++;
            formattedMovieList += String.format("%-20d %-30s %-20d %-35s %-20s\n", index, movie.getName(), movie.getYear(), movie.getDirector(), movie.getMovieRating());
        }
        return formattedMovieList;
    }

    public static String formatGetBooksCheckedOutByCustomersList(List<String> list) {
        String formattedList = "";
        for (String book : list) {
            formattedList += book + "\n";
        }
        return formattedList;
    }
}