package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BookTest {

    @Test
    public void shouldDisplayBookNameAuthorAndYearPublishedWhenItIsPrinted() {
        Book book = new Book("Brief History of Time", "Stephen Hawking", 1988);

        assertEquals(String.format("%-30s%-30s%-30s", "Brief History of Time", "Stephen Hawking", 1988), book.toString());
    }

    @Test
    public void shouldBeEqualWhenComparingABookToItself() {
        Book Book = new Book("Brief History of Time", "Stephen Hawking", 1988);

        assertEquals(Book, Book);
    }

    @Test
    public void shouldNotBeEqualWhenComparingABookToNull() {
        assertNotEquals(new Book("Brief History of Time", "Stephen Hawking", 1988), null);
    }

    @Test
    public void shouldNotBeEqualWhenComparingABookToNonBookEntity() {
        assertNotEquals(new Book("Brief History of Time", "Stephen Hawking", 1988), "I am Not a Book");
    }

    @Test
    public void shouldHaveSameHashCodeComparingABookToItself() {
        Book Book = new Book("Brief History of Time", "Stephen Hawking", 1988);

        assertEquals(Book.hashCode(), Book.hashCode());
    }

    @Test
    public void shouldHaveSameHashCodeComparingABookToAnotherBookWithSameCoordinates() {
        assertEquals(new Book("Brief History of Time", "Stephen Hawking", 1988), new Book("Brief History of Time", "Stephen Hawking", 1988));
    }
}
