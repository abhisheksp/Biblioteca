package com.thoughtworks.biblioteca;

public class QuitMenuOption implements MenuOption{

    @Override
    public void doOperation(){
        System.exit(0);
    }
}
