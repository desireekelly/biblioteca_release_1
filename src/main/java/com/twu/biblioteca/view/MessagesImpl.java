package com.twu.biblioteca.view;

/**
 * Messages implementation.
 * Messages is responsible for holding all of the messages to display.
 *
 * @author Desiree Kelly
 * @version 1.0
 */
public class MessagesImpl implements Messages {

    @Override
    public String welcomeMessage() {
        return "Welcome to the Bangalore Public library!\n\nPlease login to your account to borrow or return an item.\n";
    }

    @Override
    public String mainMenuMessage() {
        return "\nEnter one of the following options:\n" +
                "1 Login to account\n" +
                "2 Exit\n";
    }

    @Override
    public String customerMenuMessage() {
        return "\nEnter one of the following options:\n" +
                "1 Display the list of available books\n" +
                "2 Borrow a book\n" +
                "3 Return a book\n" +
                "4 Display the list of available movies\n" +
                "5 Borrow a movie\n" +
                "6 Return a movie\n" +
                "7 Display account information\n" +
                "8 Logout\n";
    }

    @Override
    public String librarianMenuMessage() {
        return "\nEnter one of the following options:\n" +
                "1 Display items checked out by customers\n" +
                "2 Logout\n";
    }

    @Override
    public String itemsCheckedOutByCustomersMessage() {
        return "\nItems checked out by customers:\n\n";
    }

    @Override
    public String optionMessage() {
        return "Enter your option:";
    }

    @Override
    public String bookListingMessage() {
        return "\nAvailable Books:\n\n" + String.format("%-15s %-15s %-15s %-15s\n", "ID:", "Title:", "Author:", "Year Published:");
    }

    @Override
    public String incorrectAvailableBooksMessage() {
        return "\nSorry, there are no available books in the library.\n";
    }

    @Override
    public String incorrectOptionMessage() {
        return "\nIncorrect option, please try again.\n";
    }

    @Override
    public String incorrectInputMessage() {
        return "\nIncorrect input, please try again.\n";
    }

    @Override
    public String incorrectBookReturnMessage() {
        return "\nSorry, there are no available books to return\n";
    }

    @Override
    public String incorrectMovieReturnMessage() {
        return "\nSorry, there are no available movies to return\n";
    }

    @Override
    public String incorrectBookBorrowMessage() {
        return "\nSorry, there are no available books to borrow\n";
    }

    @Override
    public String exitMessage() {
        return "\nThank you for using the Bangalore Public library!\n";
    }

    @Override
    public String bookBorrowMessage() {
        return "\nSelect a book to borrow by entering the ID number:";
    }

    @Override
    public String bookBorrowThankYouMessage() {
        return "\nThank you! Enjoy reading ";
    }

    @Override
    public String bookReturnMessage() {
        return "\nSelect a book to return by entering the ID number:";
    }

    @Override
    public String returnThankYouMessage() {
        return "\nThank you for returning ";
    }

    @Override
    public String movieListingMessage(){
        return "\nAvailable Movies:\n\n" + String.format("%-20s %-30s %-20s %-35s %-20s\n", "ID:", "Title:", "Year:", "Director:", "Movie Rating:");
    }

    @Override
    public String incorrectMovieBorrowMessage(){
        return "\nSorry, there are no available movies to borrow\n";
    }

    @Override
    public String movieBorrowThankYouMessage(){
        return "\nThank you! Enjoy watching ";
    }

    @Override
    public String movieBorrowMessage(){
        return "\nSelect a movie to borrow by entering the ID number:\n";
    }

    @Override
    public String movieReturnMessage() {
        return "\nSelect a movie to return by entering the ID number:\n";
    }

    @Override
    public String incorrectAvailableMoviesMessage() {
        return "\nSorry, there are no available movies in the library.\n";
    }

    @Override
    public String libraryNumberMessage() {
        return "\nEnter your Library Number:";
    }

    @Override
    public String passwordMessage() {
        return "\nEnter your Password:";
    }

    @Override
    public String loginMessage() {
        return "\nPlease login with your Library Number and Password.\n";
    }

    @Override
    public String correctLoginMessage() {
        return "\nYou have logged in successfully ";
    }

    @Override
    public String logoutMessage() {
        return "\nYou have logged out.\n";
    }

    @Override
    public String incorrectItemsCheckedOutByCustomersMessage() {
        return "\nSorry, there are no items checked out from the Library.\n";
    }
}