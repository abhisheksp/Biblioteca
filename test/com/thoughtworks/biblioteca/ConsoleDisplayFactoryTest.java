package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConsoleDisplayFactoryTest {

    @Test
    public void shouldReturnNewConsoleDisplayWithInitalState() {
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();

        assertEquals(ConsoleDisplay.class, consoleDisplayFactory.getNewConsoleDisplay("Message").getClass());
    }
}
