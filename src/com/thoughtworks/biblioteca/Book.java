package com.thoughtworks.biblioteca;

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
        return !(name != null ? !name.equals(thatBook.name) : thatBook.name != null);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return name+"\t"+author+"\t"+year;
    }
}
