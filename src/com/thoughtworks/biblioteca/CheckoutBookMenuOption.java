package com.thoughtworks.biblioteca;

/* CheckOut Book Menu Option does required delegations to perform book checkout */
public class CheckOutBookMenuOption implements MenuOption {

    private InputReader inputReader;
    private BookLibrary bookLibrary;
    private User currentUser;
    private ConsoleDisplayFactory consoleDisplayFactory;

    public CheckOutBookMenuOption(InputReader inputReader, BookLibrary bookLibrary, User currentUser, ConsoleDisplayFactory consoleDisplayFactory) {
        this.inputReader = inputReader;
        this.bookLibrary = bookLibrary;
        this.currentUser = currentUser;
        this.consoleDisplayFactory = consoleDisplayFactory;
    }

    @Override
    public void doOperation() {
        consoleDisplayFactory.getNewConsoleDisplay("Enter Book Name : ").display();
        String bookName = inputReader.read();
        if (bookLibrary.checkOut(new Book(bookName), currentUser)) {
            consoleDisplayFactory.getNewConsoleDisplay("Thank you! Enjoy the book").display();
        } else {
            consoleDisplayFactory.getNewConsoleDisplay("That book is not available.").display();
        }
    }
}
