package com.thoughtworks.biblioteca;

import java.util.Scanner;

/* InputReader factory manufactures a default InputReader and returns it */
public class InputReaderFactory {

    private Scanner scanner;

    public InputReaderFactory() {
        this.scanner = new Scanner(System.in);
    }

    public InputReader getDefaultInputReader() {
        return new InputReader(this.scanner);
    }
}
