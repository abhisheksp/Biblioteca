package com.thoughtworks.biblioteca;

import java.util.ArrayList;

/* ConsoleDisplay takes a message or list that it prints to console */
public class ConsoleDisplay {
    private String message;

    public ConsoleDisplay(String message) {
        this.message = message;
    }

    public void display() {
        System.out.print(message);
    }

    public void displayList(ArrayList<String> bookList) {
        System.out.print(bookList);
    }
}
