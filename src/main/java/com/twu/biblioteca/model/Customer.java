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

    public String getPassword() {
        return password;
    }

    public String toString() {
        return this.name + ", " + this.emailAddress + ", " + this.phoneNumber;
    }

    public String getCustomerInformation(){
        return String.format("%-15d %-15s %-15s", this.name, this.emailAddress, this.phoneNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (!obj.getClass().equals(this.getClass())) {
            return false;
        }

        Customer otherCustomer = (Customer) obj;

        return this.name.equals(otherCustomer.name)
                && this.emailAddress.equals(otherCustomer.emailAddress)
                && this.phoneNumber.equals(otherCustomer.phoneNumber)
                && this.libraryNumber.equals(otherCustomer.libraryNumber)
                && this.password.equals(otherCustomer.password);
    }
}