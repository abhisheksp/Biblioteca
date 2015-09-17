package com.thoughtworks.biblioteca;

public class CheckoutBookMenuOption implements MenuOption {

    private InputReader inputReader;
    private Library library;
    private User currentUser;
    private ConsoleDisplayFactory consoleDisplayFactory;

    public CheckoutBookMenuOption(InputReader inputReader, Library library, User currentUser, ConsoleDisplayFactory consoleDisplayFactory) {
        this.inputReader = inputReader;
        this.library = library;
        this.currentUser = currentUser;
        this.consoleDisplayFactory = consoleDisplayFactory;
    }

    @Override
    public void doOperation() {
        String bookName = inputReader.read();
        if (library.checkOut(new Book(bookName), currentUser)) {
            consoleDisplayFactory.getNewConsoleDisplay("Thank you! Enjoy the book").display();
        } else {
            consoleDisplayFactory.getNewConsoleDisplay("That book is not available.").display();
        }
    }
}
