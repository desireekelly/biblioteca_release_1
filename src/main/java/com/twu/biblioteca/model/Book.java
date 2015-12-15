package com.twu.biblioteca.model;

/**
 * book is responsible for holding all the information about a book.
 *
 * @author Desiree Kelly
 * @version 1.0
 */
public class Book {

    private String title;
    private String author;
    private int yearPublished;

    /**
     * Construct a book with information about each book.
     */
    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    /**
     * Get the title of a book.
     *
     * @return Returns the title of a book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get the author of a book.
     *
     * @return Returns the author of a book.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Get the year published for a book.
     *
     * @return Returns the year published for a book.
     */
    public int getYearPublished() {
        return yearPublished;
    }

    /**
     * Get the information about a book.
     *
     * @return Returns the information about a book as a readable string.
     */
    public String toString() {
        return this.title + ", " + this.author + ", " + this.yearPublished;
    }

    /**
     * Get the information about a book and compare it with the information about another book.
     *
     * @return Returns the information about a book if the two books being compared are the same.
     */
    @Override
    public boolean equals(Object obj) {
        if (!obj.getClass().equals(this.getClass())) {
            return false;
        }

        Book otherBook = (Book) obj;

        return this.title.equals(otherBook.title)
                && this.author.equals(otherBook.author)
                && this.yearPublished == otherBook.yearPublished;
    }
}
