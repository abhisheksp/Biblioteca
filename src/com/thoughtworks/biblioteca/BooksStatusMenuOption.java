package com.thoughtworks.biblioteca;

public class BooksStatusMenuOption implements MenuOption{

    private BookLibrary bookLibrary;
    private ConsoleDisplayFactory consoleDisplayFactory;

    public BooksStatusMenuOption(BookLibrary bookLibrary, ConsoleDisplayFactory consoleDisplayFactory) {
        this.bookLibrary = bookLibrary;
        this.consoleDisplayFactory = consoleDisplayFactory;
    }

    @Override
    public void doOperation() {
        String bookCheckOutInformation = bookLibrary.bookCheckOutInformation();
        ConsoleDisplay consoleDisplay = consoleDisplayFactory.getNewConsoleDisplay(bookCheckOutInformation);
        consoleDisplay.display();
    }
}
