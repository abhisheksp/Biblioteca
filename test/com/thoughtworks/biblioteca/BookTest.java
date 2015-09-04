package com.thoughtworks.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void shouldDisplayBookNameAuthorAndYearPublishedWhenItIsPrinted(){
        Book book = new Book("Brief History of Time", "Stephen Hawking", 1988);

        assertEquals("Brief History of Time"+"\t"+"Stephen Hawking"+"\t"+"1988", book.toString());
    }
}
