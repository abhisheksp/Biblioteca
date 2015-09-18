package com.thoughtworks.biblioteca;

/* ConsoleDisplayFactory manufactures a console display with passed parameter as initial state */
public class ConsoleDisplayFactory {

    ConsoleDisplay consoleDisplay;

    public ConsoleDisplay getNewConsoleDisplay(String message) {
        consoleDisplay = new ConsoleDisplay(message);
        return consoleDisplay;
    }
}
