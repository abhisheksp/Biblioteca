package com.thoughtworks.biblioteca;

import java.util.HashMap;

public class Parser {

    private InputReader inputReader;
    private Library library;
    private HashMap<String, MenuOption> menuOptionsMap;
    private ConsoleDisplayFactory consoleDisplayFactory;
    private MovieLibrary movieLibrary;
    private User currentUser;
    private Authenticator authenticator;

    public Parser(InputReader inputReader, Library library, MovieLibrary movieLibrary, ConsoleDisplayFactory consoleDisplayFactory, User currentUser, Authenticator authenticator) {
        this.inputReader = inputReader;
        this.library = library;
        this.consoleDisplayFactory = consoleDisplayFactory;
        this.movieLibrary = movieLibrary;
        this.currentUser = currentUser;
        this.authenticator = authenticator;
        configureMenuOptionsMap(currentUser);
    }

    private void configureMenuOptionsMap(User currentUser) {
        if(currentUser.role().equals("guest"))
            configureGuestMenuOptions();
    }

    private void configureGuestMenuOptions(){
        menuOptionsMap = new HashMap<String, MenuOption>();
        menuOptionsMap.put("1", new ListBooksMenuOption(library, consoleDisplayFactory));
    }

    public MenuOption parse(String rawInput) {
        MenuOption menuOption = menuOptionsMap.get(rawInput);
        return menuOption == null ? menuOptionsMap.get("invalid") : menuOption;
    }
}
