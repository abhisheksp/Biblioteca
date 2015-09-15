package com.thoughtworks.biblioteca;

public class CheckOutMovieMenuOption {

    private final int UNKNOWN_YEAR  = 0;
    private final String UNKNOWN_DIRECTOR  = "";
    private final String UNKNOWN_RATING  = "";

    private InputReader inputReader;
    private MovieLibrary movieLibrary;


    public CheckOutMovieMenuOption(InputReader inputReader, MovieLibrary movieLibrary) {
        this.inputReader = inputReader;
        this.movieLibrary = movieLibrary;
    }

    public void doOperation() {
        String movieName = inputReader.read();
        movieLibrary.checkOut(new Movie(movieName, UNKNOWN_YEAR, UNKNOWN_DIRECTOR, UNKNOWN_RATING));
    }
}
