package com.thoughtworks.biblioteca;

/* WelcomeMesssage takes a WelcomeMessage and displays it */
public class WelcomeMessage {
    private String message;

    public WelcomeMessage(String message) {
        this.message = message;
    }

    public void display() {
        System.out.println(message);
    }
}
