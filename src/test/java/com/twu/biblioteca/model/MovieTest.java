package com.twu.biblioteca.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the Movie class.
 *
 * @author Desiree Kelly
 * @version 2.0
 * @see Movie
 */
public class MovieTest {

    private static final Movie MOVIE_1 = new Movie("The Matrix", 1999, "The Wachowski Brothers", "10");
    private static final Movie MOVIE_2 = new Movie("Inception", 2010, "Christopher Nolan", "8");

    @Test
    public void testGetName() throws Exception {
        assertEquals("The Matrix", MOVIE_1.getName());
    }

    @Test
    public void testGetYear() throws Exception {
        assertEquals(1999, MOVIE_1.getYear());
    }

    @Test
    public void testGetDirector() throws Exception {
        assertEquals("The Wachowski Brothers", MOVIE_1.getDirector());
    }

    @Test
    public void testGetMovieRating() throws Exception {
        assertEquals("10", MOVIE_1.getMovieRating());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("The Matrix, 1999, The Wachowski Brothers, 10", MOVIE_1.toString());
    }

    @Test
    public void testIfTwoMoviesAreTheSame() throws Exception {
        assertFalse(MOVIE_1.equals("The Matrix, 1999, The Wachowski Brothers, 10"));
        assertTrue(MOVIE_1.equals(MOVIE_1));
        assertFalse(MOVIE_1.equals(MOVIE_2));
    }
}