package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class MainMenu {
    private ArrayList<String> options;

    public MainMenu(ArrayList<String> options) {
        this.options = options;
    }

    public void displayOptions() {
        for (String option : options) {
            System.out.println(option);
        }
    }
}
