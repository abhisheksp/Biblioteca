package com.thoughtworks.biblioteca;

public class ParserFactory {

    InputReader inputReader;
    ConsoleDisplayFactory consoleDisplayFactory;
    Authenticator authenticator;

    public ParserFactory() {
        this.inputReader = new InputReaderFactory().getDefaultInputReader();
        this.consoleDisplayFactory = new ConsoleDisplayFactory();
        this.authenticator = new AuthenticatorFactory().getDefaultAuthenticator();
    }

    public Parser getNewParser(Library library, MovieLibrary movieLibrary, User currentUser) {
        return new Parser(inputReader, library, movieLibrary, consoleDisplayFactory, currentUser, authenticator);
    }
}
