package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BooksStatusMenuOptionTest {

    @Test
    public void shouldCallLibraryCheckOutInformationWhenDoOperationIsCalled() {
        Library library = mock(Library.class);
        ConsoleDisplayFactory consoleDisplayFactory = mock(ConsoleDisplayFactory.class);
        BooksStatusMenuOption booksStatusMenuOption = new BooksStatusMenuOption(library, consoleDisplayFactory);

        when(consoleDisplayFactory.getNewConsoleDisplay(anyString())).thenReturn(new ConsoleDisplay("doesn't matter"));
        when(library.bookCheckOutInformation()).thenReturn("doesn't matter");
        booksStatusMenuOption.doOperation();

        verify(library).bookCheckOutInformation();
    }

    @Test
    public void shouldGetNewConsoleDisplayWhenDoOperationIsCalled() {
        Library library = mock(Library.class);
        ConsoleDisplayFactory consoleDisplayFactory = mock(ConsoleDisplayFactory.class);
        BooksStatusMenuOption booksStatusMenuOption = new BooksStatusMenuOption(library, consoleDisplayFactory);

        when(consoleDisplayFactory.getNewConsoleDisplay(anyString())).thenReturn(new ConsoleDisplay("doesn't matter"));
        when(library.bookCheckOutInformation()).thenReturn("doesn't matter");
        booksStatusMenuOption.doOperation();

        verify(consoleDisplayFactory).getNewConsoleDisplay(anyString());
    }
}
