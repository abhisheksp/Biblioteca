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
        currentUser.format();
    }
}
