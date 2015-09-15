package com.thoughtworks.biblioteca;

public class CheckOutMovieMenuOption {

    private InputReader inputReader;
    private MovieLibrary movieLibrary;

    public CheckOutMovieMenuOption(InputReader inputReader, MovieLibrary movieLibrary) {
        this.inputReader = inputReader;
        this.movieLibrary = movieLibrary;
    }

    public void doOperation() {
        inputReader.read();
    }
}
