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

    public void login() {
        new ConsoleDisplayFactory().getNewConsoleDisplay("Library Id :").display();
        inputReader.read();
        new ConsoleDisplayFactory().getNewConsoleDisplay("Password :").display();
        inputReader.read();
    }
}
