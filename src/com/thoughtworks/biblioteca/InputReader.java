package com.thoughtworks.biblioteca;

import java.util.Scanner;

/* An input reader takes an input from user and returns it */
public class InputReader {
    private Scanner scanner;

    public InputReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public String read() {
        return scanner.nextLine();
    }
}
