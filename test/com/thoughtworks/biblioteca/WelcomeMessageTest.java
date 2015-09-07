package com.thoughtworks.biblioteca;

import org.junit.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class WelcomeMessageTest {

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
    public void shouldDisplayWelcomeMessageWhenWelcomeStringIsPassed() {
        WelcomeMessage welcomeMessage = new WelcomeMessage("Welcome");

        welcomeMessage.display();

        assertEquals("Welcome\n", outContent.toString());
    }
}
