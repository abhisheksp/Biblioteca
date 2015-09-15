package com.thoughtworks.biblioteca;

/* Movie has name, year, director and rating which it can format itself */
public class Movie {

    private String name;
    private int year;
    private String director;
    private String rating;

    public Movie(String name, int year, String director, String rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }
    
    @Override
    public String toString() {
        return String.format("%-30s%-30s%-30s%-30s", this.name, this.year, this.director, this.rating);
    }
}
