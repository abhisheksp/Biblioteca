package com.thoughtworks.biblioteca;

public class Parser {

    private String input;
    private InputReader inputReader;
    private Library library;

    public Parser(String input, InputReader inputReader, Library library) {
        this.input = input;
        this.inputReader = inputReader;
        this.library = library;
    }

    public MenuOption parse() {
        if(input.equals("1"))
            return new ListBooksMenuOption(library);
        else if(input.equals("2"))
            return new QuitMenuOption();
        else if(input.equals("3"))
            return new CheckoutBookMenuOption(inputReader, library);
        else
            return new CheckInBookMenuOption(inputReader, library);
    }
}
