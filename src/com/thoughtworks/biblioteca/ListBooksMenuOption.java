package com.thoughtworks.biblioteca;

public class ListBooksMenuOption implements MenuOption{

    private Library library;
    private ConsoleDisplayFactory consoleDisplayFactory;

    public ListBooksMenuOption(Library library, ConsoleDisplayFactory consoleDisplayFactory) {
        this.library = library;
        this.consoleDisplayFactory = consoleDisplayFactory;
    }

    @Override
    public void doOperation(){
        ConsoleDisplay consoleDisplay= consoleDisplayFactory.getNewConsoleDisplay(library.format());
        consoleDisplay.display();
    }
}
