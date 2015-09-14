package com.thoughtworks.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LibraryTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setupStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(System.out);
    }

    @Test
    public void shouldReturnFormattedStringOfLibraryWhenFormatIsCalled() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Brief History of Time", "Stephen Hawking", 1988));
        books.add(new Book("Crime and Punishment", "Fyodor Dostoyevsky", 1866));
        books.add(new Book("Seven Minutes", "Irving Wallace", 1969));
        Library library = new Library(books);

        library.format();

        assertEquals(String.format("%-30s%-30s%-30s\n", "Name", "Author", "Year Published") +
                String.format("%-30s%-30s%-30s\n", "Brief History of Time", "Stephen Hawking", "1988") +
                String.format("%-30s%-30s%-30s\n", "Crime and Punishment", "Fyodor Dostoyevsky", "1866") +
                String.format("%-30s%-30s%-30s\n", "Seven Minutes", "Irving Wallace", "1969"), library.format());
    }

    @Test
    public void shouldReturnTrueWhenBookIsInAvailableBooksWhenCheckOutIsCalled() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Brief History of Time", "Stephen Hawking", 1988));
        books.add(new Book("Crime and Punishment", "Fyodor Dostoyevsky", 1866));
        books.add(new Book("Seven Minutes", "Irving Wallace", 1969));
        Library library = new Library(books);

        assertTrue(library.checkOut(new Book("Seven Minutes")));
    }

    @Test
    public void shouldReturnFalseWhenBookIsNotInAvailableBooksWhenCheckOutIsCalled() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Brief History of Time", "Stephen Hawking", 1988));
        books.add(new Book("Crime and Punishment", "Fyodor Dostoyevsky", 1866));
        books.add(new Book("Seven Minutes", "Irving Wallace", 1969));
        Library library = new Library(books);

        assertFalse(library.checkOut(new Book("Not Valid Stuff")));
    }

    @Test
    public void shouldReturnTrueWhenBookIsInCheckoutBooksWhenCheckInIsCalled() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Brief History of Time", "Stephen Hawking", 1988));
        books.add(new Book("Crime and Punishment", "Fyodor Dostoyevsky", 1866));
        books.add(new Book("Seven Minutes", "Irving Wallace", 1969));
        Library library = new Library(books);

        library.checkOut(new Book("Seven Minutes"));

        assertTrue(library.checkIn(new Book("Seven Minutes")));
    }

    @Test
    public void shouldReturnFalseWhenBookIsNotInCheckoutBooksWhenCheckInIsCalled() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Brief History of Time", "Stephen Hawking", 1988));
        books.add(new Book("Crime and Punishment", "Fyodor Dostoyevsky", 1866));
        books.add(new Book("Seven Minutes", "Irving Wallace", 1969));
        Library library = new Library(books);

        assertFalse(library.checkIn(new Book("Not Valid Stuff")));
    }
}
