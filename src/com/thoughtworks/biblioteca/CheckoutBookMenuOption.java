package com.thoughtworks.biblioteca;

public class CheckoutBookMenuOption implements MenuOption {

    private InputReader inputReader;

    public CheckoutBookMenuOption(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    @Override
    public boolean doOperation() {
        inputReader.read();
        return true;
    }
}
