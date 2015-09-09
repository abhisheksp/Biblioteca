package com.thoughtworks.biblioteca;

import org.junit.*;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import java.io.*;
import java.util.*;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
    public void shouldInvokeReadFromInputReaderAfterDisplayingOptions() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        InputReader inputReader = mock(InputReader.class);
        Library library = mock(Library.class);
        Map<String, MenuOption> optionsMap = new HashMap<String, MenuOption>();
        ListBooksMenuOption listBooksMenuOption = mock(ListBooksMenuOption.class);
        InvalidMenuOption invalidMenuOption = mock(InvalidMenuOption.class);
        optionsMap.put("1", listBooksMenuOption);
        optionsMap.put("invalid", invalidMenuOption);
        MainMenu mainMenu = new MainMenu(options, inputReader, optionsMap);

        when(inputReader.read()).thenReturn("*");
        mainMenu.interactWithUser();

        verify(inputReader).read();
    }

    @Test
    public void shouldInvokeListBooksMenuOptionDoOperationWhenListBooksOptionIsChosen() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        InputReader inputReader = mock(InputReader.class);
        Library library = mock(Library.class);
        Map<String, MenuOption> optionsMap = new HashMap<String, MenuOption>();
        ListBooksMenuOption listBooksMenuOption = mock(ListBooksMenuOption.class);
        InvalidMenuOption invalidMenuOption = mock(InvalidMenuOption.class);
        optionsMap.put("1", listBooksMenuOption);
        optionsMap.put("invalid", invalidMenuOption);
        MainMenu mainMenu = new MainMenu(options, inputReader, optionsMap);

        when(inputReader.read()).thenReturn("1");
        mainMenu.interactWithUser();

        verify(listBooksMenuOption).doOperation();
    }

    @Test
    public void shouldInvokeDoOperationOnInvalidMenuOperationWhenAnInvalidOptionIsChosen() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        InputReader inputReader = mock(InputReader.class);
        Library library = mock(Library.class);
        Map<String, MenuOption> optionsMap = new HashMap<String, MenuOption>();
        ListBooksMenuOption listBooksMenuOption = mock(ListBooksMenuOption.class);
        InvalidMenuOption invalidMenuOption = mock(InvalidMenuOption.class);
        optionsMap.put("1", listBooksMenuOption);
        optionsMap.put("invalid", invalidMenuOption);
        MainMenu mainMenu = new MainMenu(options, inputReader, optionsMap);

        when(inputReader.read()).thenReturn("*");
        mainMenu.interactWithUser();

        verify(invalidMenuOption).doOperation();
    }

    @Test
    public void shouldDisplayCheckOutOption() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        options.add("2. Quit");
        options.add("3. Checkout Book");
        InputReader inputReader = mock(InputReader.class);
        Library library = mock(Library.class);
        Map<String, MenuOption> optionsMap = new HashMap<String, MenuOption>();
        ListBooksMenuOption listBooksMenuOption = mock(ListBooksMenuOption.class);
        InvalidMenuOption invalidMenuOption = mock(InvalidMenuOption.class);
        optionsMap.put("1", listBooksMenuOption);
        optionsMap.put("invalid", invalidMenuOption);
        MainMenu mainMenu = new MainMenu(options, inputReader, optionsMap);

        when(inputReader.read()).thenReturn("*");
        mainMenu.interactWithUser();

        assertEquals("1. List Books\n" +
                "2. Quit\n" +
                "3. Checkout Book\n", outContent.toString());
    }

    @Test
    public void shouldCallDoOperationOnQuitMenuOperationWhenQuitOptionIsChosen() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        options.add("2. Quit");
        options.add("3. Checkout Book");
        InputReader inputReader = mock(InputReader.class);
        Library library = mock(Library.class);
        Map<String, MenuOption> optionsMap = new HashMap<String, MenuOption>();
        ListBooksMenuOption listBooksMenuOption = mock(ListBooksMenuOption.class);
        InvalidMenuOption invalidMenuOption = mock(InvalidMenuOption.class);
        QuitMenuOption quitMenuOption = mock(QuitMenuOption.class);
        optionsMap.put("1", listBooksMenuOption);
        optionsMap.put("2", quitMenuOption);
        optionsMap.put("invalid", invalidMenuOption);
        MainMenu mainMenu = new MainMenu(options, inputReader, optionsMap);

        when(inputReader.read()).thenReturn("2");
        mainMenu.interactWithUser();

        verify(quitMenuOption).doOperation();
    }

    @Test
    public void shouldCallCheckoutMenuOptionDoOperationWhenCheckoutMenuOptionIsChosen() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        options.add("2. Quit");
        options.add("3. Checkout Book");
        InputReader inputReader = mock(InputReader.class);
        Library library = mock(Library.class);
        Map<String, MenuOption> optionsMap = new HashMap<String, MenuOption>();
        ListBooksMenuOption listBooksMenuOption = mock(ListBooksMenuOption.class);
        InvalidMenuOption invalidMenuOption = mock(InvalidMenuOption.class);
        CheckoutBookMenuOption checkoutBookMenuOption = mock(CheckoutBookMenuOption.class);
        optionsMap.put("1", listBooksMenuOption);
        optionsMap.put("invalid", invalidMenuOption);
        optionsMap.put("3", checkoutBookMenuOption);
        MainMenu mainMenu = new MainMenu(options, inputReader, optionsMap);

        when(inputReader.read()).thenReturn("3");
        mainMenu.interactWithUser();

        verify(checkoutBookMenuOption).doOperation();
    }

    @Test
    public void shouldCallCheckInMenuOptionDoOperationWhenCheckInMenuOptionIsChosen() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        options.add("2. Quit");
        options.add("3. Checkout Book");
        InputReader inputReader = mock(InputReader.class);
        Library library = mock(Library.class);
        Map<String, MenuOption> optionsMap = new HashMap<String, MenuOption>();
        ListBooksMenuOption listBooksMenuOption = mock(ListBooksMenuOption.class);
        InvalidMenuOption invalidMenuOption = mock(InvalidMenuOption.class);
        CheckoutBookMenuOption checkoutBookMenuOption = mock(CheckoutBookMenuOption.class);
        CheckInBookMenuOption checkInBookMenuOption = mock(CheckInBookMenuOption.class);
        optionsMap.put("1", listBooksMenuOption);
        optionsMap.put("invalid", invalidMenuOption);
        optionsMap.put("3", checkoutBookMenuOption);
        optionsMap.put("4", checkInBookMenuOption);
        MainMenu mainMenu = new MainMenu(options, inputReader, optionsMap);

        when(inputReader.read()).thenReturn("4");
        mainMenu.interactWithUser();

        verify(checkInBookMenuOption).doOperation();
    }
}
