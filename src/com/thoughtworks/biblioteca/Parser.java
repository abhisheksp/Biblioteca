package com.thoughtworks.biblioteca;

import java.util.HashMap;

public class Parser {

    private InputReader inputReader;
    private Library library;
    private HashMap<String, MenuOption> menuOptionsMap;
    private ConsoleDisplayFactory consoleDisplayFactory;

    public Parser(InputReader inputReader, Library library, ConsoleDisplayFactory consoleDisplayFactory) {
        this.inputReader = inputReader;
        this.library = library;
        this.consoleDisplayFactory = consoleDisplayFactory;
        configureMenuOptionsMap();
    }

    private void configureMenuOptionsMap() {
        menuOptionsMap = new HashMap<String, MenuOption>();
        menuOptionsMap.put("1", new ListBooksMenuOption(library, consoleDisplayFactory));
        menuOptionsMap.put("2", new QuitMenuOption());
        menuOptionsMap.put("3", new CheckoutBookMenuOption(inputReader, library));
        menuOptionsMap.put("4", new CheckInBookMenuOption(inputReader, library));
        menuOptionsMap.put("invalid", new InvalidMenuOption("Select a valid option!", consoleDisplayFactory));
    }

    public MenuOption parse(String rawInput) {
        MenuOption menuOption = menuOptionsMap.get(rawInput);
        return menuOption == null ? menuOptionsMap.get("invalid") : menuOption;
    }
}
