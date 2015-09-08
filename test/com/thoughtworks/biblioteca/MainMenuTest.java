package com.thoughtworks.biblioteca;

import org.junit.*;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import java.io.*;
import java.util.*;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MainMenuTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

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
        exit.expectSystemExit();
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        String input = "2";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        Scanner scanner = new Scanner(System.in);
        InputReader inputReader = new InputReader(scanner);
        InvalidMenuOption invalidMenuOption = new InvalidMenuOption("Select a valid option!");
        Library library = mock(Library.class);
        Map<String, MenuOption> optionsMap = new HashMap<String, MenuOption>();
        ListBooksMenuOption listBooksMenuOption = new ListBooksMenuOption(library);
        optionsMap.put("1", listBooksMenuOption);
        optionsMap.put("invalid", invalidMenuOption);
        MainMenu mainMenu = new MainMenu(options, inputReader, optionsMap);

        mainMenu.interactWithUser();

        assertEquals("1. List Books\n" + "Select a valid option!\n", outContent.toString());
    }

    @Test
    public void shouldInvokeReadFromInputReaderAfterDisplayingOptions() {
        exit.expectSystemExit();
        String input = "2";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        Scanner scanner = new Scanner(System.in);
        InputReader inputReader = new InputReader(scanner);
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        Library library = mock(Library.class);
        InvalidMenuOption invalidMenuOption = new InvalidMenuOption("Select a valid option!");
        Map<String, MenuOption> optionsMap = new HashMap<String, MenuOption>();
        ListBooksMenuOption listBooksMenuOption = new ListBooksMenuOption(library);
        optionsMap.put("1", listBooksMenuOption);
        optionsMap.put("invalid", invalidMenuOption);
        MainMenu mainMenu = new MainMenu(options, inputReader, optionsMap);


        mainMenu.interactWithUser();

        verify(inputReader).read();
        assertEquals("1. List Books\n" + "Select a valid option!\n", outContent.toString());
    }

    @Test
    public void shouldDisplayInvalidOptionWhenAnInvalidOptionIsChosen() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        String input = "invalid option";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        Scanner scanner = new Scanner(System.in);
        InputReader inputReader = new InputReader(scanner);
        Library library = mock(Library.class);
        InvalidMenuOption invalidMenuOption = new InvalidMenuOption("Select a valid option!");
        Map<String, MenuOption> optionsMap = new HashMap<String, MenuOption>();
        ListBooksMenuOption listBooksMenuOption = new ListBooksMenuOption(library);
        optionsMap.put("1", listBooksMenuOption);
        optionsMap.put("invalid", invalidMenuOption);
        MainMenu mainMenu = new MainMenu(options, inputReader, optionsMap);
        System.setIn(System.in);

        mainMenu.interactWithUser();

        assertEquals("1. List Books\n" + "Select a valid option!\n", outContent.toString());
    }

    @Test
    public void shouldKeepDiplayingOptionsUntilQuitOptionIsChosen() {
        exit.expectSystemExit();

        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        options.add("2. Quit");
        String input = "2";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        Scanner scanner = new Scanner(System.in);
        InputReader inputReader = new InputReader(scanner);
        Library library = mock(Library.class);
        InvalidMenuOption invalidMenuOption = new InvalidMenuOption("Select a valid option!");
        Map<String, MenuOption> optionsMap = new HashMap<String, MenuOption>();
        ListBooksMenuOption listBooksMenuOption = new ListBooksMenuOption(library);
        optionsMap.put("1", listBooksMenuOption);
        optionsMap.put("invalid", invalidMenuOption);
        MainMenu mainMenu = new MainMenu(options, inputReader, optionsMap);
        System.setIn(System.in);

        mainMenu.interactWithUser();
    }

    @Test
    public void shouldDisplayCheckOutOption() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        options.add("2. Quit");
        options.add("3. Checkout Book");
        String input = "*";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        Scanner scanner = new Scanner(System.in);
        InputReader inputReader = new InputReader(scanner);
        Library library = mock(Library.class);
        InvalidMenuOption invalidMenuOption = new InvalidMenuOption("Select a valid option!");
        Map<String, MenuOption> optionsMap = new HashMap<String, MenuOption>();
        ListBooksMenuOption listBooksMenuOption = new ListBooksMenuOption(library);
        optionsMap.put("1", listBooksMenuOption);
        optionsMap.put("invalid", invalidMenuOption);
        MainMenu mainMenu = new MainMenu(options, inputReader, optionsMap);
        System.setIn(System.in);

        mainMenu.interactWithUser();

        assertEquals("1. List Books\n" +
                "2. Quit\n" +
                "3. Checkout Book\n" +
                "Select a valid option!\n", outContent.toString());
    }


    @Test
    public void shouldTakeInputFromUserWhenCheckoutOptionIsChosen() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        options.add("2. Quit");
        options.add("3. Checkout Book");
        String input = "*";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        Scanner scanner = new Scanner(System.in);
        InputReader inputReader = new InputReader(scanner);
        Library library = mock(Library.class);
        InvalidMenuOption invalidMenuOption = new InvalidMenuOption("Select a valid option!");
        Map<String, MenuOption> optionsMap = new HashMap<String, MenuOption>();
        ListBooksMenuOption listBooksMenuOption = new ListBooksMenuOption(library);
        optionsMap.put("1", listBooksMenuOption);
        optionsMap.put("invalid", invalidMenuOption);
        MainMenu mainMenu = new MainMenu(options, inputReader, optionsMap);
        System.setIn(System.in);

        mainMenu.interactWithUser();

        assertEquals("1. List Books\n" +
                "2. Quit\n" +
                "3. Checkout Book\n" +
                "Select a valid option!\n", outContent.toString());
    }
}
