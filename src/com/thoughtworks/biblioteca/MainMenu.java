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

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        MainMenu thatMainMenu = (MainMenu) that;
        return options.equals(thatMainMenu.options);

    }

    @Override
    public int hashCode() {
        return options.hashCode();
    }

    public void displayMenuOptions() {
        consoleDisplayFactory.getNewConsoleDisplay(formatOptions()).display();
    }
}
