package com.thoughtworks.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;

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

        assertEquals("MAIN MENU\n" +
                "---------------------------\n" +
                "1. List Books\n" +
                "2. Quit\n" +
                "3. Checkout Book\n" +
                "4. Checkin Book\n" +
                "5. List Movies\n" +
                "6. Checkout Movie\n" +
                "\n" +
                "---------------------------\n" +
                "Choose an option : \n", outContent.toString());
    }

    @Test
    public void shouldBeEqualToItself() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        options.add("2. Quit");
        options.add("3. Checkout Book");
        options.add("4. Checkin Book");
        options.add("5. List Movies");
        options.add("6. Checkout Movie");
        ConsoleDisplayFactory consoleDisplayFactory = mock(ConsoleDisplayFactory.class);
        MainMenu mainMenu = new MainMenu(options, consoleDisplayFactory);

        assertEquals(mainMenu, mainMenu);
    }

    @Test
    public void shouldBeEqualToAnotherMainMenuWithSameOptions() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        options.add("2. Quit");
        options.add("3. Checkout Book");
        options.add("4. Checkin Book");
        options.add("5. List Movies");
        options.add("6. Checkout Movie");
        ConsoleDisplayFactory consoleDisplayFactory = mock(ConsoleDisplayFactory.class);

        assertEquals(new MainMenu(options, consoleDisplayFactory), new MainMenu(options, consoleDisplayFactory));
    }

    @Test
    public void shouldNotBeEqualToAnotherMainMenuWithDifferentOptions() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        options.add("2. Quit");
        options.add("3. Checkout Book");
        options.add("4. Checkin Book");
        options.add("5. List Movies");
        options.add("6. Checkout Movie");
        ConsoleDisplayFactory consoleDisplayFactory = mock(ConsoleDisplayFactory.class);
        ArrayList<String> options1 = new ArrayList<String>();
        options.add("1. List Books");

        assertNotEquals(new MainMenu(options, consoleDisplayFactory), new MainMenu(options1, consoleDisplayFactory));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        options.add("2. Quit");
        options.add("3. Checkout Book");
        options.add("4. Checkin Book");
        options.add("5. List Movies");
        options.add("6. Checkout Movie");
        ConsoleDisplayFactory consoleDisplayFactory = mock(ConsoleDisplayFactory.class);

        assertNotEquals(new MainMenu(options, consoleDisplayFactory), null);
    }

    @Test
    public void shouldNotBeEqualToNonMainMenuEntity() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        options.add("2. Quit");
        options.add("3. Checkout Book");
        options.add("4. Checkin Book");
        options.add("5. List Movies");
        options.add("6. Checkout Movie");
        ConsoleDisplayFactory consoleDisplayFactory = mock(ConsoleDisplayFactory.class);

        assertNotEquals(new MainMenu(options, consoleDisplayFactory), "Not a MainMenu");
    }

    @Test
    public void shouldHaveSameHashCodeAsAnotherMainMenuWithSameOption() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        options.add("2. Quit");
        options.add("3. Checkout Book");
        options.add("4. Checkin Book");
        options.add("5. List Movies");
        options.add("6. Checkout Movie");
        ConsoleDisplayFactory consoleDisplayFactory = mock(ConsoleDisplayFactory.class);

        assertEquals(new MainMenu(options, consoleDisplayFactory).hashCode(), new MainMenu(options, consoleDisplayFactory).hashCode());
    }
}
