package com.thoughtworks.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BibliotecaApplication {

    WelcomeMessage welcomeMessage;
    BookList bookList;
    MainMenu mainMenu;

    public BibliotecaApplication() {
        welcomeMessage = new WelcomeMessage("Sup?");
        bookList = new BookList(bookList());
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        Scanner scanner = new Scanner(System.in);
        InputReader inputReader = new InputReader(scanner);
        InvalidMenuOption invalidMenuOption = new InvalidMenuOption("Select a valid option!");
        Map<String, MenuOption> optionsMap = new HashMap<String, MenuOption>();
        optionsMap.put("1", bookList);
        optionsMap.put("invalid", invalidMenuOption);
        mainMenu = new MainMenu(options, inputReader, optionsMap);
    }

    public ArrayList<Book> bookList() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Brief History of Time", "Stephen Hawking", 1988));
        books.add(new Book("Crime and Punishment", "Fyodor Dostoyevsky", 1866));
        books.add(new Book("Seven Minutes", "Irving Wallace", 1969));
        return books;
    }

    public void start() {
        welcomeMessage.display();
        mainMenu.interactWithUser();
    }
}
