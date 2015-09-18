package com.thoughtworks.biblioteca;

/* Books Status Menu Option has book library which can give books checkout information and displayed
via console display */
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
