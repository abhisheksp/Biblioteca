package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class Authenticator {

    private String UNDEFINED_ROLE = "";
    private ArrayList<User> users;
    private ConsoleDisplayFactory consoleDisplayFactory;

    public Authenticator(ArrayList<User> users, ConsoleDisplayFactory consoleDisplayFactory) {
        this.users = users;
        this.consoleDisplayFactory = consoleDisplayFactory;
    }

    public User authenticate(String libraryNumber, String password) {
        int indexOfUser = users.indexOf(new User(libraryNumber, password, UNDEFINED_ROLE, "", "", ""));
        if(indexOfUser != -1)
            return users.get(indexOfUser);
        consoleDisplayFactory.getNewConsoleDisplay("Invalid Login credentials!").display();
        return new User("", "", "guest", "", "", "");
    }
}
