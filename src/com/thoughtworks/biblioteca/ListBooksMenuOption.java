package com.thoughtworks.biblioteca;

public class ListBooksMenuOption implements MenuOption{

    private BookLibrary bookLibrary;
    private ConsoleDisplayFactory consoleDisplayFactory;

    public ListBooksMenuOption(BookLibrary bookLibrary, ConsoleDisplayFactory consoleDisplayFactory) {
        this.bookLibrary = bookLibrary;
        this.consoleDisplayFactory = consoleDisplayFactory;
    }

    @Override
    public void doOperation(){
        consoleDisplayFactory.getNewConsoleDisplay(bookLibrary.format()).display();
    }
}
