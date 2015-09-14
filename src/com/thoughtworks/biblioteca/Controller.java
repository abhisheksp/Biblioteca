package com.thoughtworks.biblioteca;

public class Controller {
    WelcomeMessage welcomeMessage;
    MainMenu mainMenu;
    ConsoleDisplayFactory consoleDisplayFactory;

    public Controller(WelcomeMessage welcomeMessage, MainMenu mainMenu, ConsoleDisplayFactory consoleDisplayFactory) {
        this.welcomeMessage = welcomeMessage;
        this.mainMenu = mainMenu;
        this.consoleDisplayFactory = consoleDisplayFactory;
    }

    public void start() {
        consoleDisplayFactory.getNewConsoleDisplay(welcomeMessage.format()).display();
        mainMenu.interactWithUser();
    }
}
