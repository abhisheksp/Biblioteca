package com.thoughtworks.biblioteca;

/* InvalidMenuOption takes an Invalid Message and displays it */
public class InvalidMenuOption implements MenuOption {

    private String invalidMessage;

    public InvalidMenuOption(String invalidMessage) {
        this.invalidMessage = invalidMessage;
    }

    public void display() {
        System.out.println("Select a valid option!");
    }
}
