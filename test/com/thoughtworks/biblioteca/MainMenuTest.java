package com.thoughtworks.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MainMenuTest {

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
    public void shouldDisplayMenuOptionsWhenDisplayOptionsIsCalled() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        options.add("2. Quit");
        options.add("3. Checkout Book");
        options.add("4. Checkin Book");
        options.add("5. List Movies");
        options.add("6. Checkout Movie");
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        MainMenu mainMenu = new MainMenu(options, consoleDisplayFactory);

        mainMenu.displayMenuOptions();

        assertEquals("1. List Books\n" +
                "2. Quit\n" +
                "3. Checkout Book\n" +
                "4. Checkin Book\n" +
                "5. List Movies\n" +
                "6. Checkout Movie\n" +
                "\n", outContent.toString());
    }
}
