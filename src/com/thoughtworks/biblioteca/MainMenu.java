package com.thoughtworks.biblioteca;

import java.util.ArrayList;
import java.util.Map;

public class MainMenu {

    private ArrayList<String> options;
    private InputReader inputReader;
    private Map<String, MenuOption> optionsMap;

    public MainMenu(ArrayList<String> options, InputReader inputReader, Map<String, MenuOption> optionsMap) {
        this.options = options;
        this.inputReader = inputReader;
        this.optionsMap = optionsMap;
    }

    public void interactWithUser() {
            displayOptions();
            String input = inputReader.read();
            if (input.equals("2"))
                System.exit(1);
            else if (optionsMap.containsKey(input))
                optionsMap.get(input).doOperation();
            else
                optionsMap.get("invalid").doOperation();
    }

    private void displayOptions() {
        for (String option : options) {
            System.out.println(option);
        }
    }
}
