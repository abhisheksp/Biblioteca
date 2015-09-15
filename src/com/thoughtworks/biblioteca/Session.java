package com.thoughtworks.biblioteca;

public class Session {

    private User currentUser;

    public Session(User currentUser) {
        this.currentUser = currentUser;
    }

    public User currentUser() {
        return currentUser;
    }
}
