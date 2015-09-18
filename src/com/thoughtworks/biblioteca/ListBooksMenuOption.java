package com.thoughtworks.biblioteca;

/* ListBooksMenuOption has booklibrary, consoleDisplayFactory which it delegates to list books */
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
