package com.thoughtworks.biblioteca;

public class QuitMenuOption implements MenuOption{

    @Override
    public boolean doOperation(){
        System.exit(0);
        return true;
    }
}
