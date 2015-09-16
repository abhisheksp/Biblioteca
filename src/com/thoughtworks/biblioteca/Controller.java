package com.thoughtworks.biblioteca;

import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class Controller {

    WelcomeMessage welcomeMessage;
    MainMenu mainMenu;
    ConsoleDisplayFactory consoleDisplayFactory;
    InputReader inputReader;
    Parser parser;
    User currentUser;

    public Controller(WelcomeMessage welcomeMessage, MainMenu mainMenu, ConsoleDisplayFactory consoleDisplayFactory, InputReader inputReader, Parser parser, User currentUser) {
        this.welcomeMessage = welcomeMessage;
        this.mainMenu = mainMenu;
        this.consoleDisplayFactory = consoleDisplayFactory;
        this.inputReader = inputReader;
        this.parser = parser;
        this.currentUser = currentUser;
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
            MenuOption menuOption = parser.parse(input);
            menuOption.doOperation();
            if(menuOption.getClass() == LoginMenuOption.class)
                currentUser = ((LoginMenuOption) menuOption).currentUser();
        } while (true);
    }
}
