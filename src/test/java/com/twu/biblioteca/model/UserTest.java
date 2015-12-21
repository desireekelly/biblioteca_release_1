package com.twu.biblioteca.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the User class.
 *
 * @author Desiree Kelly
 * @version 2.0
 * @see User
 */
public class UserTest {

    private static final User CUSTOMER_1 = new User("Joe Bloggs", "joebloggs@joebloggs.com", "0400 000 000", "123-4567", "f8kf93jd");
    private static final User CUSTOMER_2 = new User("Jane Smith", "janesmith@janesmith.com", "0400 123 888", "123-4568", "5jgfdkl5");
    private static final User LIBRARIAN = new User("Bob Smith", "bobsmith@bobsmith.com", "0412 454 565", "123-4568", "4jg84jf8");

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
        assertFalse(CUSTOMER_1.checkPassword("93jf93km"));
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("\n" +
                "Name: Joe Bloggs\n" +
                "Email: joebloggs@joebloggs.com\n" +
                "Phone Number: 0400 000 000\n", CUSTOMER_1.toString());
    }

    @Test
    public void testCustomerEqualsCustomer() throws Exception {
        assertTrue(CUSTOMER_1.equals(CUSTOMER_1));
        assertFalse(CUSTOMER_1.equals(CUSTOMER_2));
    }

    @Test
    public void testGetCustomerInformation() throws Exception {
        assertEquals("\n" +
                "Name: Joe Bloggs\n" +
                "Email: joebloggs@joebloggs.com\n" +
                "Phone Number: 0400 000 000\n", CUSTOMER_1.getCustomerInformation());
    }

    @Test
    public void testIsLibrarian() throws Exception {
        LIBRARIAN.setLibrarian(true);
        assertTrue(LIBRARIAN.isLibrarian());
    }
}