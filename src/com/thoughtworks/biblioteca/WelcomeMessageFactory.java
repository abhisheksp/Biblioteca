package com.thoughtworks.biblioteca;

public class WelcomeMessageFactory {

    private String welcomeMessage;

    public WelcomeMessageFactory() {
        this.welcomeMessage = "Sup?";
    }

    public WelcomeMessage getDefaultWelcomeMessage() {
        return new WelcomeMessage(welcomeMessage);
    }
}
