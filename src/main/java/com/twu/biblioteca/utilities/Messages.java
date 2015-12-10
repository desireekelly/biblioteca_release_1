package com.twu.biblioteca.utilities;

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

    String incorrectInputMessage();

    String incorrectReturnMessage();

    String incorrectBorrowMessage();

    String exitMessage();

    String borrowMessage();

    String borrowThankYouMessage();

    String returnMessage();

    String returnThankYouMessage();
}
