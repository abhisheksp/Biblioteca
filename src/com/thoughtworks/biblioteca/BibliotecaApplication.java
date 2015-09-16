package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class BibliotecaApplication {

    public void run() {
        WelcomeMessage welcomeMessage = new WelcomeMessageFactory().getDefaultWelcomeMessage();
        InputReader inputReader = new InputReaderFactory().getDefaultInputReader();
        Library library = new LibraryFactory().getDefaultLibrary();
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        MovieLibrary movieLibrary = new MovieLibraryFactory().getDefaultMovieLibrary();
        Authenticator authenticator = new Authenticator(getRegisteredUsers());
        User user = new User("", "", "guest");
        Parser parser = new Parser(inputReader, library, movieLibrary, consoleDisplayFactory, user,authenticator);
        ArrayList<String> options = getOptions();
        MainMenu mainMenu = new MainMenu(options, consoleDisplayFactory);
        Controller controller = new Controller(welcomeMessage, mainMenu, consoleDisplayFactory, inputReader, parser);
        controller.start();
    }

    private ArrayList<String> getOptions() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        options.add("2. Quit");
        options.add("3. Checkout Book");
        options.add("4. Checkin Book");
        options.add("5. List Movies");
        options.add("6. Checkout Movie");
        return options;
    }

    private ArrayList<User> getRegisteredUsers() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("222-2222", "juliusseizure", "user"));
        users.add(new User("444-2222", "randomstuff", "user"));
        users.add(new User("888-2222", "morerandomstuff", "user"));
        return users;
    }
}
