package com.thoughtworks.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckOutMovieMenuOptionTest {

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
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        ConsoleDisplayFactory consoleDisplayFactory = mock(ConsoleDisplayFactory.class);
        CheckOutMovieMenuOption checkOutMovieMenuOption = new CheckOutMovieMenuOption(inputReader, movieLibrary, consoleDisplayFactory);

        when(consoleDisplayFactory.getNewConsoleDisplay(anyString())).thenReturn(new ConsoleDisplay("doesn't matter"));
        checkOutMovieMenuOption.doOperation();

        verify(inputReader).read();
    }

    @Test
    public void shouldCallMovieLibraryCheckoutWithGivenMovieWhenDoOperationIsCalled() {
        InputReader inputReader = mock(InputReader.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        ConsoleDisplayFactory consoleDisplayFactory = mock(ConsoleDisplayFactory.class);
        CheckOutMovieMenuOption checkOutMovieMenuOption = new CheckOutMovieMenuOption(inputReader, movieLibrary, consoleDisplayFactory);
        ArgumentCaptor<Movie> argumentCaptor = ArgumentCaptor.forClass(Movie.class);

        when(consoleDisplayFactory.getNewConsoleDisplay(anyString())).thenReturn(new ConsoleDisplay("doesn't matter"));
        checkOutMovieMenuOption.doOperation();

        verify(movieLibrary).checkOut(argumentCaptor.capture());
    }

    @Test
    public void shouldDisplaySuccessAfterSuccessfulCheckout() {
        InputReader inputReader = mock(InputReader.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        ConsoleDisplayFactory consoleDisplayFactory = mock(ConsoleDisplayFactory.class);
        CheckOutMovieMenuOption checkOutMovieMenuOption = new CheckOutMovieMenuOption(inputReader, movieLibrary, consoleDisplayFactory);
        ArgumentCaptor<Movie> argumentCaptor = ArgumentCaptor.forClass(Movie.class);

        when(consoleDisplayFactory.getNewConsoleDisplay(anyString())).thenReturn(new ConsoleDisplay("Thank you! Enjoy the movie"));
        when(movieLibrary.checkOut(argumentCaptor.capture())).thenReturn(true);
        checkOutMovieMenuOption.doOperation();

        assertEquals("Thank you! Enjoy the movie\n" +
                "Thank you! Enjoy the movie\n", outContent.toString());
    }

    @Test
    public void shouldDisplayUnsuccessfulMessageAfterUnsuccessfulCheckout() {
        InputReader inputReader = mock(InputReader.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        ConsoleDisplayFactory consoleDisplayFactory = mock(ConsoleDisplayFactory.class);
        CheckOutMovieMenuOption checkOutMovieMenuOption = new CheckOutMovieMenuOption(inputReader, movieLibrary, consoleDisplayFactory);
        ArgumentCaptor<Movie> argumentCaptor = ArgumentCaptor.forClass(Movie.class);

        when(consoleDisplayFactory.getNewConsoleDisplay(anyString())).thenReturn(new ConsoleDisplay("That movie is not available."));
        when(movieLibrary.checkOut(argumentCaptor.capture())).thenReturn(false);
        checkOutMovieMenuOption.doOperation();

        assertEquals("That movie is not available.\n" +
                "That movie is not available.\n", outContent.toString());
    }
}
