package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class BookList {

    ArrayList<Book> bookList = new ArrayList<Book>();

    public BookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public void display() {
        String columnHeader = "Book"+"\t"+"Author"+"\t"+"Year Published"+"\n";
        System.out.print(columnHeader);
        System.out.print(bookList);
    }
}
