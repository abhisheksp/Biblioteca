package com.thoughtworks.biblioteca;

import java.util.ArrayList;

/* MovieLibraryFactory manufactures a movie library with predefined set of movies */
public class MovieLibraryFactory {

    ArrayList<Movie> movies;

    public MovieLibraryFactory() {
        movies = new ArrayList<Movie>();
        movies.add(new Movie("Inception", 2010, "Christopher Nolan", "10.0"));
        movies.add(new Movie("Avatar", 2009, "James Cameron", "9.0"));
        movies.add(new Movie("The Ring", 2002, "Gore Verbinski", "unrated"));
    }

    public MovieLibrary getDefaultMovieLibrary() {
        return new MovieLibrary(movies);
    }
}
