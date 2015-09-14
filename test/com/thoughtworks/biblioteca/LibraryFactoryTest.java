package com.thoughtworks.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class LibraryFactoryTest {

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
    public void shouldReturnDefaultLibrary() {
        Library library = new LibraryFactory().getDefaultLibrary();

        assertEquals(String.format("%-30s%-30s%-30s\n", "Name", "Author", "Year Published") +
                String.format("%-30s%-30s%-30s\n", "Brief History of Time", "Stephen Hawking", "1988") +
                String.format("%-30s%-30s%-30s\n", "Crime and Punishment", "Fyodor Dostoyevsky", "1866") +
                String.format("%-30s%-30s%-30s\n", "Seven Minutes", "Irving Wallace", "1969"), library.format());
    }
}
