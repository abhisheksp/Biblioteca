package com.thoughtworks.biblioteca;

public class Biblioteca {
    WelcomeMessage welcomeMessage;
    BookList bookList;

    public Biblioteca(WelcomeMessage welcomeMessage, BookList bookList) {
        this.welcomeMessage = welcomeMessage;
        this.bookList = bookList;
    }

    public void startApplication(){
        welcomeMessage.display();
        bookList.display();
    }
}
