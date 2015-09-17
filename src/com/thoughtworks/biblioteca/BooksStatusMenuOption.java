package com.thoughtworks.biblioteca;

public class BooksStatusMenuOption {

    private Library library;
    private ConsoleDisplayFactory consoleDisplayFactory;

    public BooksStatusMenuOption(Library library, ConsoleDisplayFactory consoleDisplayFactory) {
        this.library = library;
        this.consoleDisplayFactory = consoleDisplayFactory;
    }

    public void doOperation() {
        library.bookCheckOutInformation();
    }
}
