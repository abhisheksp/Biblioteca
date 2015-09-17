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
        BookLibrary bookLibrary = mock(BookLibrary.class);
        User user = mock(User.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        CheckInBookMenuOption checkInBookMenuOption = new CheckInBookMenuOption(inputReader, bookLibrary, user, consoleDisplayFactory);

        checkInBookMenuOption.doOperation();

        verify(inputReader).read();
    }

    @Test
    public void shouldCallLibraryCheckoutWithGivenBookWhenDoOperationIsCalled() {
        InputReader inputReader = mock(InputReader.class);
        BookLibrary bookLibrary = mock(BookLibrary.class);
        User user = mock(User.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        CheckInBookMenuOption checkInBookMenuOption = new CheckInBookMenuOption(inputReader, bookLibrary, user, consoleDisplayFactory);
        ArgumentCaptor<Book> argumentCaptor = ArgumentCaptor.forClass(Book.class);
        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);

        checkInBookMenuOption.doOperation();

        verify(bookLibrary).checkIn(argumentCaptor.capture(), userArgumentCaptor.capture());
    }

    @Test
    public void shouldDisplaySuccessMessageAfterSuccessfulCheckIn() {
        InputReader inputReader = mock(InputReader.class);
        BookLibrary bookLibrary = mock(BookLibrary.class);
        User user = mock(User.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        CheckInBookMenuOption checkInBookMenuOption = new CheckInBookMenuOption(inputReader, bookLibrary, user, consoleDisplayFactory);
        ArgumentCaptor<Book> argumentCaptor = ArgumentCaptor.forClass(Book.class);
        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);

        when(bookLibrary.checkIn(argumentCaptor.capture(), userArgumentCaptor.capture())).thenReturn(true);
        checkInBookMenuOption.doOperation();

        assertEquals("Enter Book Name : \n" +
                "Thank you for returning the book.\n", outContent.toString());
    }

    @Test
    public void shouldDisplayUnsuccessfulMessageAfterUnsuccessfulCheckIn() {
        InputReader inputReader = mock(InputReader.class);
        BookLibrary bookLibrary = mock(BookLibrary.class);
        User user = mock(User.class);
        ConsoleDisplayFactory consoleDisplayFactory = new ConsoleDisplayFactory();
        CheckInBookMenuOption checkInBookMenuOption = new CheckInBookMenuOption(inputReader, bookLibrary, user, consoleDisplayFactory);
        ArgumentCaptor<Book> argumentCaptor = ArgumentCaptor.forClass(Book.class);
        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);

        when(bookLibrary.checkIn(argumentCaptor.capture(), userArgumentCaptor.capture())).thenReturn(false);
        checkInBookMenuOption.doOperation();

        assertEquals("Enter Book Name : \n" +
                "That is not a valid book to return.\n", outContent.toString());
    }
}