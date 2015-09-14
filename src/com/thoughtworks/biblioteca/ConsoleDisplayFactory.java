package com.thoughtworks.biblioteca;

public class ConsoleDisplayFactory {

    ConsoleDisplay consoleDisplay;

    public ConsoleDisplay getNewConsoleDisplay(String message) {
        consoleDisplay = new ConsoleDisplay(message);
        return consoleDisplay;
    }
}
