package com.thoughtworks.biblioteca;

public class ListMoviesMenuOption implements MenuOption{

    private MovieLibrary movieLibrary;
    private ConsoleDisplayFactory consoleDisplayFactory;

    public ListMoviesMenuOption(MovieLibrary movieLibrary, ConsoleDisplayFactory consoleDisplayFactory) {
        this.movieLibrary = movieLibrary;
        this.consoleDisplayFactory = consoleDisplayFactory;
    }

    public void doOperation() {
        consoleDisplayFactory.getNewConsoleDisplay(movieLibrary.format()).display();
    }
}
