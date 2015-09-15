package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    @Test
    public void shouldFormatItselfWithMovieNameYearDirectorRatingWhenItIsPrinted() {
        Movie movie = new Movie("Inception", 2010, "Christopher Nolan", "10.0");

        assertEquals(String.format("%-30s%-30d%-30s%-30s", "Inception", 2010, "Christopher Nolan", 10.0), movie.toString());
    }
}
