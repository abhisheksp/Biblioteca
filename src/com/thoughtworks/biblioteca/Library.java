package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class Library implements MenuOption {

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
        bookList.remove(book);
    }
}
