package com.thoughtworks.biblioteca;

/* Biblioteca Application provides the start point of the Application and delegates control to controller */
public class BibliotecaApplication {

    public void run() {
        WelcomeMessage welcomeMessage = new WelcomeMessageFactory().getDefaultWelcomeMessage();
        InputReader inputReader = new InputReaderFactory().getDefaultInputReader();
        BookLibrary bookLibrary = new LibraryFactory().getDefaultLibrary();
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        MovieLibrary movieLibrary = new MovieLibraryFactory().getDefaultMovieLibrary();
        User user = new User("", "", "guest", "", "", "");
        MainMenuFactory mainMenuFactory = new MainMenuFactory();
        Parser parser = new ParserFactory().getNewParser(bookLibrary, movieLibrary, user);
        Controller controller = new Controller(welcomeMessage, mainMenuFactory, consoleDisplayFactory, inputReader, parser, user, bookLibrary, movieLibrary);
        controller.start();
    }
}
