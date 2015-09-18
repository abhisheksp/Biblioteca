package com.thoughtworks.biblioteca;

/* WelcomeMessage factory manufactures a default WelcomeMessageInstance and returns it */
public class WelcomeMessageFactory {

    private String welcomeMessage;

    public WelcomeMessageFactory() {
        this.welcomeMessage = "Sup?";
    }

    public WelcomeMessage getDefaultWelcomeMessage() {
        return new WelcomeMessage(welcomeMessage);
    }
}
