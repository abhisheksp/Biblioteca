package com.thoughtworks.biblioteca;

public class CheckOutMovieMenuOption implements MenuOption{

    private final int UNKNOWN_YEAR = 0;
    private final String UNKNOWN_DIRECTOR = "";
    private final String UNKNOWN_RATING = "";

    private InputReader inputReader;
    private MovieLibrary movieLibrary;
    private ConsoleDisplayFactory consoleDisplayFactory;

    public CheckOutMovieMenuOption(InputReader inputReader, MovieLibrary movieLibrary, ConsoleDisplayFactory consoleDisplayFactory) {
        this.inputReader = inputReader;
        this.movieLibrary = movieLibrary;
        this.consoleDisplayFactory = consoleDisplayFactory;
    }

    public void doOperation() {
        String movieName = inputReader.read();
        if (movieLibrary.checkOut(new Movie(movieName, UNKNOWN_YEAR, UNKNOWN_DIRECTOR, UNKNOWN_RATING)))
            consoleDisplayFactory.getNewConsoleDisplay("Thank you! Enjoy the book").display();
        else
            consoleDisplayFactory.getNewConsoleDisplay("That movie is not available.").display();
    }
}
