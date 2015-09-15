package com.thoughtworks.biblioteca;

public class ListMoviesMenuOption {

    private MovieLibrary movieLibrary;
    private ConsoleDisplayFactory consoleDisplayFactory;

    public ListMoviesMenuOption(MovieLibrary movieLibrary, ConsoleDisplayFactory consoleDisplayFactory) {
        this.movieLibrary = movieLibrary;
        this.consoleDisplayFactory = consoleDisplayFactory;
    }

    public void doOperation() {
        movieLibrary.format();
    }
}
