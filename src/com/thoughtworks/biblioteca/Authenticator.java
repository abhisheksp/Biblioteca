package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class Authenticator {

    private ArrayList<User> users;

    public Authenticator(ArrayList<User> users) {
        this.users = users;
    }

    public User authenticate(String libraryNumber, String password) {
        return new User(libraryNumber, password);
    }
}
