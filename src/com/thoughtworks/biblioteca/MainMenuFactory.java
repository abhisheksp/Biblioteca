package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class MainMenuFactory {

    private MainMenu mainMenu;

    public MainMenu guestMenu(){
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        options.add("2. List Movies");
        options.add("3. Checkout Movie");
        options.add("4. Login");
        options.add("5. Quit");
        mainMenu =  new MainMenu(options, new ConsoleDisplayFactory());
        return mainMenu;
    }

    public MainMenu userMenu() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        options.add("2. List Movies");
        options.add("3. Checkout Book");
        options.add("4. Checkin Book");
        options.add("3. Checkout Movie");
        options.add("4. Logout");
        options.add("6. Quit");
        mainMenu =  new MainMenu(options, new ConsoleDisplayFactory());
        return mainMenu;
    }
}
