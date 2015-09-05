package com.thoughtworks.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
        InputReader inputReader = mock(InputReader.class);
        MainMenu mainMenu = new MainMenu(options, inputReader);

        mainMenu.interactWithUser();

        assertEquals("1. List Books\n", outContent.toString());
    }

    @Test
    public void shouldInvokeReadFromInputReaderAfterDisplayingOptions() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        InputReader inputReader = mock(InputReader.class);
        MainMenu mainMenu = new MainMenu(options, inputReader);

        mainMenu.interactWithUser();

        verify(inputReader).read();
        assertEquals("1. List Books\n", outContent.toString());
    }
}
