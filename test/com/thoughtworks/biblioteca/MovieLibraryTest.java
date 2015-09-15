package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MovieLibraryTest {

    private final int UNKNOWN_YEAR  = 0;
    private final String UNKNOWN_DIRECTOR  = "";
    private final String UNKNOWN_RATING  = "";

    @Test
    public void shouldReturnFormattedStringOfMovieLibraryWhenFormatIsCalled() {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("Inception", 2010, "Christopher Nolan", "10.0"));
        movies.add(new Movie("Avatar", 2009, "James Cameron", "9.0"));
        movies.add(new Movie("The Ring", 2002, "Gore Verbinski", "unrated"));
        MovieLibrary movieLibrary = new MovieLibrary(movies);

        movieLibrary.format();

        assertEquals(String.format("%-30s%-30s%-30s%-30s\n", "Name", "Year", "Director", "Rating") +
                String.format("%-30s%-30d%-30s%-30s\n", "Inception", 2010, "Christopher Nolan", "10.0") +
                String.format("%-30s%-30d%-30s%-30s\n", "Avatar", 2009, "James Cameron", "9.0") +
                String.format("%-30s%-30d%-30s%-30s\n", "The Ring", 2002, "Gore Verbinski", "unrated"), movieLibrary.format());
    }

    @Test
    public void shouldReturnTrueWhenBookIsInAvailableBooksWhenCheckOutIsCalled() {
        MovieLibrary movieLibrary = new MovieLibraryFactory().getDefaultMovieLibrary();

        assertTrue(movieLibrary.checkOut(new Movie("Inception", UNKNOWN_YEAR, UNKNOWN_DIRECTOR, UNKNOWN_RATING)));
    }
}
