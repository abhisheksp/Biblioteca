package com.thoughtworks.biblioteca;

import java.util.ArrayList;

/* Library has a list of books and can do checkin, checkout operations */
public class Library {

    ArrayList<Book> availableBooks;
    ArrayList<Book> checkedOutBooks = new ArrayList<Book>();

    public Library(ArrayList<Book> availableBooks) {
        this.availableBooks = availableBooks;
    }

    public String format() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%-30s%-30s%-30s\n", "Name", "Author", "Year Published"));
        for (Book book : availableBooks) {
            stringBuilder.append(book.toString() + "\n");
        }
        return stringBuilder.toString();
    }

    public boolean checkOut(Book book) {
        if (availableBooks.contains(book)) {
            int bookIndex = availableBooks.indexOf(book);
            checkedOutBooks.add(availableBooks.get(bookIndex));
            availableBooks.remove(book);
            return true;
        }
        return false;
    }

    public boolean checkIn(Book book) {
        if (checkedOutBooks.contains(book)) {
            int bookIndex = checkedOutBooks.indexOf(book);
            availableBooks.add(checkedOutBooks.get(bookIndex));
            checkedOutBooks.remove(book);
            return true;
        }
        return false;
    }
}
