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
    public void shouldDisplayBookListWhenDisplayIsCalled() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Brief History of Time", "Stephen Hawking", 1988));
        books.add(new Book("Crime and Punishment", "Fyodor Dostoyevsky", 1866));
        books.add(new Book("Seven Minutes", "Irving Wallace", 1969));
        Library library = new Library(books);

        library.display();

        assertEquals("Book\tAuthor\tYear Published\n" + "Brief History of Time\tStephen Hawking\t1988\n" +
                "Crime and Punishment\tFyodor Dostoyevsky\t1866\n" +
                "Seven Minutes\tIrving Wallace\t1969\n", outContent.toString());
    }

    @Test
    public void shouldCheckOutBookGivenBookName() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Brief History of Time", "Stephen Hawking", 1988));
        books.add(new Book("Crime and Punishment", "Fyodor Dostoyevsky", 1866));
        books.add(new Book("Seven Minutes", "Irving Wallace", 1969));
        Library library = new Library(books);

        books.remove(new Book("Brief History of Time"));
        library.checkOutBook(new Book("Brief History of Time"));
        library.display();

        assertEquals("Book\tAuthor\tYear Published\n" +
                "Crime and Punishment\tFyodor Dostoyevsky\t1866\n" +
                "Seven Minutes\tIrving Wallace\t1969\n", outContent.toString());
    }

    @Test
    public void shouldPrintSuccessMessageOnSuccessfulCheckout(){
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Brief History of Time", "Stephen Hawking", 1988));
        books.add(new Book("Crime and Punishment", "Fyodor Dostoyevsky", 1866));
        books.add(new Book("Seven Minutes", "Irving Wallace", 1969));
        Library library = new Library(books);

        books.remove(new Book("Brief History of Time"));
        library.checkOutBook(new Book("Brief History of Time"));

        assertEquals("Thank you! Enjoy the book\n", outContent.toString());
    }
}
