package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BooksStatusMenuOptionTest {

    @Test
    public void shouldCallLibraryCheckOutInformationWhenDoOperationIsCalled() {
        BookLibrary bookLibrary = mock(BookLibrary.class);
        ConsoleDisplayFactory consoleDisplayFactory = mock(ConsoleDisplayFactory.class);
        BooksStatusMenuOption booksStatusMenuOption = new BooksStatusMenuOption(bookLibrary, consoleDisplayFactory);

        when(consoleDisplayFactory.getNewConsoleDisplay(anyString())).thenReturn(new ConsoleDisplay("doesn't matter"));
        when(bookLibrary.bookCheckOutInformation()).thenReturn("doesn't matter");
        booksStatusMenuOption.doOperation();

        verify(bookLibrary).bookCheckOutInformation();
    }

    @Test
    public void shouldGetNewConsoleDisplayWhenDoOperationIsCalled() {
        BookLibrary bookLibrary = mock(BookLibrary.class);
        ConsoleDisplayFactory consoleDisplayFactory = mock(ConsoleDisplayFactory.class);
        BooksStatusMenuOption booksStatusMenuOption = new BooksStatusMenuOption(bookLibrary, consoleDisplayFactory);

        when(consoleDisplayFactory.getNewConsoleDisplay(anyString())).thenReturn(new ConsoleDisplay("doesn't matter"));
        when(bookLibrary.bookCheckOutInformation()).thenReturn("doesn't matter");
        booksStatusMenuOption.doOperation();

        verify(consoleDisplayFactory).getNewConsoleDisplay(anyString());
    }
}
