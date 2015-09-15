package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class MovieLibrary {

    ArrayList<Movie> availableMovies;

    public MovieLibrary(ArrayList<Movie> availableMovies) {
        this.availableMovies = availableMovies;
    }

    public String format() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%-30s%-30s%-30s%-30s\n", "Name", "Year", "Director", "Rating"));
        for (Movie movie : availableMovies) {
            stringBuilder.append(movie.toString() + "\n");
        }
        return stringBuilder.toString();
    }

    public boolean checkOut(Movie movie) {
            return true;
    }
}
