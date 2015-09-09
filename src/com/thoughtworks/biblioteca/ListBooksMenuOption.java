package com.thoughtworks.biblioteca;

public class ListBooksMenuOption implements MenuOption{

    private Library library;

    public ListBooksMenuOption(Library library) {
        this.library = library;
    }

    @Override
    public void doOperation(){
        library.display();
    }
}
