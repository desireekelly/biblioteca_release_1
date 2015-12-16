package com.twu.biblioteca.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the Customer class.
 *
 * @author Desiree Kelly
 * @version 2.0
 * @see Customer
 */
public class CustomerTest {

    private static final Customer CUSTOMER_1 = new Customer("Joe Bloggs", "joebloggs@joebloggs.com", "0400 000 000", "123-4567", "f8kf93jd");
    private static final Customer CUSTOMER_2 = new Customer("Jane Smith", "janesmith@janesmith.com", "0400 123 888", "123-4568", "5jgfdkl5");

    @Test
    public void testGetName() throws Exception {
        assertEquals("Joe Bloggs", CUSTOMER_1.getName());
    }

    @Test
    public void testGetEmailAddress() throws Exception {
        assertEquals("joebloggs@joebloggs.com", CUSTOMER_1.getEmailAddress());
    }

    @Test
    public void testGetPhoneNumber() throws Exception {
        assertEquals("0400 000 000", CUSTOMER_1.getPhoneNumber());
    }

    @Test
    public void testGetLibraryNumber() throws Exception {
        assertEquals("123-4567", CUSTOMER_1.getLibraryNumber());
    }

    @Test
    public void testCheckPassword() throws Exception {
        assertTrue(CUSTOMER_1.checkPassword("f8kf93jd"));
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("Name: Joe Bloggs\nEmail: joebloggs@joebloggs.com\nPhone Number: 0400 000 000", CUSTOMER_1.toString());
    }

    @Test
    public void testCustomerEqualsCustomer() throws Exception {
        assertTrue(CUSTOMER_1.equals(CUSTOMER_1));
        assertFalse(CUSTOMER_1.equals(CUSTOMER_2));
    }

    @Test
    public void testGetCustomerInformation() throws Exception {
        assertEquals("Name: Joe Bloggs\nEmail: joebloggs@joebloggs.com\nPhone Number: 0400 000 000", CUSTOMER_1.getCustomerInformation());
    }
}