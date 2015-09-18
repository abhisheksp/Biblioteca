package com.thoughtworks.biblioteca;

/* QuitMenuOption terminates the application */
public class QuitMenuOption implements MenuOption{

    @Override
    public void doOperation(){
        System.exit(0);
    }
}
