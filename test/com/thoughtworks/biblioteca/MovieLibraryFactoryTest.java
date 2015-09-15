package com.thoughtworks.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MovieLibraryFactoryTest {

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
    public void shouldReturnDefaultMovieLibrary() {
        MovieLibrary movieLibrary = new MovieLibraryFactory().getDefaultMovieLibrary();

        assertEquals(String.format("%-30s%-30s%-30s%-30s\n", "Name", "Year", "Director", "Rating") +
                String.format("%-30s%-30d%-30s%-30s\n", "Inception", 2010, "Christopher Nolan", "10.0") +
                String.format("%-30s%-30d%-30s%-30s\n", "Avatar", 2009, "James Cameron", "9.0") +
                String.format("%-30s%-30d%-30s%-30s\n", "The Ring", 2002, "Gore Verbinski", "unrated"), movieLibrary.format());
    }
}
