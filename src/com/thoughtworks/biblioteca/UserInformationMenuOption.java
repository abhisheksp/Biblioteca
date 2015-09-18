package com.thoughtworks.biblioteca;

/* UserInformationMenuOption has required dependencies which it delegates to display user information */
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
        String columnHeaders = String.format("%-20s%-20s%-30s%-20s\n", "BookLibrary Number", "Number", "Email ID", "Phone Number")
                + "-----------------------------------------------------------------------------------\n";
        ConsoleDisplay consoleDisplay = consoleDisplayFactory.getNewConsoleDisplay(columnHeaders + userInformation);
        consoleDisplay.display();
    }
}
