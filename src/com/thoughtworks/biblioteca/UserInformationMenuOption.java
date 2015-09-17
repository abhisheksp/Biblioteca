package com.thoughtworks.biblioteca;

public class UserInformationMenuOption implements MenuOption {

    private ConsoleDisplayFactory consoleDisplayFactory;
    private User currentUser;

    public UserInformationMenuOption(ConsoleDisplayFactory consoleDisplayFactory, User currentUser) {
        this.consoleDisplayFactory = consoleDisplayFactory;
        this.currentUser = currentUser;
    }

    @Override
    public void doOperation() {
        String userInformation = currentUser.format();
        ConsoleDisplay consoleDisplay = consoleDisplayFactory.getNewConsoleDisplay(userInformation);
        consoleDisplay.display();
    }
}
