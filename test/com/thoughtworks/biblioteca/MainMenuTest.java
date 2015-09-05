package com.thoughtworks.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

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
    public void shouldDisplayListBooksOptionInitially() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        MainMenu mainMenu = new MainMenu(options);

        mainMenu.displayOptions();

        assertEquals("1. List Books\n", outContent.toString());
    }
}
