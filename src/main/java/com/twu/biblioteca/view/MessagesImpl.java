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
        return "Welcome to the Bangalore Public library!\n\nWe know you'll find something that you love!\n";
    }

    @Override
    public String mainMenuMessage() {
        return "\nEnter one of the following options:\n" +
                "1 Display the list of available books to borrow\n" +
                "2 Borrow a book\n" +
                "3 Return a book\n" +
                "4 Display the list of available movies to borrow\n" +
                "5 Borrow a movie\n" +
                "6 Exit\n";
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
    public String incorrectInputMessage() {
        return "\nIncorrect option, please try again.\n";
    }

    @Override
    public String incorrectBookReturnMessage() {
        return "\nSorry, there are no available books to return\n";
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
        return "\nSelect a book to borrow by entering the ID number or enter 0 to go back to the main menu:\n";
    }

    @Override
    public String bookBorrowThankYouMessage() {
        return "\nThank you! Enjoy reading ";
    }

    @Override
    public String bookReturnMessage() {
        return "\nSelect a book to return by entering the ID number or enter 0 to go back to the main menu:\n";
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
        return "\nSelect a movie to borrow by entering the ID number or enter 0 to go back to the main menu:\n";
    }

    @Override
    public String incorrectAvailableMoviesMessage() {
        return "\nSorry, there are no available movies in the library.\n";
    }
}