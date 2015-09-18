package com.thoughtworks.biblioteca;

/* Logout Menu Option destroys the current login session by reseeting current user to guest */
public class LogoutMenuOption implements MenuOption{

    private User currentUser;

    @Override
    public void doOperation(){
        this.currentUser = new User("", "", "guest", "", "", "");
    }

    public User currentUser(){
        return this.currentUser;
    }
}
