package com.thoughtworks.biblioteca;

public class Controller {

    WelcomeMessage welcomeMessage;

    ConsoleDisplayFactory consoleDisplayFactory;
    MainMenuFactory mainMenuFactory;
    InputReader inputReader;
    Parser parser;
    User currentUser;
    Library library;
    MovieLibrary movieLibrary;

    public Controller(WelcomeMessage welcomeMessage, MainMenuFactory mainMenuFactory, ConsoleDisplayFactory consoleDisplayFactory, InputReader inputReader, Parser parser, User currentUser, Library library, MovieLibrary movieLibrary) {
        this.welcomeMessage = welcomeMessage;
        this.mainMenuFactory = mainMenuFactory;
        this.consoleDisplayFactory = consoleDisplayFactory;
        this.inputReader = inputReader;
        this.parser = parser;
        this.currentUser = currentUser;
        this.library = library;
        this.movieLibrary = movieLibrary;
    }

    public void start() {
        consoleDisplayFactory.getNewConsoleDisplay(welcomeMessage.format()).display();
        interactWithUser();
    }

    private void interactWithUser() {
        do {
            mainMenuFactory.getMenu(currentUser).displayMenuOptions();
            String input = inputReader.read();
            parser = new ParserFactory().getNewParser(library, movieLibrary, currentUser);
            MenuOption menuOption = parser.parse(input);
            menuOption.doOperation();
            if(menuOption.getClass() == LoginMenuOption.class)
                currentUser = ((LoginMenuOption) menuOption).currentUser();
            if(menuOption.getClass() == LogoutMenuOption.class)
                currentUser = ((LogoutMenuOption) menuOption).currentUser();
        } while (true);
    }
}
