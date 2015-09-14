package com.thoughtworks.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

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

        assertEquals(String.format("%-30s%-30s%-30s\n", "Name", "Author", "Year Published")  +
                String.format("%-30s%-30s%-30s\n", "Brief History of Time", "Stephen Hawking", "1988") +
                String.format("%-30s%-30s%-30s\n", "Crime and Punishment", "Fyodor Dostoyevsky", "1866")  +
                String.format("%-30s%-30s%-30s\n", "Seven Minutes", "Irving Wallace", "1969"), library.format());
    }

    @Test
    public void shouldCheckInGivenBookIntoBookListWhenCheckInIsCalled() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Brief History of Time", "Stephen Hawking", 1988));
        books.add(new Book("Crime and Punishment", "Fyodor Dostoyevsky", 1866));
        books.add(new Book("Seven Minutes", "Irving Wallace", 1969));
        Library library = new Library(books);

        library.checkOut(new Book("Brief History of Time"));
        library.checkIn(new Book("Brief History of Time"));

        assertEquals("Thank you! Enjoy the book\n" +
                "Thank you for returning the book.\n" +
                String.format("%-30s%-30s%-30s\n", "Name", "Author", "Year Published")  +
                String.format("%-30s%-30s%-30s\n", "Crime and Punishment", "Fyodor Dostoyevsky", "1866")  +
                String.format("%-30s%-30s%-30s\n", "Seven Minutes", "Irving Wallace", "1969") +
                String.format("%-30s%-30s%-30s\n", "Brief History of Time", "Stephen Hawking", "1988"), "Thank you! Enjoy the book\n" +
                "Thank you for returning the book.\n" + library.format());
    }

    @Test
    public void shouldDisplaySuccessfulReturnMessageWhenCheckInIsSuccessful() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Brief History of Time", "Stephen Hawking", 1988));
        books.add(new Book("Crime and Punishment", "Fyodor Dostoyevsky", 1866));
        books.add(new Book("Seven Minutes", "Irving Wallace", 1969));
        Library library = new Library(books);

        library.checkOut(new Book("Brief History of Time"));
        library.checkIn(new Book("Brief History of Time"));
        library.format();

        assertEquals("Thank you! Enjoy the book\n" +
                "Thank you for returning the book.\n" +
                String.format("%-30s%-30s%-30s\n", "Name", "Author", "Year Published")  +
                String.format("%-30s%-30s%-30s\n", "Crime and Punishment", "Fyodor Dostoyevsky", "1866")  +
                String.format("%-30s%-30s%-30s\n", "Seven Minutes", "Irving Wallace", "1969") +
                String.format("%-30s%-30s%-30s\n", "Brief History of Time", "Stephen Hawking", "1988"), "Thank you! Enjoy the book\n" +
                "Thank you for returning the book.\n" + library.format());
    }
}
