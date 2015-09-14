package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class BibliotecaApplication {

    public void run(){
        WelcomeMessage welcomeMessage = new WelcomeMessageFactory().getDefaultWelcomeMessage();
        InputReader inputReader = new InputReaderFactory().getDefaultInputReader();
        Library library = new LibraryFactory().getDefaultLibrary();
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        Parser parser = new Parser(inputReader, library, consoleDisplayFactory);
        ArrayList<String> options = getOptions();
        MainMenu mainMenu = new MainMenu(options, inputReader, parser);
        Controller controller = new Controller(welcomeMessage, mainMenu);
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
