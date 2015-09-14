package com.thoughtworks.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckInBookMenuOptionTest {

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
        CheckInBookMenuOption checkInBookMenuOption = new CheckInBookMenuOption(inputReader, library);

        checkInBookMenuOption.doOperation();

        verify(inputReader).read();
    }

    @Test
    public void shouldCallLibraryCheckoutWithGivenBookWhenDoOperationIsCalled() {
        InputReader inputReader = mock(InputReader.class);
        Library library = mock(Library.class);
        CheckInBookMenuOption checkInBookMenuOption = new CheckInBookMenuOption(inputReader, library);
        ArgumentCaptor<Book> argumentCaptor = ArgumentCaptor.forClass(Book.class);

        checkInBookMenuOption.doOperation();

        verify(library).checkIn(argumentCaptor.capture());
    }

    @Test
    public void shouldDisplaySuccessMessageAfterSuccessfulCheckIn() {
        InputReader inputReader = mock(InputReader.class);
        Library library = mock(Library.class);
        CheckInBookMenuOption checkInBookMenuOption = new CheckInBookMenuOption(inputReader, library);
        ArgumentCaptor<Book> argumentCaptor = ArgumentCaptor.forClass(Book.class);

        when(library.checkIn(argumentCaptor.capture())).thenReturn(true);
        checkInBookMenuOption.doOperation();

        assertEquals("Thank you for returning the book.\n", outContent.toString());
    }

    @Test
    public void shouldDisplayUnsuccessfulMessageAfterUnsuccessfulCheckIn() {
        InputReader inputReader = mock(InputReader.class);
        Library library = mock(Library.class);
        CheckInBookMenuOption checkInBookMenuOption = new CheckInBookMenuOption(inputReader, library);
        ArgumentCaptor<Book> argumentCaptor = ArgumentCaptor.forClass(Book.class);

        when(library.checkIn(argumentCaptor.capture())).thenReturn(false);
        checkInBookMenuOption.doOperation();

        assertEquals("That is not a valid book to return.\n", outContent.toString());
    }
}