package com.twu.biblioteca.view;

/**
 * Messages interface.
 * Messages is responsible for holding all of the messages to display.
 *
 * @author Desiree Kelly
 * @version 1.0
 */
public interface Messages {
    String welcomeMessage();

    String mainMenuMessage();

    String optionMessage();

    String bookListingMessage();

    String incorrectAvailableBooksMessage();

    String incorrectOptionMessage();

    String incorrectInputMessage();

    String incorrectBookReturnMessage();

    String incorrectBookBorrowMessage();

    String exitMessage();

    String bookBorrowMessage();

    String bookBorrowThankYouMessage();

    String bookReturnMessage();

    String returnThankYouMessage();

    String movieListingMessage();

    String movieReturnMessage();

    String incorrectMovieReturnMessage();

    String incorrectMovieBorrowMessage();

    String movieBorrowThankYouMessage();

    String movieBorrowMessage();

    String incorrectAvailableMoviesMessage();

    String customerMenuMessage();

    String librarianMenuMessage();

    String libraryNumberMessage();

    String booksCheckedOutByCustomersMessage();

    String incorrectBooksCheckedOutByCustomersMessage();

    String passwordMessage();

    String loginMessage();

    String incorrectLoginMessage();

    String correctLoginMessage();

    String logoutMessage();
}