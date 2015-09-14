package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InputReaderFactoryTest {

    @Test
    public void shouldReturnDefaultInputReader() {
        InputReaderFactory inputReaderFactory = new InputReaderFactory();

        assertEquals(InputReader.class, inputReaderFactory.getDefaultInputReader().getClass());
    }
}
