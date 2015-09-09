package com.thoughtworks.biblioteca;

public class CheckoutBookMenuOption implements MenuOption {

    private InputReader inputReader;
    private Library library;

    public CheckoutBookMenuOption(InputReader inputReader, Library library) {
        this.inputReader = inputReader;
        this.library = library;
    }

    @Override
    public void doOperation() {
        String bookName = inputReader.read();
        library.checkOutBook(new Book(bookName));
    }
}
