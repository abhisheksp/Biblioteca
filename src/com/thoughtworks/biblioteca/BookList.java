package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class BookList {

    ArrayList<String> bookList = new ArrayList<String>();

    public BookList(ArrayList<String> bookList) {
        this.bookList = bookList;
    }

    public void display() {
        System.out.print(bookList);
    }
}
