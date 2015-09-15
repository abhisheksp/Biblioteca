package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class BibliotecaApplication {

    public void run(){
        WelcomeMessage welcomeMessage = new WelcomeMessageFactory().getDefaultWelcomeMessage();
        InputReader inputReader = new InputReaderFactory().getDefaultInputReader();
        Library library = new LibraryFactory().getDefaultLibrary();
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        MovieLibrary movieLibrary = new MovieLibraryFactory().getDefaultMovieLibrary();
        Parser parser = new Parser(inputReader, library, movieLibrary, consoleDisplayFactory);
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
}
