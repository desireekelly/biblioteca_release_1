package com.twu.biblioteca.book;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the book class.
 *
 * @author Desiree Kelly
 * @version 1.0
 * @see Book
 */
public class BookTest {

    public static final Book BOOK_1 = new Book("Java 101", "Joe Bloggs", 1990);
    public static final Book BOOK_2 = new Book("PHP 101", "Mary Jane", 2005);

    @Test
    public void testGetTitle() throws Exception {
        assertEquals("Java 101", BOOK_1.getTitle());
    }

    @Test
    public void testGetAuthor() throws Exception {
        assertEquals("Joe Bloggs", BOOK_1.getAuthor());
    }

    @Test
    public void testGetYearPublished() throws Exception {
        assertEquals(1990, BOOK_1.getYearPublished());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("Java 101, Joe Bloggs, 1990", BOOK_1.toString());
    }

    @Test
    public void testIfTwoBooksAreTheSame() throws Exception {
        assertFalse(BOOK_1.equals("Java 101, Joe Bloggs, 1990"));
        assertTrue(BOOK_1.equals(BOOK_1));
        assertFalse(BOOK_1.equals(BOOK_2));
    }
}