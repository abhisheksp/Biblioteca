package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BibliotecaApplicationTest {

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
