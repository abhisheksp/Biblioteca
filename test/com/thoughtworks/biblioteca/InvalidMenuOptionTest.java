package com.thoughtworks.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

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
    public void shouldDisplaySelectAValidOptionWhenAnInvalidOptionIsChosen(){
        InvalidMenuOption invalidMenuOption = new InvalidMenuOption("Select a valid option!");

        invalidMenuOption.doOperation();

        assertEquals("Select a valid option!\n", outContent.toString());
    }
}
