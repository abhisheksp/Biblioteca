package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MainMenuFactoryTest {

    @Test
    public void shouldReturnGuestMenuWhenGuestMenuIsCalled(){
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        options.add("2. List Movies");
        options.add("3. Checkout Movie");
        options.add("4. Login");
        options.add("5. Quit");
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        MainMenu mainMenu = new MainMenu(options, consoleDisplayFactory);
        MainMenuFactory mainMenuFactory = new MainMenuFactory();

        assertEquals(mainMenu, mainMenuFactory.guestMenu());
    }

    @Test
    public void shouldReturnUserMenuWhenUserMenuIsCalled(){
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        options.add("2. List Movies");
        options.add("3. Checkout Book");
        options.add("4. Checkin Book");
        options.add("3. Checkout Movie");
        options.add("4. Logout");
        options.add("6. Quit");
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        MainMenu mainMenu = new MainMenu(options, consoleDisplayFactory);
        MainMenuFactory mainMenuFactory = new MainMenuFactory();

        assertEquals(mainMenu, mainMenuFactory.userMenu());
    }
}
