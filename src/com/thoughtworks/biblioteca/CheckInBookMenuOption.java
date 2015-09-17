package com.thoughtworks.biblioteca;

public class CheckInBookMenuOption implements MenuOption {

    private InputReader inputReader;
    private BookLibrary bookLibrary;
    private User currentUser;
    private ConsoleDisplayFactory consoleDisplayFactory;

    public CheckInBookMenuOption(InputReader inputReader, BookLibrary bookLibrary, User currentUser, ConsoleDisplayFactory consoleDisplayFactory) {
        this.inputReader = inputReader;
        this.bookLibrary = bookLibrary;
        this.currentUser = currentUser;
        this.consoleDisplayFactory = consoleDisplayFactory;
    }

    @Override
    public void doOperation() {
        consoleDisplayFactory.getNewConsoleDisplay("Enter Book Name : ").display();
        String bookName = inputReader.read();
        if (bookLibrary.checkIn(new Book(bookName), currentUser)) {
            consoleDisplayFactory.getNewConsoleDisplay("Thank you for returning the book.").display();
        } else {
            consoleDisplayFactory.getNewConsoleDisplay("That is not a valid book to return.").display();
        }
    }
}
