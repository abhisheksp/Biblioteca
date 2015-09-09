package com.thoughtworks.biblioteca;

public class CheckInBookMenuOption implements MenuOption{

    private InputReader inputReader;
    private Library library;

    public CheckInBookMenuOption(InputReader inputReader, Library library) {
        this.inputReader = inputReader;
        this.library = library;
    }

    @Override
    public void doOperation() {
        String bookName = inputReader.read();
        library.checkIn(new Book(bookName));
    }
}
