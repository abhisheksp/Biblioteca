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
        CheckoutBookMenuOption checkoutBookMenuOption = new CheckoutBookMenuOption(inputReader, library);

        checkoutBookMenuOption.doOperation();

        verify(inputReader).read();
    }

    @Test
    public void shouldCallLibraryCheckoutWithGivenBookWhenDoOperationIsCalled() {
        InputReader inputReader = mock(InputReader.class);
        Library library = mock(Library.class);
        CheckoutBookMenuOption checkoutBookMenuOption = new CheckoutBookMenuOption(inputReader, library);
        ArgumentCaptor<Book> argumentCaptor = ArgumentCaptor.forClass(Book.class);

        checkoutBookMenuOption.doOperation();

        verify(library).checkOut(argumentCaptor.capture());
    }

    @Test
    public void shouldDisplaySuccessAfterSuccessfulCheckout() {
        InputReader inputReader = mock(InputReader.class);
        Library library = mock(Library.class);
        CheckoutBookMenuOption checkoutBookMenuOption = new CheckoutBookMenuOption(inputReader, library);
        ArgumentCaptor<Book> argumentCaptor = ArgumentCaptor.forClass(Book.class);

        when(library.checkOut(argumentCaptor.capture())).thenReturn(true);
        checkoutBookMenuOption.doOperation();

        assertEquals("Thank you! Enjoy the book\n", outContent.toString());
    }


    @Test
    public void shouldDisplayUnsuccessfulMessageAfterUnsuccessfulCheckout() {
        InputReader inputReader = mock(InputReader.class);
        Library library = mock(Library.class);
        CheckoutBookMenuOption checkoutBookMenuOption = new CheckoutBookMenuOption(inputReader, library);
        ArgumentCaptor<Book> argumentCaptor = ArgumentCaptor.forClass(Book.class);

        when(library.checkOut(argumentCaptor.capture())).thenReturn(false);
        checkoutBookMenuOption.doOperation();

        assertEquals("That book is not available.\n", outContent.toString());
    }
}
