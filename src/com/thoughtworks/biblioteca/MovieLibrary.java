package com.thoughtworks.biblioteca;

import java.util.ArrayList;

/* MovieLibrary has a list of movies and can do checkout operation and can format itself*/
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
        if (availableMovies.contains(movie)) {
            availableMovies.remove(movie);
            return true;
        }
        return false;
    }
}
