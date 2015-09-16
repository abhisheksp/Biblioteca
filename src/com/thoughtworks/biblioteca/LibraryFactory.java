package com.thoughtworks.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

/* Library factory manufactures a default Library and returns it */
public class LibraryFactory {

    ArrayList<Book> books;
    ArrayList<Book> checkedOutBooks;
    HashMap<Book, User> bookUserHashMap;

    public LibraryFactory() {
        books = new ArrayList<Book>();
        books.add(new Book("Brief History of Time", "Stephen Hawking", 1988));
        books.add(new Book("Crime and Punishment", "Fyodor Dostoyevsky", 1866));
        books.add(new Book("Seven Minutes", "Irving Wallace", 1969));
        this.checkedOutBooks = new ArrayList<Book>();
        this.bookUserHashMap = new HashMap<Book, User>();
    }

    public Library getDefaultLibrary() {
        return new Library(books, checkedOutBooks, bookUserHashMap);
    }
}
