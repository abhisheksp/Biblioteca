package com.thoughtworks.biblioteca;

public class Controller {

    WelcomeMessage welcomeMessage;
    MainMenu mainMenu;
    ConsoleDisplayFactory consoleDisplayFactory;
    InputReader inputReader;
    Parser parser;

    public Controller(WelcomeMessage welcomeMessage, MainMenu mainMenu, ConsoleDisplayFactory consoleDisplayFactory, InputReader inputReader, Parser parser) {
        this.welcomeMessage = welcomeMessage;
        this.mainMenu = mainMenu;
        this.consoleDisplayFactory = consoleDisplayFactory;
        this.inputReader = inputReader;
        this.parser = parser;
    }

    public void start() {
        consoleDisplayFactory.getNewConsoleDisplay(welcomeMessage.format()).display();
        interactWithUser();
    }

    public void interactWithUser() {
        do {
            mainMenu.displayMenuOptions();
            String input = inputReader.read();
            MenuOption menuOption = parser.parse(input);
            menuOption.doOperation();
        } while (true);
    }
}
