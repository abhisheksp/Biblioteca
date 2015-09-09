package com.thoughtworks.biblioteca;

import java.util.ArrayList;

/* Library has a list of books and can display,checkout them */
public class Library {

    ArrayList<Book> bookList = new ArrayList<Book>();

    public Library(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public void display() {
        String columnHeader = "Book" + "\t" + "Author" + "\t" + "Year Published" + "\n";
        System.out.print(columnHeader);
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    public void checkOutBook(Book book) {
        if (bookList.remove(book))
            System.out.println("Thank you! Enjoy the book");
        else
            System.out.println("That book is not available.");
    }

    public void checkIn(Book book) {
        bookList.add(book);
    }
}
