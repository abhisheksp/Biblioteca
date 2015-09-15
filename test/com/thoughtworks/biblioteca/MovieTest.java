package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MovieTest {

    @Test
    public void shouldFormatItselfWithMovieNameYearDirectorRatingWhenItIsPrinted() {
        Movie movie = new Movie("Inception", 2010, "Christopher Nolan", "10.0");

        assertEquals(String.format("%-30s%-30d%-30s%-30s", "Inception", 2010, "Christopher Nolan", "10.0"), movie.toString());
    }

    @Test
    public void shouldBeEqualToItself() {
        Movie movie = new Movie("Inception", 2010, "Christopher Nolan", "10.0");

        assertEquals(movie, movie);
    }

    @Test
    public void shouldBeEqualToAnotherMovieWithSameName() {
        assertEquals(new Movie("Inception", 2010, "Christopher Nolan", "10.0"), new Movie("Inception", 2011, "doesn't matter", "9.0"));
    }

    @Test
    public void shouldNotBeEqualToAnotherMovieWithDifferentName() {
        assertNotEquals(new Movie("Inception", 2010, "Christopher Nolan", "10.0"), new Movie("Not Inception", 2011, "doesn't matter", "9.0"));
    }


    @Test
    public void shouldNotBeEqualWhenComparingAMovieToNull() {
        assertNotEquals(new Movie("Inception", 2010, "Christopher Nolan", "10.0"), null);
    }

    @Test
    public void shouldHaveSameHashCodeForMoviesWithSameName() {
        assertEquals(new Movie("Inception", 2010, "Christopher Nolan", "10.0").hashCode(), new Movie("Inception", 2011, "doesn't matter", "9.0").hashCode());
    }
}
