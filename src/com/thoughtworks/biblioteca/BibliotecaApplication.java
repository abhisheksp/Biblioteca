package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class BibliotecaApplication {

    public void run(){
        WelcomeMessage welcomeMessage = new WelcomeMessageFactory().getDefaultWelcomeMessage();
        InputReader inputReader = new InputReaderFactory().getDefaultInputReader();
        Library library = new LibraryFactory().getDefaultLibrary();
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("Inception", 2010, "Christopher Nolan", "10.0"));
        movies.add(new Movie("Avatar", 2009, "James Cameron", "9.0"));
        movies.add(new Movie("The Ring", 2002, "Gore Verbinski", "unrated"));
        MovieLibrary movieLibrary = new MovieLibrary(movies);
        Parser parser = new Parser(inputReader, library, movieLibrary, consoleDisplayFactory);
        ArrayList<String> options = getOptions();
        MainMenu mainMenu = new MainMenu(options, inputReader, parser);
        Controller controller = new Controller(welcomeMessage, mainMenu, consoleDisplayFactory);
        controller.start();
    }

    private ArrayList<String> getOptions() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        options.add("2. Quit");
        options.add("3. Checkout Book");
        options.add("4. Checkin Book");
        return options;
    }
}
