package com.thoughtworks.biblioteca;

import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class Controller {

    WelcomeMessage welcomeMessage;
    MainMenu mainMenu;
    ConsoleDisplayFactory consoleDisplayFactory;
    InputReader inputReader;
    Parser parser;
    User currentUser;
    Library library;
    MovieLibrary movieLibrary;

    public Controller(WelcomeMessage welcomeMessage, MainMenu mainMenu, ConsoleDisplayFactory consoleDisplayFactory, InputReader inputReader, Parser parser, User currentUser, Library library, MovieLibrary movieLibrary) {
        this.welcomeMessage = welcomeMessage;
        this.mainMenu = mainMenu;
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

    public void interactWithUser() {
        MainMenuFactory mainMenuFactory = new MainMenuFactory();
        do {
            mainMenuFactory.getMenu(currentUser).displayMenuOptions();
            String input = inputReader.read();
            parser = new ParserFactory().getNewParser(library, movieLibrary, currentUser);
            MenuOption menuOption = parser.parse(input);
            menuOption.doOperation();
            if(menuOption.getClass() == LoginMenuOption.class)
                currentUser = ((LoginMenuOption) menuOption).currentUser();
            if(menuOption.getClass() == LogoutMenuOption.class)
                currentUser = new User("", "", "guest");

        } while (true);
    }
}
