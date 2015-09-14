package com.thoughtworks.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class InvalidMenuOptionTest {

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
    public void shouldCallDisplayOnConsoleDisplayWithInvalidMessageWhenAnInvalidOptionIsChosen() {
        ConsoleDisplayFactory consoleDisplayFactory = mock(ConsoleDisplayFactory.class);
        ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
        InvalidMenuOption invalidMenuOption = new InvalidMenuOption("Select a valid option!", consoleDisplayFactory);

        when(consoleDisplayFactory.getNewConsoleDisplay(anyString())).thenReturn(consoleDisplay);
        invalidMenuOption.doOperation();

        verify(consoleDisplay).display();
    }
}
