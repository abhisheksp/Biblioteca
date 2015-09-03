package com.thoughtworks.biblioteca;

public class ConsoleDisplay {
    private String message;

    public ConsoleDisplay(String message) {
        this.message = message;
    }

    public void display() {
        System.out.print(message);
    }
}
