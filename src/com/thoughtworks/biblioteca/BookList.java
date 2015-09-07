package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class BookList implements MenuOption {

    ArrayList<Book> bookList = new ArrayList<Book>();

    public BookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public void display() {
        String columnHeader = "Book"+"\t"+"Author"+"\t"+"Year Published"+"\n";
        System.out.print(columnHeader);
        for (Book book : bookList){
            System.out.println(book);
        }
    }
}
