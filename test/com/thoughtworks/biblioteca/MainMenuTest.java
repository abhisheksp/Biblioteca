package com.thoughtworks.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class MainMenuTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldInvokeReadFromInputReaderAfterDisplayingOptions() {
        exit.expectSystemExit();

        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        InputReader inputReader = mock(InputReader.class);
        Parser parser = mock(Parser.class);
        MainMenu mainMenu = new MainMenu(options, inputReader, parser);

        when(inputReader.read()).thenReturn("*", "2");
        when(parser.parse(anyString())).thenReturn(new InvalidMenuOption("Select a valid option!"), new QuitMenuOption());
        mainMenu.interactWithUser();

        verify(inputReader).read();
    }

    @Test
    public void shouldInvokeParserParseAfterTakingInput(){
        exit.expectSystemExit();

        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        InputReader inputReader = mock(InputReader.class);
        Parser parser = mock(Parser.class);
        MainMenu mainMenu = new MainMenu(options, inputReader, parser);

        when(inputReader.read()).thenReturn("*", "2");
        when(parser.parse(anyString())).thenReturn(new InvalidMenuOption("Select a valid option!"), new QuitMenuOption());
        mainMenu.interactWithUser();

        verify(parser).parse(anyString());
    }

    @Test
    public void shouldCallDoOperationOnTheMenuOptionReturned(){
        exit.expectSystemExit();

        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        InputReader inputReader = mock(InputReader.class);
        Parser parser = mock(Parser.class);
        QuitMenuOption quitMenuOption = new QuitMenuOption();
        MainMenu mainMenu = new MainMenu(options, inputReader, parser);

        when(inputReader.read()).thenReturn("2");
        when(parser.parse(anyString())).thenReturn(quitMenuOption);
        mainMenu.interactWithUser();

        verify(quitMenuOption).doOperation();
    }
}
