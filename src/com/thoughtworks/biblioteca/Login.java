package com.thoughtworks.biblioteca;

public class Login {

    private Authenticator authenticator;
    private InputReader inputReader;
    private ConsoleDisplayFactory consoleDisplayFactory;

    public Login(Authenticator authenticator, InputReader inputReader, ConsoleDisplayFactory consoleDisplayFactory) {
        this.authenticator = authenticator;
        this.inputReader = inputReader;
        this.consoleDisplayFactory = consoleDisplayFactory;
    }

    public Session login() {
        consoleDisplayFactory.getNewConsoleDisplay("Library Number :").display();
        String libraryNumber = inputReader.read();
        consoleDisplayFactory.getNewConsoleDisplay("Password :").display();
        String password = inputReader.read();
        User user = authenticator.authenticate(libraryNumber, password);
        return new SessionFactory().getNewSession(user);
    }
}
