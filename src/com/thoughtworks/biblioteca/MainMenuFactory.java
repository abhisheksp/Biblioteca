package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class MainMenuFactory {

    private MainMenu mainMenu;

    public MainMenu getMenu(User user){
        if(user.role().equals("librarian"))
            return librarianMenu();
        else if(user.role().equals("user"))
            return userMenu();
        else
            return guestMenu();
    }

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
            options.add("5. Checkout Movie");
            options.add("6. Logout");
            options.add("7. Quit");
        mainMenu =  new MainMenu(options, new ConsoleDisplayFactory());
        return mainMenu;
    }

    public MainMenu librarianMenu() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        options.add("2. List Movies");
        options.add("3. Checkout Book");
        options.add("4. Checkin Book");
        options.add("5. Checkout Movie");
        options.add("6. Book Status");
        options.add("7. Logout");
        options.add("8. Quit");
        mainMenu =  new MainMenu(options, new ConsoleDisplayFactory());
        return mainMenu;
    }
}
