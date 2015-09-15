package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class Authenticator {

    private ArrayList<User> users;

    public Authenticator(ArrayList<User> users) {
        this.users = users;
    }

    public User authenticate(String libraryNumber, String password) {
        int indexOfUser = users.indexOf(new User(libraryNumber, password));
        if(indexOfUser != -1)
            return users.get(indexOfUser);
        return new User("000-0000", "blacksheep");
    }
}
