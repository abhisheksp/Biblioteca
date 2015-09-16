package com.thoughtworks.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CheckoutBookMenuOptionTest {

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
    public void shouldCallInputReaderReadWhenDoOperationIsCalled() {
        InputReader inputReader = mock(InputReader.class);
        Library library = mock(Library.class);
        User user = mock(User.class);
        ConsoleDisplayFactory consoleDisplayFactory = mock(ConsoleDisplayFactory.class);
        CheckoutBookMenuOption checkoutBookMenuOption = new CheckoutBookMenuOption(inputReader, library, user, consoleDisplayFactory);

        checkoutBookMenuOption.doOperation();

        verify(inputReader).read();
    }

    @Test
    public void shouldCallLibraryCheckoutWithGivenBookWhenDoOperationIsCalled() {
        InputReader inputReader = mock(InputReader.class);
        Library library = mock(Library.class);
        User user = mock(User.class);
        ConsoleDisplayFactory consoleDisplayFactory = mock(ConsoleDisplayFactory.class);
        CheckoutBookMenuOption checkoutBookMenuOption = new CheckoutBookMenuOption(inputReader, library, user, consoleDisplayFactory);
        ArgumentCaptor<Book> argumentCaptor = ArgumentCaptor.forClass(Book.class);
        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);

        checkoutBookMenuOption.doOperation();

        verify(library).checkOut(argumentCaptor.capture(), userArgumentCaptor.capture());
    }
}
