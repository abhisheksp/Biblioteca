package com.thoughtworks.biblioteca;

import java.util.HashMap;

/* Parser takes in rawInput and returns a MenuOption based on the input */
public class Parser {

    private InputReader inputReader;
    private BookLibrary bookLibrary;
    private HashMap<String, MenuOption> menuOptionsMap;
    private ConsoleDisplayFactory consoleDisplayFactory;
    private MovieLibrary movieLibrary;
    private User currentUser;
    private Authenticator authenticator;

    public Parser(InputReader inputReader, BookLibrary bookLibrary, MovieLibrary movieLibrary, ConsoleDisplayFactory consoleDisplayFactory, User currentUser, Authenticator authenticator) {
        this.inputReader = inputReader;
        this.bookLibrary = bookLibrary;
        this.consoleDisplayFactory = consoleDisplayFactory;
        this.movieLibrary = movieLibrary;
        this.currentUser = currentUser;
        this.authenticator = authenticator;
        configureMenuOptionsMap(currentUser);
    }

    private void configureMenuOptionsMap(User currentUser) {
        if(currentUser.role().equals("librarian"))
            configureLibrarianMenuOptions();
        else if(currentUser.role().equals("user"))
            configureUserMenuOptions();
        else
            configureGuestMenuOptions();
    }

    private void configureLibrarianMenuOptions() {
        menuOptionsMap = new HashMap<String, MenuOption>();
        menuOptionsMap.put("1", new ListBooksMenuOption(bookLibrary, consoleDisplayFactory));
        menuOptionsMap.put("2", new ListMoviesMenuOption(movieLibrary, consoleDisplayFactory));
        menuOptionsMap.put("3", new CheckOutBookMenuOption(inputReader, bookLibrary, currentUser, consoleDisplayFactory));
        menuOptionsMap.put("4", new CheckInBookMenuOption(inputReader, bookLibrary, currentUser, consoleDisplayFactory));
        menuOptionsMap.put("5", new CheckOutMovieMenuOption(inputReader, movieLibrary, consoleDisplayFactory));
        menuOptionsMap.put("6", new BooksStatusMenuOption(bookLibrary, consoleDisplayFactory));
        menuOptionsMap.put("7", new UserInformationMenuOption(consoleDisplayFactory, currentUser));
        menuOptionsMap.put("8", new LogoutMenuOption());
        menuOptionsMap.put("9", new QuitMenuOption());
        menuOptionsMap.put("invalid", new InvalidMenuOption("Select a valid option!", consoleDisplayFactory));
    }

    private void configureUserMenuOptions() {
        menuOptionsMap = new HashMap<String, MenuOption>();
        menuOptionsMap.put("1", new ListBooksMenuOption(bookLibrary, consoleDisplayFactory));
        menuOptionsMap.put("2", new ListMoviesMenuOption(movieLibrary, consoleDisplayFactory));
        menuOptionsMap.put("3", new CheckOutBookMenuOption(inputReader, bookLibrary, currentUser, consoleDisplayFactory));
        menuOptionsMap.put("4", new CheckInBookMenuOption(inputReader, bookLibrary, currentUser, consoleDisplayFactory));
        menuOptionsMap.put("5", new CheckOutMovieMenuOption(inputReader, movieLibrary, consoleDisplayFactory));
        menuOptionsMap.put("6", new UserInformationMenuOption(consoleDisplayFactory, currentUser));
        menuOptionsMap.put("7", new LogoutMenuOption());
        menuOptionsMap.put("8", new QuitMenuOption());
        menuOptionsMap.put("invalid", new InvalidMenuOption("Select a valid option!", consoleDisplayFactory));
    }

    private void configureGuestMenuOptions(){
        menuOptionsMap = new HashMap<String, MenuOption>();
        menuOptionsMap.put("1", new ListBooksMenuOption(bookLibrary, consoleDisplayFactory));
        menuOptionsMap.put("2", new ListMoviesMenuOption(movieLibrary, consoleDisplayFactory));
        menuOptionsMap.put("3", new CheckOutMovieMenuOption(inputReader, movieLibrary, consoleDisplayFactory));
        menuOptionsMap.put("4", new LoginMenuOption(authenticator, inputReader, consoleDisplayFactory, currentUser));
        menuOptionsMap.put("5", new QuitMenuOption());
        menuOptionsMap.put("invalid", new InvalidMenuOption("Select a valid option!", consoleDisplayFactory));
    }

    public MenuOption parse(String rawInput) {
        MenuOption menuOption = menuOptionsMap.get(rawInput);
        return menuOption == null ? menuOptionsMap.get("invalid") : menuOption;
    }
}
