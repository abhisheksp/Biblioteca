package com.thoughtworks.biblioteca;

import org.junit.*;
import java.io.*;
import java.util.*;

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
        InvalidMenuOption invalidMenuOption = new InvalidMenuOption("Select a valid option!");
        BookList bookList = mock(BookList.class);
        Map<String, Option> optionsMap = new HashMap<String, Option>();
        optionsMap.put("1", bookList);
        optionsMap.put("invalid", invalidMenuOption);
        MainMenu mainMenu = new MainMenu(options, inputReader, optionsMap);

        mainMenu.interactWithUser();

        assertEquals("1. List Books\n"+ "Select a valid option!\n", outContent.toString());
    }

    @Test
    public void shouldInvokeReadFromInputReaderAfterDisplayingOptions() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        InputReader inputReader = mock(InputReader.class);
        BookList bookList = mock(BookList.class);
        InvalidMenuOption invalidMenuOption = new InvalidMenuOption("Select a valid option!");
        Map<String, Option> optionsMap = new HashMap<String, Option>();
        optionsMap.put("1", bookList);
        optionsMap.put("invalid", invalidMenuOption);
        MainMenu mainMenu = new MainMenu(options, inputReader, optionsMap);

        mainMenu.interactWithUser();

        verify(inputReader).read();
        assertEquals("1. List Books\n"+ "Select a valid option!\n", outContent.toString());
    }

    @Test
    public void shouldDelegateToBookListDisplayWhenOptionOneIsChosen() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        String input = "1";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        Scanner scanner = new Scanner(System.in);
        InputReader inputReader = new InputReader(scanner);
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Brief History of Time", "Stephen Hawking", 1988));
        books.add(new Book("Crime and Punishment", "Fyodor Dostoyevsky", 1866));
        books.add(new Book("Seven Minutes", "Irving Wallace", 1969));
        BookList bookList = new BookList(books);
        InvalidMenuOption invalidMenuOption = new InvalidMenuOption("Select a valid option!");
        Map<String, Option> optionsMap = new HashMap<String, Option>();
        optionsMap.put("1", bookList);
        optionsMap.put("invalid", invalidMenuOption);
        MainMenu mainMenu = new MainMenu(options, inputReader, optionsMap);
        System.setIn(System.in);

        mainMenu.interactWithUser();

        assertEquals("1. List Books\n" + "Book\tAuthor\tYear Published\n" + "Brief History of Time\tStephen Hawking\t1988\n" +
                "Crime and Punishment\tFyodor Dostoyevsky\t1866\n" +
                "Seven Minutes\tIrving Wallace\t1969\n", outContent.toString());
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
        BookList bookList = mock(BookList.class);
        InvalidMenuOption invalidMenuOption = new InvalidMenuOption("Select a valid option!");
        Map<String, Option> optionsMap = new HashMap<String, Option>();
        optionsMap.put("1", bookList);
        optionsMap.put("invalid", invalidMenuOption);
        MainMenu mainMenu = new MainMenu(options, inputReader, optionsMap);
        System.setIn(System.in);

        mainMenu.interactWithUser();

        Assert.assertEquals("1. List Books\n" + "Select a valid option!\n", outContent.toString());
    }
}
