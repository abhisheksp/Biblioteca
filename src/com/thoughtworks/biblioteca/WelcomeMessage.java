package com.thoughtworks.biblioteca;

/* WelcomeMesssage takes a WelcomeMessage and returns formatted version of it */
public class WelcomeMessage {
    private String message;

    public WelcomeMessage(String message) {
        this.message = message;
    }

    public String format() {
        return message + "\n";
    }
}
