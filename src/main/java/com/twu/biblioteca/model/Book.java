package com.twu.biblioteca.model;

/**
 * Book is responsible for holding all the information about a book.
 *
 * @author Desiree Kelly
 * @version 1.0
 */
public class Book implements BorrowableItem {

    private String title;
    private String author;
    private int yearPublished;

    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public String toString() {
        return this.title + ", " + this.author + ", " + this.yearPublished;
    }

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