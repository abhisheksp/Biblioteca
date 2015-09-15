package com.thoughtworks.biblioteca;

import java.util.ArrayList;

/* MainMenu takes menu options and displays them via console display */
public class MainMenu {

    private ArrayList<String> options;
    private ConsoleDisplayFactory consoleDisplayFactory;

    public MainMenu(ArrayList<String> options, ConsoleDisplayFactory consoleDisplayFactory) {
        this.options = options;
        this.consoleDisplayFactory = consoleDisplayFactory;
    }

    private String formatOptions(){
        StringBuilder stringBuilder = new StringBuilder();
        for (String option : options) {
            stringBuilder.append(option + "\n");
        }
        return stringBuilder.toString();
    }

    public void displayMenuOptions() {
        consoleDisplayFactory.getNewConsoleDisplay(formatOptions()).display();
    }
}
