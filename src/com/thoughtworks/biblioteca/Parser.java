package com.thoughtworks.biblioteca;

public class Parser {

    private String input;
    private Library library;

    public Parser(String input, Library library) {
        this.input = input;
        this.library = library;
    }

    public MenuOption parse() {
        return new ListBooksMenuOption(library);
    }
}
