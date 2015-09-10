package com.thoughtworks.biblioteca;

/* Book has name, author and year of publish which it can format itself */
public class Book {

    private String name;
    private String author;
    private int year;

    public Book(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public Book(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        Book thatBook = (Book) that;
        return name.equals(thatBook.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return String.format("%-30s%-30s%-30s", this.name, this.author, this.year);
    }
}
