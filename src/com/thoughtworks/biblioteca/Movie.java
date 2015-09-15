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
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        Movie thatMovie = (Movie) that;
        return name.equals(thatMovie.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return String.format("%-30s%-30s%-30s%-30s", this.name, this.year, this.director, this.rating);
    }
}
