package com.thoughtworks.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ConsoleDisplayTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setupStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(System.out);
    }

    @Test
    public void shouldDisplayWelcomeMessageWhenWelcomeStringIsPassed() {
        ConsoleDisplay consoleDisplay = new ConsoleDisplay("Welcome\n");

        consoleDisplay.display();

        assertEquals("Welcome\n", outContent.toString());
    }

    @Test
    public void shouldPrintListOfBooksWhenListOfBooksIsPassed() {
        ArrayList<String> bookList = new ArrayList<String>();
        bookList.add("Brief History of Time");
        bookList.add("Crime and Punishment");
        bookList.add("Seven Minutes");
        ConsoleDisplay consoleDisplay = new ConsoleDisplay("Welcome\n");

        consoleDisplay.display();
        consoleDisplay.displayList(bookList);

        assertEquals("Welcome\n" + bookList.toString(), outContent.toString());
    }
}
