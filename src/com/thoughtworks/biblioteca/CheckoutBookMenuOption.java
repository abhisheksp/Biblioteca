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
        if (library.checkOut(new Book(bookName))) {
            System.out.println("Thank you! Enjoy the book");
        } else {
            System.out.println("That book is not available.");
        }
    }
}
