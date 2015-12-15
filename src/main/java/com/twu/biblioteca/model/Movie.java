package com.twu.biblioteca.model;

/**
 * Movie is responsible for holding all the information about a movie.
 *
 * @author Desiree Kelly
 * @version 2.0
 */
public class Movie {

    private String name;
    private int year;
    private String director;
    private String movieRating;

    public Movie(String name, int year, String director, String movieRating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.movieRating = movieRating;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public String getMovieRating() {

        return movieRating;
    }

    public String toString() {
        return this.name + ", " + this.year + ", " + this.director + ", " + this.movieRating;
    }

    @Override
    public boolean equals(Object obj) {
        if (!obj.getClass().equals(this.getClass())) {
            return false;
        }

        Movie otherMovie = (Movie) obj;

        return this.name.equals(otherMovie.name)
                && this.year == otherMovie.year
                && this.director.equals(otherMovie.director)
                && this.movieRating.equals(otherMovie.movieRating);
    }
}