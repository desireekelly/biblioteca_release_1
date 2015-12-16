package com.twu.biblioteca.model;

/**
 * Customer is responsible for holding all the information about a customer.
 *
 * @author Desiree Kelly
 * @version 2.0
 */
public class Customer {

    private String name;
    private String emailAddress;
    private String phoneNumber;
    private String libraryNumber;
    private String password;

    public Customer(String name, String emailAddress, String phoneNumber, String libraryNumber, String password) {
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

    public String toString() {
        return "Name: " + this.name + "\nEmail: " + this.emailAddress + "\nPhone Number: " + this.phoneNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (!obj.getClass().equals(this.getClass())) {
            return false;
        }

        Customer customer = (Customer) obj;

        return this.name.equals(customer.name)
                && this.emailAddress.equals(customer.emailAddress)
                && this.phoneNumber.equals(customer.phoneNumber)
                && this.libraryNumber.equals(customer.libraryNumber)
                && this.password.equals(customer.password);
    }
}