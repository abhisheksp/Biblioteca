package com.thoughtworks.biblioteca;

public class ListBooksMenuOption implements MenuOption{

    private Library library;
    private InputReader inputReader;

    public ListBooksMenuOption(Library library, InputReader inputReader) {
        this.library = library;
        this.inputReader = inputReader;
    }

    @Override
    public boolean doOperation(){
        inputReader.read();
        return true;
    }
}
