package com.thoughtworks.biblioteca;

import org.junit.Test;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class MainMenuTest {

    @Test
    public void shouldInvokeReadFromInputReaderAfterDisplayingOptions() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        InputReader inputReader = mock(InputReader.class);
        Parser parser = mock(Parser.class);
        MainMenu mainMenu = new MainMenu(options, inputReader, parser);

        when(inputReader.read()).thenReturn("*");
        when(parser.parse(anyString())).thenReturn(new InvalidMenuOption("Select a valid option!"));
        mainMenu.interactWithUser();

        verify(inputReader).read();
    }

    @Test
    public void shouldInvokeParserParseAfterTakingInput(){
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        InputReader inputReader = mock(InputReader.class);
        Parser parser = mock(Parser.class);
        MainMenu mainMenu = new MainMenu(options, inputReader, parser);

        when(inputReader.read()).thenReturn("*");
        when(parser.parse(anyString())).thenReturn(new InvalidMenuOption("Select a valid option!"));
        mainMenu.interactWithUser();

        verify(parser).parse(anyString());
    }
}
