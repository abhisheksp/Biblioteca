package com.thoughtworks.biblioteca;

import java.util.HashMap;

public class Parser {

    private String input;
    private InputReader inputReader;
    private Library library;
    private HashMap<String, MenuOption> menuOptionsMap;

    public Parser(String input, InputReader inputReader, Library library) {
        this.input = input;
        this.inputReader = inputReader;
        this.library = library;
        configureMenuOptionsMap();
    }

    private void configureMenuOptionsMap() {
        menuOptionsMap = new HashMap<String, MenuOption>();
        menuOptionsMap.put("1", new ListBooksMenuOption(library));
        menuOptionsMap.put("2", new QuitMenuOption());
        menuOptionsMap.put("3", new CheckoutBookMenuOption(inputReader, library));
        menuOptionsMap.put("4", new CheckInBookMenuOption(inputReader, library));
        menuOptionsMap.put("invalid", new InvalidMenuOption("Select a valid option!"));
    }

    public MenuOption parse() {
        MenuOption menuOption = menuOptionsMap.get(input);
        return menuOption == null ? menuOptionsMap.get("invalid") : menuOption;
    }
}
