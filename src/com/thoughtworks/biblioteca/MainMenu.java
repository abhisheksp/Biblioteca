package com.thoughtworks.biblioteca;

import java.util.ArrayList;
import java.util.Map;

public class MainMenu {

    private ArrayList<String> options;
    private InputReader inputReader;
    private Map<String, Option> optionsMap;

    public MainMenu(ArrayList<String> options, InputReader inputReader, Map<String, Option> optionsMap) {
        this.options = options;
        this.inputReader = inputReader;
        this.optionsMap = optionsMap;
    }

    public void interactWithUser() {
        displayOptions();
        String input = inputReader.read();
        if (optionsMap.containsKey(input))
            optionsMap.get(input).display();
        else
            optionsMap.get("invalid").display();
    }

    private void displayOptions() {
        for (String option : options) {
            System.out.println(option);
        }
    }
}
