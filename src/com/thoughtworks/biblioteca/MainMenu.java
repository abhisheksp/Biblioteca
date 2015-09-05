package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class MainMenu {

    private ArrayList<String> options;
    private InputReader inputReader;

    public MainMenu(ArrayList<String> options, InputReader inputReader) {
        this.options = options;
        this.inputReader = inputReader;
    }

    public void interactWithUser() {
        inputReader.read();
        displayOptions();
    }

    private void displayOptions() {
        for (String option : options) {
            System.out.println(option);
        }
    }
}
