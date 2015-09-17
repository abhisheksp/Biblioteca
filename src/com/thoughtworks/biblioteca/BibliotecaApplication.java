package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class BibliotecaApplication {

    public void run() {
        WelcomeMessage welcomeMessage = new WelcomeMessageFactory().getDefaultWelcomeMessage();
        InputReader inputReader = new InputReaderFactory().getDefaultInputReader();
        Library library = new LibraryFactory().getDefaultLibrary();
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        MovieLibrary movieLibrary = new MovieLibraryFactory().getDefaultMovieLibrary();
        Authenticator authenticator = new Authenticator(getRegisteredUsers(), consoleDisplayFactory);
        User user = new User("", "", "guest", "", "", "");
        MainMenuFactory mainMenuFactory = new MainMenuFactory();
        Parser parser = new Parser(inputReader, library, movieLibrary, consoleDisplayFactory, user,authenticator);
        Controller controller = new Controller(welcomeMessage, mainMenuFactory, consoleDisplayFactory, inputReader, parser, user, library, movieLibrary);
        controller.start();
    }

    private ArrayList<User> getRegisteredUsers() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("666-2222", "blacksheep", "librarian", "Voldemort", "vold@killharry.com", "999999999"));
        users.add(new User("222-2222", "juliusseizure", "user", "Julius Caesar", "julius@caesar.com", "888888888"));
        users.add(new User("888-2222", "murica", "user", "Barack Obama", "obama@us.gov", "555555555"));
        return users;
    }
}
