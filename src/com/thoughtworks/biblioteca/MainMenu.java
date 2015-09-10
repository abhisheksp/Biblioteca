package com.thoughtworks.biblioteca;

import java.util.ArrayList;

/* MainMenu displays menu options, gets MenuOption via InputReader and Parser */
public class MainMenu {

    private ArrayList<String> options;
    private InputReader inputReader;
    private Parser parser;

    public MainMenu(ArrayList<String> options, InputReader inputReader, Parser parser) {
        this.options = options;
        this.inputReader = inputReader;
        this.parser = parser;
    }

    public void interactWithUser() {
        do {
            displayMenuOptions();
            String input = inputReader.read();
            MenuOption menuOption = parser.parse(input);
            menuOption.doOperation();
        }while(true);
    }

    private void displayMenuOptions() {
        for (String option : options) {
            System.out.println(option);
        }
    }
}
