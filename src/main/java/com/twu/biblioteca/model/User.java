package com.twu.biblioteca.model;

/**
 * User is responsible for holding all the information about a user.
 *
 * @author Desiree Kelly
 * @version 2.0
 */
public class User {

    private String name;
    private String emailAddress;
    private String phoneNumber;
    private String libraryNumber;
    private String password;
    private Boolean customer = false;
    private Boolean librarian = false;

    public User(String name, String emailAddress, String phoneNumber, String libraryNumber, String password) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public Boolean checkPassword(String password) {
        if (this.password.equals(password)) {
            return true;
        }
        return false;
    }

    public String getCustomerInformation() {
        return this.toString();
    }

    public void loginCustomer(boolean loggedInCustomer) {
        this.customer = loggedInCustomer;
    }

    public boolean isLoggedInCustomer() {
        return customer;
    }

    public boolean isLoggedInLibrarian() {
        return librarian;
    }

    public void loginLibrarian(boolean loggedInlibrarian) {
        this.librarian = loggedInlibrarian;
    }

    public String toString() {
        return "Name: " + this.name + "\nEmail: " + this.emailAddress + "\nPhone Number: " + this.phoneNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (!obj.getClass().equals(this.getClass())) {
            return false;
        }

        User user = (User) obj;

        return this.name.equals(user.name)
                && this.emailAddress.equals(user.emailAddress)
                && this.phoneNumber.equals(user.phoneNumber)
                && this.libraryNumber.equals(user.libraryNumber)
                && this.password.equals(user.password);
    }
}