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
        User currentUser = new User("", "", "guest");   
        MainMenuFactory mainMenuFactory = new MainMenuFactory();
        do {
            mainMenuFactory.getMenu(currentUser).displayMenuOptions();
            String input = inputReader.read();
            MenuOption menuOption = parser.parse(input);
            menuOption.doOperation();
        } while (true);
    }
}
