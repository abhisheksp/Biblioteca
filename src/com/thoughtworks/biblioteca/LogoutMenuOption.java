package com.thoughtworks.biblioteca;

public class LogoutMenuOption implements MenuOption{

    User currentUser;

    @Override
    public void doOperation(){
        this.currentUser = new User("", "", "guest", "", "", "");
    }

    public User currentUser(){
        return this.currentUser;
    }
}
