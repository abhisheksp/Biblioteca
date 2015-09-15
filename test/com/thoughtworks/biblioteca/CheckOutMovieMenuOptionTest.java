package com.thoughtworks.biblioteca;

import org.junit.Test;

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
}
