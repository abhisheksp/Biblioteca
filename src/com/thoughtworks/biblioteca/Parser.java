package com.thoughtworks.biblioteca;

public class Parser {

    private String input;
    private Library library;

    public Parser(String input, Library library) {
        this.input = input;
        this.library = library;
    }

    public MenuOption parse() {
        if(input.equals("1"))
            return new ListBooksMenuOption(library);
        else
            return new QuitMenuOption();
    }
}
