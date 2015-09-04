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
    public void shouldDisplayBookListWithAuthorAndYearPublished() {
        ArrayList<String> bookList = new ArrayList<String>();
        String columnHeader = "Book"+"\t"+"Author"+"\t"+"Year Published";
        bookList.add("Brief History of Time"+"\t"+"Stephen Hawking"+"\t"+"1988");
        bookList.add("Crime and Punishment"+"\t"+"Fyodor Dostoyevsky"+"\t"+"1866");
        bookList.add("Seven Minutes" + "\t" + "Irving Wallace" + "\t" + "1969");
        ConsoleDisplay consoleDisplay = new ConsoleDisplay("Welcome\n");

        consoleDisplay.display();
        consoleDisplay.displayBookList(columnHeader, bookList);

        assertEquals("Welcome\n" +columnHeader+"\n"+bookList.toString(), outContent.toString());
    }
}
