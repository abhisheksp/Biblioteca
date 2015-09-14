package com.thoughtworks.biblioteca;

/* InvalidMenuOption takes an Invalid Message and displays it via console display */
public class InvalidMenuOption implements MenuOption {

    private String invalidMessage;
    private ConsoleDisplayFactory consoleDisplayFactory;

    public InvalidMenuOption(String invalidMessage, ConsoleDisplayFactory consoleDisplayFactory) {
        this.invalidMessage = invalidMessage;
        this.consoleDisplayFactory = consoleDisplayFactory;
    }

    @Override
    public void doOperation() {
        consoleDisplayFactory.getNewConsoleDisplay(format()).display();
    }

    public String format() {
        return "Select a valid option!\n";
    }
}
