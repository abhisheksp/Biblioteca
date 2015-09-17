package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class ParserFactory {

    InputReader inputReader;
    ConsoleDisplayFactory consoleDisplayFactory;
    Authenticator authenticator;

    public ParserFactory() {
        this.inputReader = new InputReaderFactory().getDefaultInputReader();
        this.consoleDisplayFactory = new ConsoleDisplayFactory();
        this.authenticator = new Authenticator(getRegisteredUsers(), consoleDisplayFactory);
    }

    public Parser getNewParser(Library library, MovieLibrary movieLibrary, User currentUser) {
        return new Parser(inputReader, library, movieLibrary, consoleDisplayFactory, currentUser, authenticator);
    }

    private ArrayList<User> getRegisteredUsers() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("666-2222", "blacksheep", "librarian", "Voldemort", "voldemort@killharry.com", "999999999"));
        users.add(new User("222-2222", "juliusseizure", "user", "Julius Caesar", "julius@caesar.com", "888888888"));
        users.add(new User("888-2222", "murica", "user", "Barack Obama", "obama@us.gov", "555555555"));
        return users;
    }
}
