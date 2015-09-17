package com.thoughtworks.biblioteca;

public class BibliotecaApplication {

    public void run() {
        WelcomeMessage welcomeMessage = new WelcomeMessageFactory().getDefaultWelcomeMessage();
        InputReader inputReader = new InputReaderFactory().getDefaultInputReader();
        Library library = new LibraryFactory().getDefaultLibrary();
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        MovieLibrary movieLibrary = new MovieLibraryFactory().getDefaultMovieLibrary();
        User user = new User("", "", "guest", "", "", "");
        MainMenuFactory mainMenuFactory = new MainMenuFactory();
        Parser parser = new ParserFactory().getNewParser(library, movieLibrary, user);
        Controller controller = new Controller(welcomeMessage, mainMenuFactory, consoleDisplayFactory, inputReader, parser, user, library, movieLibrary);
        controller.start();
    }
}
