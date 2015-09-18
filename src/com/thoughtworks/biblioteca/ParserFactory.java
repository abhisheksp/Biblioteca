package com.thoughtworks.biblioteca;

/* ParserFactory manufactures a new Parser with passed dependencies as states */
public class ParserFactory {

    InputReader inputReader;
    ConsoleDisplayFactory consoleDisplayFactory;
    Authenticator authenticator;

    public ParserFactory() {
        this.inputReader = new InputReaderFactory().getDefaultInputReader();
        this.consoleDisplayFactory = new ConsoleDisplayFactory();
        this.authenticator = new AuthenticatorFactory().getDefaultAuthenticator();
    }

    public Parser getNewParser(BookLibrary bookLibrary, MovieLibrary movieLibrary, User currentUser) {
        return new Parser(inputReader, bookLibrary, movieLibrary, consoleDisplayFactory, currentUser, authenticator);
    }
}
