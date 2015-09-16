package com.thoughtworks.biblioteca;

public class CheckInBookMenuOption implements MenuOption {

    private InputReader inputReader;
    private Library library;
    private User currentUser;
    private ConsoleDisplayFactory consoleDisplayFactory;

    public CheckInBookMenuOption(InputReader inputReader, Library library) {
        this.inputReader = inputReader;
        this.library = library;
    }

    @Override
    public void doOperation() {
        String bookName = inputReader.read();
        if (library.checkIn(new Book(bookName), currentUser)) {
            System.out.println("Thank you for returning the book.");
        } else {
            System.out.println("That is not a valid book to return.");
        }
    }
}
