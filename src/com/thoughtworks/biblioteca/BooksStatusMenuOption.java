package com.thoughtworks.biblioteca;

public class BooksStatusMenuOption implements MenuOption{

    private Library library;
    private ConsoleDisplayFactory consoleDisplayFactory;

    public BooksStatusMenuOption(Library library, ConsoleDisplayFactory consoleDisplayFactory) {
        this.library = library;
        this.consoleDisplayFactory = consoleDisplayFactory;
    }

    @Override
    public void doOperation() {
        String bookCheckOutInformation = library.bookCheckOutInformation();
        ConsoleDisplay consoleDisplay = consoleDisplayFactory.getNewConsoleDisplay(bookCheckOutInformation);
        consoleDisplay.display();
    }
}
