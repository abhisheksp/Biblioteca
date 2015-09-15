package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ListMoviesMenuOptionTest {

    @Test
    public void shouldCallMovieLibraryFormatWhenDoOperationIsCalled(){
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        ConsoleDisplayFactory consoleDisplayFactory = mock(ConsoleDisplayFactory.class);
        ListMoviesMenuOption listMoviesMenuOption = new ListMoviesMenuOption(movieLibrary, consoleDisplayFactory);

        when(consoleDisplayFactory.getNewConsoleDisplay(anyString())).thenReturn(new ConsoleDisplay("blah"));
        listMoviesMenuOption.doOperation();

        verify(movieLibrary).format();
    }
}
