package com.thoughtworks.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BibliotecaApplicationTest {

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
    public void shouldDisplayWelcomeMessageWhenApplicationStarts(){
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication();

        bibliotecaApplication.start();

        assertEquals("Sup?\n", outContent.toString());
    }

    @Test
    public void shouldReturnBookListWhenBookListIsInvoked() {
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication();
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Brief History of Time", "Stephen Hawking", 1988));
        books.add(new Book("Crime and Punishment", "Fyodor Dostoyevsky", 1866));
        books.add(new Book("Seven Minutes", "Irving Wallace", 1969));

        assertEquals(books.toString(), bibliotecaApplication.booklist().toString());
    }
}
