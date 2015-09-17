package com.thoughtworks.biblioteca;

/* LoginMenuOption has authenticator, input reader, console display via which it prompts and authenticates user */
public class LoginMenuOption implements MenuOption {

    private Authenticator authenticator;
    private InputReader inputReader;
    private ConsoleDisplayFactory consoleDisplayFactory;
    private User currentUser;

    public LoginMenuOption(Authenticator authenticator, InputReader inputReader, ConsoleDisplayFactory consoleDisplayFactory, User currentUser) {
        this.authenticator = authenticator;
        this.inputReader = inputReader;
        this.consoleDisplayFactory = consoleDisplayFactory;
        this.currentUser = currentUser;
    }

    @Override
    public void doOperation() {
        consoleDisplayFactory.getNewConsoleDisplay("Enter Login Credentials").display();
        consoleDisplayFactory.getNewConsoleDisplay("---------------------------").display();
        consoleDisplayFactory.getNewConsoleDisplay("Library Number :").display();
        String libraryNumber = inputReader.read();
        consoleDisplayFactory.getNewConsoleDisplay("Password :").display();
        String password = inputReader.read();
        currentUser = authenticator.authenticate(libraryNumber, password);
    }

    public User currentUser() {
        return currentUser;
    }
}
