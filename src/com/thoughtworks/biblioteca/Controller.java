package com.thoughtworks.biblioteca;

public class Controller {
    WelcomeMessage welcomeMessage;
    MainMenu mainMenu;

    public Controller(WelcomeMessage welcomeMessage, MainMenu mainMenu) {
        this.welcomeMessage = welcomeMessage;
        this.mainMenu = mainMenu;
    }

    public void start() {
        welcomeMessage.display();
        mainMenu.interactWithUser();
    }
}
