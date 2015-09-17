package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MainMenuFactoryTest {

    @Test
    public void shouldReturnGuestMenuWhenGuestMenuIsCalled() {
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
    public void shouldReturnUserMenuWhenUserMenuIsCalled() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        options.add("2. List Movies");
        options.add("3. Checkout Book");
        options.add("4. Checkin Book");
        options.add("5. Checkout Movie");
        options.add("6. User Information");
        options.add("7. Logout");
        options.add("8. Quit");
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        MainMenu mainMenu = new MainMenu(options, consoleDisplayFactory);
        MainMenuFactory mainMenuFactory = new MainMenuFactory();

        assertEquals(mainMenu, mainMenuFactory.userMenu());
    }

    @Test
    public void shouldReturnLibrarianMenuWhenLibrarianMenuIsCalled() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        options.add("2. List Movies");
        options.add("3. Checkout Book");
        options.add("4. Checkin Book");
        options.add("5. Checkout Movie");
        options.add("6. Book Status");
        options.add("7. User Information");
        options.add("8. Logout");
        options.add("9. Quit");
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        MainMenu mainMenu = new MainMenu(options, consoleDisplayFactory);
        MainMenuFactory mainMenuFactory = new MainMenuFactory();

        assertEquals(mainMenu, mainMenuFactory.librarianMenu());
    }

    @Test
    public void shouldReturnGuestMenuWhenGuestUserIsPassed() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        options.add("2. List Movies");
        options.add("3. Checkout Movie");
        options.add("4. Login");
        options.add("5. Quit");
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        MainMenu mainMenu = new MainMenu(options, consoleDisplayFactory);
        MainMenuFactory mainMenuFactory = new MainMenuFactory();

        assertEquals(mainMenu, mainMenuFactory.getMenu(new User("", "", "guest", "", "", "")));
    }

    @Test
    public void shouldReturnUserMenuWhenAuthenticatedUserIsPassed() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        options.add("2. List Movies");
        options.add("3. Checkout Book");
        options.add("4. Checkin Book");
        options.add("5. Checkout Movie");
        options.add("6. User Information");
        options.add("7. Logout");
        options.add("8. Quit");
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        MainMenu mainMenu = new MainMenu(options, consoleDisplayFactory);
        MainMenuFactory mainMenuFactory = new MainMenuFactory();

        assertEquals(mainMenu, mainMenuFactory.getMenu(new User("222-2222", "juliusseizure", "user", "", "", "")));
    }

    @Test
    public void shouldReturnLibrarianMenuWhenLibrarianUserIsPassed() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        options.add("2. List Movies");
        options.add("3. Checkout Book");
        options.add("4. Checkin Book");
        options.add("5. Checkout Movie");
        options.add("6. Book Status");
        options.add("7. User Information");
        options.add("8. Logout");
        options.add("9. Quit");
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        MainMenu mainMenu = new MainMenu(options, consoleDisplayFactory);
        MainMenuFactory mainMenuFactory = new MainMenuFactory();

        assertEquals(mainMenu, mainMenuFactory.getMenu(new User("222-2222", "juliusseizure", "librarian", "", "", "")));
    }
}
