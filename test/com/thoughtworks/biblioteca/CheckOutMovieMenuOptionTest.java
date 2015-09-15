package com.thoughtworks.biblioteca;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CheckOutMovieMenuOptionTest {

    @Test
    public void shouldCallInputReaderReadWhenDoOperationIsCalled() {
        InputReader inputReader = mock(InputReader.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        CheckOutMovieMenuOption checkOutMovieMenuOption = new CheckOutMovieMenuOption(inputReader, movieLibrary);

        checkOutMovieMenuOption.doOperation();

        verify(inputReader).read();
    }

    @Test
    public void shouldCallMovieLibraryCheckoutWithGivenMovieWhenDoOperationIsCalled() {
        InputReader inputReader = mock(InputReader.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        CheckOutMovieMenuOption checkOutMovieMenuOption = new CheckOutMovieMenuOption(inputReader, movieLibrary);
        ArgumentCaptor<Movie> argumentCaptor = ArgumentCaptor.forClass(Movie.class);

        checkOutMovieMenuOption.doOperation();

        verify(movieLibrary).checkOut(argumentCaptor.capture());
    }
}
