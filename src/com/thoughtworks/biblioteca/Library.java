package com.thoughtworks.biblioteca;

import java.util.ArrayList;

/* Library has a list of books and can display,checkout them */
public class Library {

    ArrayList<Book> availableBooks = new ArrayList<Book>();
    ArrayList<Book> checkedOutBooks = new ArrayList<Book>();

    public Library(ArrayList<Book> availableBooks) {
        this.availableBooks = availableBooks;
    }

    public void display() {
        String columnHeader = "Book" + "\t" + "Author" + "\t" + "Year Published" + "\n";
        System.out.print(columnHeader);
        for (Book book : availableBooks) {
            System.out.println(book);
        }
    }

    public void checkOutBook(Book book) {
        if (availableBooks.contains(book)) {
            int bookIndex = availableBooks.indexOf(book);
            checkedOutBooks.add(availableBooks.get(bookIndex));
            availableBooks.remove(book);
            System.out.println("Thank you! Enjoy the book");
        }
        else {
            System.out.println("That book is not available.");
        }
    }

    public void checkIn(Book book) {
        if(checkedOutBooks.contains(book)) {
            int bookIndex = checkedOutBooks.indexOf(book);
            availableBooks.add(checkedOutBooks.get(bookIndex));
            System.out.println("Thank you for returning the book.");
        }else{
            System.out.println("That is not a valid book to return.");
        }
    }
}
