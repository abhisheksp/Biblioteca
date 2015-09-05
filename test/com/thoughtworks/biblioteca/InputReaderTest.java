package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static junit.framework.TestCase.assertEquals;

public class InputReaderTest {

    @Test
    public void shouldReturnFooStringWhenFooInputByTheUser() {
        String input = "Foo";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        Scanner scanner = new Scanner(System.in);
        InputReader inputReader = new InputReader(scanner);

        assertEquals("Foo", inputReader.read());
    }
}
