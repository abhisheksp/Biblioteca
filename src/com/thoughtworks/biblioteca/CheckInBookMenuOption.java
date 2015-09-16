package com.thoughtworks.biblioteca;

public class CheckInBookMenuOption implements MenuOption {

    private InputReader inputReader;
    private Library library;
    private User currentUser;
    private ConsoleDisplayFactory consoleDisplayFactory;

    public CheckInBookMenuOption(InputReader inputReader, Library library, User currentUser, ConsoleDisplayFactory consoleDisplayFactory) {
        this.inputReader = inputReader;
        this.library = library;
        this.currentUser = currentUser;
        this.consoleDisplayFactory = consoleDisplayFactory;
    }

    @Override
    public void doOperation() {
        String bookName = inputReader.read();
        if (library.checkIn(new Book(bookName), currentUser)) {
            consoleDisplayFactory.getNewConsoleDisplay("Thank you for returning the book.").display();
        } else {
            consoleDisplayFactory.getNewConsoleDisplay("That is not a valid book to return.").display();
        }
    }
}
