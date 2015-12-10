package com.twu.biblioteca.utilities;

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
        String welcomeMessage = "Welcome to the Bangalore Public library!\n\nWe know you'll find a book here that you love!\n\n";
        return welcomeMessage;
    }

    @Override
    public String mainMenuMessage() {
        String mainMenuMessage = "Enter one of the following options:\n" +
                "1 Display the list of available books to borrow\n" +
                "2 Borrow a book\n" +
                "3 Return a book\n" +
                "4 Exit\n";
        return mainMenuMessage;
    }

    @Override
    public String optionMessage() {
        String optionMessage = "Enter your option:";
        return optionMessage;
    }

    @Override
    public String bookListingMessage() {
        String availableBooksMessage = "\nAvailable Books:\n\n";
        String formattedColumnTitle = String.format("%-15s %-15s %-15s %-15s\n", "ID:", "Title:", "Author:", "Year Published:");
        return availableBooksMessage + formattedColumnTitle;
    }

    @Override
    public String incorrectInputMessage() {
        String incorrectInputMessage = "\nIncorrect option, please try again.\n\n";
        return incorrectInputMessage;
    }

    @Override
    public String incorrectReturnMessage() {
        String incorrectReturnMessage = "\nSorry, there are no available books to return\n\n";
        return incorrectReturnMessage;
    }

    @Override
    public String incorrectBorrowMessage() {
        String incorrectBorrowMessage = "\nSorry, there are no available books to borrow\n\n";
        return incorrectBorrowMessage;
    }

    @Override
    public String exitMessage() {
        String exitMessage = "\nThank you for using the Bangalore Public library!\n";
        return exitMessage;
    }

    @Override
    public String borrowMessage() {
        String borrowMessage = "\nSelect a book to borrow by entering the ID number or enter 0 to go back to the main menu:\n";
        return borrowMessage;
    }

    @Override
    public String borrowThankYouMessage() {
        String borrowThankYouMessage = "\nThank you! Enjoy reading ";
        return borrowThankYouMessage;
    }

    @Override
    public String returnMessage() {
        String returnMessage = "\nSelect a book to return by entering the ID number or enter 0 to go back to the main menu:\n";
        return returnMessage;
    }

    @Override
    public String returnThankYouMessage() {
        String returnThankYouMessage = "\nThank you for returning ";
        return returnThankYouMessage;
    }
}
